/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.LoaiSanPham;
import DTO.LoaiSanPham_jTreeChart;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class dLoaiSanPham {
    private static dLoaiSanPham instance;

    public static dLoaiSanPham getInstance() {
        if (instance == null) {
            instance = new dLoaiSanPham();
        }
        return instance;
    }

    public dLoaiSanPham() {
    }
    
    //Lấy ra danh sách thông tin từ bảng loại sản phẩm
    public ArrayList<LoaiSanPham> getListLoaiSanPham() {
        ArrayList<LoaiSanPham> result = new ArrayList<>();
        String query = "select * from LOAISANPHAM";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new LoaiSanPham(rs.getInt("ID_Loai_Sp"), rs.getString("Ten_Loai_Sp"), rs.getInt("ID_Xoa")));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return result;
    }

    //Lấy ra 1 loại sản phẩm từ id
    public LoaiSanPham getLoaiSanPham(int id_loai_sp) {
        LoaiSanPham result = null;
        String query = "select *from LOAISANPHAM where ID_Loai_Sp = ?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(id_loai_sp);
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result = (new LoaiSanPham(rs.getInt("Id_Loai_Sp"), rs.getString("Ten_Loai_Sp"), rs.getInt("ID_Xoa")));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return result;
    } 
    
    //Lấy ra loại sản phẩm từ tên loại sản phẩm
    public LoaiSanPham getIDLoaiSanPham(String Ten_Loai_Sp) {
        LoaiSanPham result = null;
        String query = "select *from LOAISANPHAM where Ten_Loai_Sp = ?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(Ten_Loai_Sp);
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result = (new LoaiSanPham(rs.getInt("ID_Loai_Sp"), rs.getString("Ten_Loai_Sp"), rs.getInt("ID_Xoa")));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return result;
        }
    
public LoaiSanPham getLoaiSanPham(String Ten_Loai_Sp) {
        LoaiSanPham result = new LoaiSanPham();
        String query = "select * from LOAISANPHAM where ID_Xoa=1 and Ten_Loai_Sp ='"+ Ten_Loai_Sp+"'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result=new LoaiSanPham(rs.getInt("ID_Loai_Sp"),
                rs.getString("Ten_Loai_Sp"),
                rs.getInt("ID_Xoa"));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex); 
        }

        return result;
    }

public boolean insertLoaiSanPham (String Ten_Loai_Sp, int ID_Nv) {
        if ("".equals(Ten_Loai_Sp)) {
            JOptionPane.showMessageDialog(null,
                    "Chưa điền đầy đủ thông tin",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            DAO.ConnectionDB.getIntance().open();
            PreparedStatement ps = DAO.ConnectionDB.getIntance().getconn().prepareStatement("INSERT INTO LOAISANPHAM(Ten_Loai_Sp, ID_Xoa) VALUES (?,1)");
            ps.setString(1, Ten_Loai_Sp);
            ps.executeUpdate();
            DAO.ConnectionDB.getIntance().close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }
    public boolean updateLoaiSanPham (String Ten_Loai_Sp, int ID_Nv, int ID_Loai_Sp) {
        String query = "UPDATE LOAISANPHAM SET Ten_Loai_Sp='"+Ten_Loai_Sp+"' WHERE ID_Loai_Sp="+ID_Loai_Sp;
        try {
            ConnectionDB.getIntance().open();
            ConnectionDB.getIntance().excuteQuery(query);
            ConnectionDB.getIntance().close();
            JOptionPane.showMessageDialog(null, JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
           
             return false;
        }
        return true;
    }
    
//Lấy danh sách loại sản phẩm từ nhiều bảng khác nhau để làm biểu đồ tròn
    public ArrayList<LoaiSanPham_jTreeChart> getListLoaiSanPham_jTreeChart() {
        ArrayList<LoaiSanPham_jTreeChart> result = new ArrayList<>();
        String query = "SELECT LOAISANPHAM.Ten_Loai_Sp , SUM((CHITIETLOSANPHAM.So_Luong_Sp*CHITIETPHIEUNHAP.So_Luong_Lo )) AS So_Luong\n" +
"FROM CHITIETLOSANPHAM,SANPHAM,LOAISANPHAM , CHITIETPHIEUNHAP, LOSANPHAM\n" +
"WHERE CHITIETLOSANPHAM.ID_Sp = SANPHAM.ID_Sp \n" +
"AND SANPHAM.ID_Loai_Sp = LOAISANPHAM.ID_Loai_Sp\n" +
"AND CHITIETPHIEUNHAP.ID_Phieu_Nhap = LOSANPHAM.ID_Phieu_Nhap\n" +
"GROUP BY LOAISANPHAM.Ten_Loai_Sp  ORDER BY So_Luong DESC";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new LoaiSanPham_jTreeChart(rs.getString("Ten_Loai_Sp"), rs.getLong("So_Luong")));
            }
            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }
        return result;
    }
}
