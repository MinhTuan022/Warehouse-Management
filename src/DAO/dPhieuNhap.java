/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PhieuNhap;
import DTO.ThongTinNhap;
//import DTO.ThongTinNhap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
/**
 *
 * @author Admin
 */
public class dPhieuNhap {
    private static dPhieuNhap instance;

    public static dPhieuNhap getInstance() {
        if (instance == null) {
            instance = new dPhieuNhap();
        }
        return instance;
    }
public ArrayList<ThongTinNhap> get20NhapKho(ArrayList<ThongTinNhap> arr, long Trang) {
        ArrayList<ThongTinNhap> result = new ArrayList<>();

        for (long i = (Trang * 20 - 20); i < (Trang * 20); i++) {
            if (i == arr.size()) {
                break;
            }
            result.add(arr.get((int) i));
        }
        return result;
    }
//Tính số lần nhập kho trong ngày
    public int SoLanNhapKhoTrongNgay(String thoi_gian) {
        int so_lan = 0;
        String query = "SELECT COUNT(ID_Phieu_Nhap) AS lan_nhap_kho FROM PHIEUNHAP\n" +
"WHERE CONVERT(VARCHAR(25), Thoi_Gian, 126) LIKE '%" + thoi_gian + "%'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                so_lan = rs.getInt("lan_nhap_kho");
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return so_lan;
    }
    public ArrayList<PhieuNhap> getListPhieuNhap() {
        ArrayList<PhieuNhap> result = new ArrayList<>();
        String query = "select *from PHIEUNHAP where ID_Xoa=1";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new PhieuNhap(rs.getInt("ID_Nv"), rs.getInt("ID_Phieu_Nhap"), rs.getString("Thoi_Gian"), rs.getInt("ID_Xoa")));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return result;
    }

    public boolean XoaPhieuNhap(int id, int ID_Nv) {
        String query = "UPDATE PHIEUNHAP SET ID_Xoa=" + 0 + " WHERE ID_Phieu_Nhap=" + id;
        try {
            ConnectionDB.getIntance().open();
            ConnectionDB.getIntance().excuteQuery(query);
            ConnectionDB.getIntance().close();
            JOptionPane.showMessageDialog(null, "Xóa phieu nhap thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Xóa phieu nhap Thất bại", "Thông báo", 1);
            return false;
        }
        return true;
    }

    public boolean insertPhieuNhap(int ID_Nv, String Thoi_Gian, int ID_Xoa) {
        String query = "INSERT INTO PHIEUNHAP(ID_Nv, Thoi_Gian, ID_Xoa) VALUES ('" + ID_Nv + "','" + Thoi_Gian + "','" + ID_Xoa + "')";
        ArrayList<Object> arr = new ArrayList<>();
        ConnectionDB.getIntance().open();
        int result = ConnectionDB.getIntance().excuteUpdate(query, arr);
        ConnectionDB.getIntance().close();
        return result > 0;
    }

    public PhieuNhap getPhieuNhap(String Thoi_Gian, int ID_Nv) {
        PhieuNhap result = null;
        String query = "select * from PHIEUNHAP where Thoi_Gian ='" + Thoi_Gian + "' and ID_Nv='" + ID_Nv + "'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result = (new PhieuNhap(rs.getInt("ID_Nv"),
                        rs.getInt("ID_Phieu_Nhap"),
                        rs.getString("Thoi_Gian"),
                        rs.getInt("ID_Xoa")));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }
        return result;

    }

    public PhieuNhap getPhieuNhap(int ID) {
        PhieuNhap result = null;
        String query = "SELECT * FROM PHIEUNHAP WHERE ID_Phieu_Nhap=" + ID;
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {

                result = (new PhieuNhap(rs.getInt("ID_Nv"),
                        rs.getInt("ID_Phieu_Nhap"),
                        rs.getString("Thoi_Gian"),
                        rs.getInt("ID_Xoa")));

            } else {
                result = null;
            }
            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }
        return result;
    }

    public ArrayList<ThongTinNhap> FindListNhapKho(ArrayList<ThongTinNhap> DuLieuMau, String ValToSearch) {
        ArrayList<ThongTinNhap> result = new ArrayList<>();
        for (int i = 0; i < DuLieuMau.size(); i++) {
            if (DuLieuMau.get(i).Thoi_Gian.contains(ValToSearch)
                    || String.valueOf(DuLieuMau.get(i).So_Tien_Lo).contains(ValToSearch)
                    || DuLieuMau.get(i).Ten_Nv.contains(ValToSearch)) {
                //System.out.println(DuLieuXuatKho.get(i).thoi_gian_xuat);
                //System.out.println(tensp);
                // System.out.println(loaisp);
                // System.out.println(sl_sp);
                //   System.out.println(tennv);

                result.add(DuLieuMau.get(i));
            }
        }
        return result;
    }

    public boolean updatePhieuNhap(String Thoi_Gian, int ID_Nv, int ID) {
        String query = "UPDATE PHIEUNHAP SET Thoi_Gian='" + Thoi_Gian + "',ID_Nv=" + ID_Nv + " WHERE ID_Phieu_Nhap=" + ID;
        try {
            ConnectionDB.getIntance().open();
            ConnectionDB.getIntance().excuteQuery(query);
            ConnectionDB.getIntance().close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public ArrayList<ThongTinNhap> getListThongTinNhapKho() {
        ArrayList<ThongTinNhap> result = new ArrayList<>();
        String query = "SELECT phieu_xuat_kho.id_xuat_kho, phieu_xuat_kho.thoi_gian_xuat, san_pham.ten_sp, loai_sp.ten_loai_sp, phieu_xuat_kho.sl_san_pham,nhan_vien.ten_nv "
                + "FROM `phieu_xuat_kho`,`chi_tiet_lo_sp`,`san_pham`,`loai_sp`,`nhan_vien` "
                + "WHERE phieu_xuat_kho.id_lo_sp=chi_tiet_lo_sp.id_lo_sp "
                + "and chi_tiet_lo_sp.id_sp=san_pham.id_sp "
                + "and san_pham.id_loai_sp = loai_sp.id_loai_sp "
                + "and phieu_xuat_kho.id_nv=nhan_vien.id_nv "
                + "ORDER by phieu_xuat_kho.thoi_gian_xuat DESC";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new ThongTinNhap(rs.getInt("ID_Phieu_Nhap"),
                        rs.getString("Thoi_Gian"),
                        rs.getInt("So_Tien_Lo"),
                        rs.getInt("So_Luong_Lo"),
                        rs.getString("Ten_Sp"),
                        rs.getString("Ten_Loai_Sp"),
                        rs.getString("Don_Vi"),
                        rs.getInt("ID_Lo_Sp"),
                        rs.getString("HSD"),
                        rs.getString("NSX"),
                        rs.getInt("So_Luong_Sp"),
                        rs.getInt("So_Tien_Sp"),
                        rs.getString("Ten_Nv"),
                        rs.getString("Ten_Nha_Cc"),
                        rs.getString("SDT"),
                        rs.getString("Dia_Chi"),
                        rs.getString("Email")));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return result;
    }   

}

