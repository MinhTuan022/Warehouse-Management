/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class dNhanVien {

    private static dNhanVien instance;

    public static dNhanVien getInstance() {
        if (instance == null) {
            instance = new dNhanVien();
        }
        return instance;
    }

    public dNhanVien() {
    }
    
    //Lấy danh sách thông tin từ bảng nhân viên
    public ArrayList<NhanVien> getListNhanVien() {
        ArrayList<NhanVien> result = new ArrayList<>();
        String query = "select * from NHANVIEN Where ID_Xoa = 1";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new NhanVien(rs.getInt("ID_Nv"),
                        rs.getString("Ten_Nv"),
                        rs.getString("Sdt_Nv"),
                        rs.getString("CMND"),
                        rs.getString("Ngay_Sinh"),
                        rs.getInt("ID_Xoa")));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return result;
    } 
    
    // them ncc
public boolean insertNhanvien(String tennv, String sdt, String cmnd, String ngaysinh, int ID_Nv) {

        if ("".equals(tennv) || "".equals(sdt) || "".equals(cmnd) || "".equals(ngaysinh)) {
            JOptionPane.showMessageDialog(null,
                    "Chưa điền đầy đủ thông tin",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        try {
            //ngaysinh = DAO.DateTimeNow.getIntance().Now;
            DAO.ConnectionDB.getIntance().open();
            PreparedStatement ps = DAO.ConnectionDB.getIntance().getconn().prepareStatement("INSERT INTO NHANVIEN(Ten_Nv, Sdt_Nv, CMND, Ngay_Sinh, ID_Xoa) VALUES (?,?,?,?,1)");
            
            ps.setString(1,tennv);
            ps.setString(2, sdt);
            ps.setString(3, cmnd);
            ps.setString(4, ngaysinh);
            ps.executeUpdate();
            DAO.ConnectionDB.getIntance().close();
            JOptionPane.showMessageDialog(null,
                    "Thêm nhà cung cấp mới thành công.",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Thêm nhà cung cấp mới thành công.",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
                    
        }
        return true;
    }
    public boolean UpdateNhanVien(int IDNv,
            String TenNv,
            
            String Sdt,
            String cccd,
            String ngaysinh
            ) {
        if ("".equals(TenNv) || "".equals(Sdt) ||  "".equals(cccd) || "".equals(ngaysinh)) {
            JOptionPane.showMessageDialog(null,
                    "Chưa điền đầy đủ thông tin",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false; 
        }
        String query = "UPDATE NHANVIEN SET Ten_Nv=N'" + TenNv + "',Sdt_Nv='" + Sdt + "',CMND='" + cccd + "',Ngay_Sinh='" + ngaysinh + "' WHERE ID_Nv=" + IDNv;
        //System.out.println(query);
        ArrayList<Object> arr = new ArrayList<>();
        ConnectionDB.getIntance().open();
        ConnectionDB.getIntance().excuteUpdate(query, arr);
        ConnectionDB.getIntance().close();
        JOptionPane.showMessageDialog(null,
                "Sửa thông tin nhân vien thành công",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
       
        return true;
        
    }
public boolean HuyNhanVien(int id_nv,int ID_Nv)
    {
        String query = "UPDATE NHANVIEN SET ID_Xoa=0 WHERE ID_Nv=" + id_nv;
        //System.out.println(query);
        ArrayList<Object> arr = new ArrayList<>();
        ConnectionDB.getIntance().open();
        ConnectionDB.getIntance().excuteUpdate(query, arr);
        ConnectionDB.getIntance().close();
        JOptionPane.showMessageDialog(null,
                "Xóa thông tin nhà cung cấp thành công",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
        
        return true;
    }
    public ArrayList<NhanVien> get20NhanVien(ArrayList<NhanVien> arr, long Trang) {
        ArrayList<NhanVien> result = new ArrayList<>();

        for (long i = (Trang * 20 - 20); i < (Trang * 20); i++) {
            if (i == arr.size()) {
                break;
            }
            result.add(arr.get((int) i));
        }
        return result;
    }
 
     //Lấy ra 1 nguồn cung cấp bằng id
    public NhanVien getNhanVien(int ID_Nv) {
        String query = "SELECT * FROM NHANVIEN WHERE ID_Nv='" + ID_Nv + "'";
        ArrayList<Object> arr = new ArrayList<>();
        NhanVien ncc = null;
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                ncc = new NhanVien(
                        rs.getInt("ID_Nv"),
                        rs.getString("Ten_Nv"),
                        rs.getString("Sdt_Nv"),
                        rs.getString("CMND"),
                        rs.getString("Ngay_Sinh"),
                        rs.getInt("ID_Xoa")
                       
                );

            } else {
                return null;
            }
            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return ncc;
    }

}
