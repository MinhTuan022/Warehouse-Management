/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChonSPTra;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.LoSanPham;
import DTO.ThongTinLo;

/**
 *
 * @author ADMIN
 */
public class dLoSanPham {
        private static dLoSanPham instance;

    public static dLoSanPham getInstance() {
        if (instance == null) {
            instance = new dLoSanPham();
        }
        return instance;
    }

    //Lấy danh sách thông tin lô sản phẩm từ nhiều bảng khác nhau
    public ArrayList<ThongTinLo> getListThongTinLo() {
        ArrayList<ThongTinLo> result = new ArrayList<>();
        String sql = "SELECT LOSANPHAM.ID_Lo_Sp, LOSANPHAM.HSD,LOSANPHAM.NSX, \n" +
                        "CHITIETLOSANPHAM.So_Luong_Sp,CHITIETLOSANPHAM.So_Tien_Sp, \n" +
                        "PHIEUNHAP.Thoi_Gian, PHIEUNHAP.ID_PHIEU_NHAP, \n" +
                        "NHANVIEN.Ten_Nv, CHITIETPHIEUNHAP.So_Tien_Lo, \n" +
                        "CHITIETPHIEUNHAP.So_Luong_Lo, NHACUNGCAP.Ten_Nha_Cc, \n" +
                        "NHACUNGCAP.ID_Nha_Cc, SANPHAM.Ten_Sp, LOAISANPHAM.Ten_Loai_Sp\n" +
                        "FROM LOSANPHAM,CHITIETLOSANPHAM,PHIEUNHAP,CHITIETPHIEUNHAP,NHACUNGCAP,SANPHAM, LOAISANPHAM,NHANVIEN\n" +
                        "WHERE LOSANPHAM.ID_Lo_Sp=CHITIETLOSANPHAM.ID_Lo_Sp \n" +
                        "AND PHIEUNHAP.ID_PHIEU_NHAP=CHITIETPHIEUNHAP.ID_PHIEU_NHAP\n" +
                        "AND LOSANPHAM.ID_PHIEU_NHAP=PHIEUNHAP.ID_PHIEU_NHAP\n" +
                        "AND CHITIETPHIEUNHAP.ID_Nha_Cc=NHACUNGCAP.ID_Nha_Cc \n" +
                        "AND CHITIETLOSANPHAM.ID_Sp=SANPHAM.ID_Sp \n" +
                        "AND LOAISANPHAM.ID_Loai_Sp=SANPHAM.ID_Loai_Sp \n" +
                        "AND NHANVIEN.ID_Nv=PHIEUNHAP.ID_Nv";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(sql, arr);
            while (rs.next()) {
                result.add(new ThongTinLo(rs.getInt("ID_Lo_Sp"),
                        rs.getString("HSD"),
                        rs.getString("NSX"),
                        rs.getInt("So_Luong_Sp"),
                        rs.getInt("So_Tien_Sp"),
                        rs.getString("Thoi_Gian"),
                        rs.getInt("ID_Phieu_Nhap"),
                        rs.getString("Ten_Nv"),
                        rs.getInt("So_Tien_Lo"),
                        rs.getInt("So_Luong_Lo"),
                        rs.getInt("ID_Nha_Cc"),
                        rs.getString("Ten_Nha_Cc"),
                        rs.getString("Ten_Sp"),
                        rs.getString("Ten_Loai_Sp")));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return result;
    }
    //lấy danh sách thông tin lô sản phẩm
    public ArrayList<LoSanPham> getDanhSachLoSanPham() {
        ArrayList<LoSanPham> result = new ArrayList<>();
        String query = "select * from LOSANPHAM";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new LoSanPham(rs.getInt("ID_Lo_Sp"), rs.getString("HSD"), rs.getString("NXS"), rs.getInt("ID_Phieu_Nhap"), rs.getInt("ID_Xoa")));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return result;
    }
 public boolean insertLoSanPham(String HSD, String NSX, int ID_Phieu_Nhap, int ID_Xoa) {
        String query = "INSERT INTO LOSANPHAM(HSD, NSX, ID_Phieu_Nhap, ID_Xoa) VALUES ('" + HSD + "','" + NSX + "','" + ID_Phieu_Nhap + "','" + ID_Xoa + "')";
        ArrayList<Object> arr = new ArrayList<>();
        ConnectionDB.getIntance().open();
        int result = ConnectionDB.getIntance().excuteUpdate(query, arr);
        ConnectionDB.getIntance().close();
        return result > 0;
    }   
public LoSanPham getLoSanPham(String HSD, String NSX, int ID_Phieu_Nhap) {
        LoSanPham result = null;
        String query = "SELECT * FROM LOSANPHAM WHERE HSD='" + HSD + "' and NSX='" + NSX + "' and ID_Phieu_Nhap='" + ID_Phieu_Nhap + "'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result = (new LoSanPham(rs.getInt("Id_Lo_Sp"), rs.getString("HSD"), rs.getString("NSX"), rs.getInt("ID_Phieu_Nhap"), rs.getInt("ID_Xoa")));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }
        return result;
    }
    public LoSanPham getLoSanPham(int id_lo) {
        LoSanPham result = null;
        String query = "select * from LOSANPHAM where ID_Lo_Sp=" + id_lo;
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result = new LoSanPham(
                        rs.getInt("ID_Lo_Sp"),
                        rs.getString("HSD"),
                        rs.getString("NSX"),
                        rs.getInt("ID_Phieu_Nhap"),
                        rs.getInt("ID_Xoa")
                );

            }
            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }
        if (result == null) {
            System.out.print("Lo san pham bi null");
        }
        return result;
    }
    public ArrayList<ThongTinLo> get20LoSanPham(ArrayList<ThongTinLo> arr, long Trang) {
        ArrayList<ThongTinLo> result = new ArrayList<>();
        for (long i = (Trang * 20 - 20); i < (Trang * 20); i++) {
            if (i == arr.size()) {
                break;
            }
            result.add(arr.get((int) i));
        }
        return result;
    }
        //Lấy ra thông tin lô sản phẩm từ id lô
    public ThongTinLo getThongTinLo(int id) {
        ThongTinLo result = null;
        String query = "SELECT LOSANPHAM.ID_Lo_Sp, LOSANPHAM.HSD,LOSANPHAM.NSX, \n" +
                        " CHITIETLOSANPHAM.So_Luong_Sp,CHITIETLOSANPHAM.So_Tien_Sp, \n" +
                        " PHIEUNHAP.Thoi_Gian, PHIEUNHAP.ID_Phieu_Nhap, \n" +
                        " NHANVIEN.Ten_Nv, CHITIETPHIEUNHAP.So_Tien_Lo, \n" +
                        " CHITIETPHIEUNHAP.So_Luong_Lo, NHACUNGCAP.ID_Nha_Cc, \n" +
                        " NHACUNGCAP.Ten_Nha_Cc, SANPHAM.Ten_Sp, LOAISANPHAM.Ten_Loai_Sp\n" +
                        " FROM LOSANPHAM,CHITIETLOSANPHAM,PHIEUNHAP,CHITIETPHIEUNHAP,NHACUNGCAP,SANPHAM,LOAISANPHAM,NHANVIEN \n" +
                        " WHERE LOSANPHAM.ID_Lo_Sp=CHITIETLOSANPHAM.ID_Lo_Sp \n" +
                        " AND PHIEUNHAP.ID_Phieu_Nhap=CHITIETPHIEUNHAP.ID_Phieu_Nhap \n" +
                        " AND LOSANPHAM.ID_Phieu_Nhap=PHIEUNHAP.ID_Phieu_Nhap \n" +
                        " AND CHITIETPHIEUNHAP.ID_Nha_Cc=NHACUNGCAP.ID_Nha_Cc \n" +
                        " AND CHITIETLOSANPHAM.id_sp=SANPHAM.id_sp \n" +
                        " AND LOAISANPHAM.ID_Loai_Sp=SANPHAM.ID_Loai_Sp \n" +
                        " AND NHANVIEN.ID_Nv=PHIEUNHAP.ID_Nv \n"
                       +"AND LOSANPHAM.ID_Lo_Sp= '" + id + "'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result = new ThongTinLo(rs.getInt("ID_Lo_Sp"),
                        rs.getString("HSD"),
                        rs.getString("NSX"),
                        rs.getInt("So_Luong_Sp"),
                        rs.getInt("So_Tien_Sp"),
                        rs.getString("Thoi_Gian"),
                        rs.getInt("ID_Phieu_Nhap"),
                        rs.getString("Ten_Nv"),
                        rs.getInt("So_Tien_Lo"),
                        rs.getInt("So_Luong_Lo"),
                        rs.getInt("ID_Nha_Cc"),
                        rs.getString("Ten_Nha_Cc"),
                        rs.getString("Ten_Sp"),
                        rs.getString("Ten_Loai_Sp"));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return result;
    }
    
public ArrayList<ChonSPTra> getListSPTra() {
        ArrayList<ChonSPTra> result = new ArrayList<>();
        String query = "SELECT LOSANPHAM.ID_Lo_Sp, NHACUNGCAP.Ten_Nha_Cc, SANPHAM.Ten_Sp, CHITIETLOSANPHAM.So_Luong_Sp                        FROM LOSANPHAM, NHACUNGCAP, SANPHAM, CHITIETPHIEUNHAP, CHITIETLOSANPHAM \n" +
"                    WHERE LOSANPHAM.ID_Phieu_Nhap=CHITIETPHIEUNHAP.ID_Phieu_Nhap \n" +
"                    AND NHACUNGCAP.ID_Nha_Cc = CHITIETPHIEUNHAP.ID_Nha_Cc \n" +
"                    AND CHITIETPHIEUNHAP.ID_Phieu_Nhap = LOSANPHAM.ID_Phieu_Nhap \n" +
"                    AND CHITIETLOSANPHAM.ID_Lo_Sp = LOSANPHAM.ID_Lo_Sp \n" +
"                    AND SANPHAM.ID_Sp = CHITIETLOSANPHAM.ID_Sp";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new ChonSPTra(rs.getInt("ID_Lo_Sp"),
                                                    rs.getString("Ten_Nha_Cc"),
                                                    rs.getString("Ten_Sp"),
                                                    rs.getInt("So_Luong_Sp")));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return result;
    }

public void CapNhatLoKhiTraKho(int id_lo_sp){
        String query = "UPDATE LOSANPHAM  WHERE LOSANPHAM.ID_Lo_Sp ="+id_lo_sp;
        ArrayList<Object> arr = new ArrayList<>();
        ConnectionDB.getIntance().open();
        ConnectionDB.getIntance().excuteUpdate(query, arr);
        ConnectionDB.getIntance().close();
    }
}
