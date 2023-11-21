/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import DTO.LoaiSanPham;
import DTO.ViTri;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class dVitri {
    private static dVitri instance;

    public static dVitri getInstance() {
        if (instance == null) {
            instance = new dVitri();
        }
        return instance;
    }

    public dVitri() {
    }
    public ArrayList<ViTri> getListViTri() {
        ArrayList<ViTri> result = new ArrayList<>();
        String query = "select * from ViTri where ID_Xoa=1";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new ViTri(rs.getInt("ID_Vi_Tri"), rs.getString("Ten_Vi_Tri"), rs.getInt("ID_Xoa"), rs.getInt("ID_Loai_Sp")));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return result;
    }
     public boolean XoaViTri(int id, int ID_Nv)
    {
        String query = "UPDATE VITRI SET ID_Xoa="+0+" WHERE ID_Vi_Tri="+id;
        try {
            ConnectionDB.getIntance().open();
            ConnectionDB.getIntance().excuteQuery(query);
            ConnectionDB.getIntance().close();
            JOptionPane.showMessageDialog(null, "Xóa vi tri thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
           
            JOptionPane.showMessageDialog(null, "Xóa vi tri Thất bại", "Thông báo", 1);
             return false;
        }
        return true;
    }
     public ViTri getViTri(int Id_Vi_Tri) {
        ViTri result = null;
        String query = "select *from ViTri where ID_Vi_Tri = ?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(Id_Vi_Tri);
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result = (new ViTri(rs.getInt("Id_Vi_Tri"),
                        rs.getString("Ten_Vi_Tri"),
                        rs.getInt("ID_Xoa"),
                        rs.getInt("ID_Loai_Sp")));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return result;
    }
     public boolean insertViTri(String Ten_Vi_Tri,String Ten_Loai_Sp,int ID_Nv)
    {   
        LoaiSanPham lsp = DAO.dLoaiSanPham.getInstance().getLoaiSanPham(Ten_Loai_Sp);
        String query = " INSERT INTO VITRI(Ten_Vi_Tri, ID_Xoa, ID_Loai_Sp) VALUES ('"+Ten_Vi_Tri+"',1,"+lsp.ID_Loai_Sp+")";
        
        try {
            ConnectionDB.getIntance().open();
            ConnectionDB.getIntance().excuteQuery(query);
            ConnectionDB.getIntance().close();
            JOptionPane.showMessageDialog(null, "Thêm vi tri thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
           
            JOptionPane.showMessageDialog(null, "Thêm vi tri Thất bại", "Thông báo", 1);
             return false;
        }
        return true;
    }
     public boolean updateViTri(String Ten_Vi_Tri,String Ten_Loai_Sp,int ID_Nv,int ID)
    {
        LoaiSanPham lsp = DAO.dLoaiSanPham.getInstance().getLoaiSanPham(Ten_Loai_Sp);
        
        String query = "UPDATE VITRI SET Ten_Vi_Tri='"+Ten_Vi_Tri+"',ID_Loai_Sp="+lsp.ID_Loai_Sp+" WHERE ID_Vi_Tri="+ID;
        try {
            ConnectionDB.getIntance().open();
            ConnectionDB.getIntance().excuteQuery(query);
            ConnectionDB.getIntance().close();
            JOptionPane.showMessageDialog(null, "Sửa vi tri thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
           
            JOptionPane.showMessageDialog(null, "Sửa vi tri Thất bại", "Thông báo", 1);
             return false;
        }
        return true;
    }
}
    