/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.SanPham;
import DTO.ThongTinSPHienCo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class dSanPham {
    private static dSanPham instance;

    public static dSanPham getInstance() {
        if (instance == null) {
            instance = new dSanPham();
        }
        return instance;
    }
    public dSanPham() {
    }

    //Lấy ra danh sách thông tin từ bảng sản phẩm
    public ArrayList<SanPham> getListSanPham() {
        ArrayList<SanPham> result = new ArrayList<>();
        String query = "select * from SANPHAM where ID_Xoa = 1";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new SanPham(rs.getInt("ID_Sp"), rs.getString("Ten_Sp"),  rs.getInt("ID_Loai_Sp"),rs.getString("Don_Vi"),rs.getInt("ID_Xoa")));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return result;
    }
//    public ThongTinSPHienCo getThongTinSPHienCo(int id_lo)
//    {
//        ThongTinSPHienCo result= new ThongTinSPHienCo();
//        String query = "SELECT  *\n" +
//                        "FROM LOSANPHAM,SANPHAM, CHITIETLOSANPHAM, CHITIETPHIEUNHAP\n" +
//                        "WHERE LoSANPHAM.ID_Lo_Sp=CHITIETLOSANPHAM.ID_Lo_Sp\n" +
//                        "and SANPHAM.ID_Sp = CHITIETLOSANPHAM.ID_Sp\n" +
//                        "and CHITIETPHIEUNHAP.ID_Phieu_Nhap = LOSANPHAM.ID_Phieu_Nhap and LOSANPHAM.ID_Lo_Sp="+id_lo;
//
//        ArrayList<Object> arr = new ArrayList<>();
//        try {
//            ConnectionDB.getIntance().open();
//            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
//            if (rs.next()) {
//                result= new ThongTinSPHienCo(rs.getInt("So_Luong_Lo"),
//                        rs.getString("Ten_Sp"),
//                        rs.getInt("ID_Lo_Sp"),
//                        rs.getString("HSD"),
//                        rs.getString("NSX"),
//                        rs.getInt("So_Luong_Sp")
//                );
//            }
//            ConnectionDB.getIntance().close();
//        } catch (SQLException ex) {
//            ConnectionDB.getIntance().displayError(ex);
//        }
//        return result;
//    } 
    public ArrayList<ThongTinSPHienCo> getListThongTinSPHienCo()
    {
        ArrayList<ThongTinSPHienCo> result = new ArrayList<>();
        String query = "SELECT CHITIETPHIEUNHAP.So_Luong_Lo, SANPHAM.Ten_Sp, LOSANPHAM.ID_Lo_Sp " +
                        "FROM LOSANPHAM,SANPHAM, CHITIETLOSANPHAM, CHITIETPHIEUNHAP\n" +
                        "WHERE LOSANPHAM.ID_Lo_Sp=CHITIETLOSANPHAM.ID_Lo_Sp\n" +
                        "and SANPHAM.ID_Sp = CHITIETLOSANPHAM.ID_Sp\n" +
                        "and CHITIETPHIEUNHAP.ID_Phieu_Nhap = LOSANPHAM.ID_Phieu_Nhap";

        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result.add( new ThongTinSPHienCo(rs.getInt("So_Luong_Lo"),
                        rs.getString("Ten_Sp"),
                        rs.getInt("ID_Lo_Sp")
//                        rs.getString("HSD"),
//                        rs.getString("NSX"),
//                        rs.getInt("So_Luong_Sp")
                ));
            }
            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }
        return result;
    }    
        //Lấy 1 sản phẩm từ id sản phẩm
   public SanPham getSanPham(int id_sp) {
        SanPham result = null;
        String query = "select * from SANPHAM where ID_Sp=" + id_sp;
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result = new SanPham(
                        rs.getInt("ID_Sp"),
                        rs.getString("Ten_Sp"),
                        rs.getInt("ID_Loai_Sp"),
                        rs.getString("Don_Vi"),
                        rs.getInt("ID_Xoa")
                );
            }
            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }
        if (result == null) {
            System.out.print("san pham bi null");
        }
        return result;
    }
   
public SanPham getSanPham(String tensp) {
        SanPham result = new SanPham();
        String query = "select * from SANPHAM where ID_Xoa=1 and Ten_Sp ='"+ tensp +"'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result=new SanPham(rs.getInt("ID_Sp"),
                        rs.getString("Ten_Sp"),
                        rs.getInt("ID_Loai_Sp"),
                        rs.getString("Don_Vi"),
                        rs.getInt("ID_Xoa")
                );
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex); 
        }

        return result;
    }
//Tìm kiếm trong bảng sản phẩm
    public ArrayList<SanPham> FindListSanPham(String ValToSearch) {
        ArrayList<SanPham> sanphamList = new ArrayList<>();
        ArrayList<Object> arr = new ArrayList<>();
        String searchQuery = "SELECT * FROM SANPHAM WHERE CONCAT(ID_Sp, Ten_Sp) LIKE '%" + ValToSearch + "%'";
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(searchQuery, arr);
            SanPham sanpham;

            while (rs.next()) {
                sanpham = new SanPham(
                        rs.getInt("ID_Sp"),
                        rs.getString("Ten_Sp"),
                        rs.getInt("Id_Loai_Sp"),
                        rs.getString("Don_Vi"),
                        rs.getInt("ID_Xoa")
                );
                sanphamList.add(sanpham);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return sanphamList;
    }
}
