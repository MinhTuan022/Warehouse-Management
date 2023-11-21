/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVien;
import DTO.TaiKhoan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author ADMIN
 */
public class DangNhap {
    private static DangNhap instance;

    public static DangNhap getInstance() {
        if (instance == null) {
            instance = new DangNhap();
        }
        return instance;
    }

    public DangNhap() {
    }

    //Lấy danh sách tài khoản
  public ArrayList<TaiKhoan> getListTaiKhoan() {
        ArrayList<TaiKhoan> result = new ArrayList<>();
        String query = "select *from TAIKHOAN WHERE ID_Xoa = 1";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new TaiKhoan(rs.getInt("ID_Tk"),
                        rs.getInt("ID_Nv"),
                        rs.getString("Ten_Tai_Khoan"),
                        rs.getString("Mat_Khau"),
                        rs.getInt("Loai"),
                        rs.getInt("ID_Xoa")
                ));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return result;
    }

    //Kiểm tra khi đăng nhập
    public boolean KiemTraDangNhap(String User, String Pass) {
        ArrayList<Object> arr = new ArrayList<>();

        String query = "SELECT * FROM TAIKHOAN WHERE Ten_Tai_Khoan = '" + User + "' "+ "and Mat_Khau= '" + Pass +"'";
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                return true;
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }
        return false;
    }
    public TaiKhoan getTaiKhoan(String User, String Pass) {
        TaiKhoan result = null;
        String query = "SELECT * FROM TAIKHOAN WHERE Ten_Tai_Khoan='" + User + "' and Mat_Khau='" + Pass + "'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {

                result = (new TaiKhoan(rs.getInt("ID_Tk"),
                        rs.getInt("ID_Nv"),
                        rs.getString("Ten_Tai_Khoan"),
                        rs.getString("Mat_Khau"),
                        rs.getInt("Loai"),
                        rs.getInt("ID_Xoa")
                ));
            } else {
                result = null;
            }
            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }
        return result;
    }
    public TaiKhoan getTaiKhoan(int id_nhanvien) {
        TaiKhoan result = null;
        String query = "SELECT * FROM TAIKHOAN WHERE ID_Tk= '" + id_nhanvien + "'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result = (new TaiKhoan(rs.getInt("ID_Tk"),
                        rs.getInt("ID_Nv"),
                        rs.getString("Ten_Tai_Khoan"),
                        rs.getString("Mat_Khau"),
                        rs.getInt("Loai"),
                        rs.getInt("ID_Xoa")
                ));
            } else {
                return null;
            }
            ConnectionDB.getIntance().close();

        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }
        return result;
    }
    

    //Lấy thông tin nhân viên bằng id_nv
    public NhanVien getNhanVien(int ID_Nv) {
        String query = "SELECT * FROM NHANVIEN WHERE ID_Nv= '" + ID_Nv + "'";
        ArrayList<Object> arr = new ArrayList<>();
        NhanVien tk = null;
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                tk = (new NhanVien(rs.getInt("ID_Nv"),
                        rs.getString("Ten_Nv"),
                        rs.getString("Sdt_Nv"),
                        rs.getString("CMND"),
                        rs.getString("Ngay_Sinh"),
                        rs.getInt("ID_Xoa")
                ));
                        
                        

            } else {
                return null;
            }
            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return tk;
    }
    
public boolean insertTaiKhoan(String idnv, String tendn, String matkhau, String loai, int ID_Nv) {

        if ("".equals(idnv) || "".equals(tendn) || "".equals(matkhau) || "".equals(loai)) {
            JOptionPane.showMessageDialog(null,
                    "Chưa điền đầy đủ thông tin",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            DAO.ConnectionDB.getIntance().open();
            PreparedStatement ps = DAO.ConnectionDB.getIntance().getconn().prepareStatement("INSERT INTO TAIKHOAN(ID_Nv, Ten_Tai_Khoan, Mat_Khau, Loai, ID_Xoa) VALUES (?,?,?,?,1)");
            
            ps.setString(1,idnv);
            ps.setString(2, tendn);
            ps.setString(3, matkhau);
            ps.setString(4, loai);
            ps.executeUpdate();
            DAO.ConnectionDB.getIntance().close();
            JOptionPane.showMessageDialog(null,
                    "Thêm tài khoản mới thành công.",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "ID Nhân Viên Không Tồn Tại",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
        return true;
    }
public boolean HuyTaiKhoan(int id_tk,int ID_Nv)
    {
        String query = "UPDATE TAIKHOAN SET ID_Xoa=0 WHERE ID_Tk=" + id_tk;
        //System.out.println(query);
        ArrayList<Object> arr = new ArrayList<>();
        ConnectionDB.getIntance().open();
        ConnectionDB.getIntance().excuteUpdate(query, arr);
        ConnectionDB.getIntance().close();
        JOptionPane.showMessageDialog(null,
                "Xóa thông tin tài khoản thành công",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
        
        return true;
    }
    public ArrayList<TaiKhoan> get20TaiKhoan(ArrayList<TaiKhoan> arr, long Trang) {
        ArrayList<TaiKhoan> result = new ArrayList<>();

        for (long i = (Trang * 20 - 20); i < (Trang * 20); i++) {
            if (i == arr.size()) {
                break;
            }
            result.add(arr.get((int) i));
        }
        return result;
    }
}


