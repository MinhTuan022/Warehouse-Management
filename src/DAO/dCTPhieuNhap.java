/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CTPhieuNhap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class dCTPhieuNhap {
    private static dCTPhieuNhap instance;

    public static dCTPhieuNhap getInstance() {
        if (instance == null) {
            instance = new dCTPhieuNhap();
        }
        return instance;
    }

    public dCTPhieuNhap() {
    }

    //Lấy danh sách thông tin trong bảng chi tiết phiếu nhập
    public ArrayList<CTPhieuNhap> getListChiTietPhieuNhap() {
        ArrayList<CTPhieuNhap> result = new ArrayList<>();
        String query = "SELECT * FROM CHITIETPHIEUNHAP";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new CTPhieuNhap(
                        rs.getInt("So_Tien_Lo"),
                        rs.getInt("So_Luong_Lo"),
                        rs.getInt("ID_Nha_Cc"),
                        rs.getInt("ID_Phieu_Nhap")));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return result;
    }

public boolean insertChiTietPhieuNhap(int So_Tien_Lo, int So_Luong_Lo, int ID_Nha_Cc, int ID_Phieu_Nhap) {
        String query = "INSERT INTO CHITIETPHIEUNHAP(So_Tien_Lo, So_Luong_Lo, ID_Nha_Cc, ID_Phieu_Nhap) VALUES ('" + So_Tien_Lo + "','" + So_Luong_Lo + "','" + ID_Nha_Cc + "','" + ID_Phieu_Nhap + "')";
        ArrayList<Object> arr = new ArrayList<>();
        ConnectionDB.getIntance().open();
        int result = ConnectionDB.getIntance().excuteUpdate(query, arr);
        ConnectionDB.getIntance().close();
        return result > 0;
    }

    // Lấy một chi tiết phiếu nhập từ id
    public CTPhieuNhap getChiTietPhieuNhap(int id_pn) {
        CTPhieuNhap result = null;
        String query = "SELECT * FROM CHITIETPHIEUNHAP WHERE id_phieu_nhap=" + id_pn;
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {

                result = (new CTPhieuNhap(
                        rs.getInt("So_Tien_Lo"),
                        rs.getInt("So_Luong_Lo"),
                        rs.getInt("ID_Nha_Cc"),
                        rs.getInt("ID_Phieu_Nhap")));

            } else {
                result = null;
            }
            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }
        return result;
    }
}
