/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TonKho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class dTonKho {
    private static dTonKho instance;

    public static dTonKho getInstance() {
        if (instance == null) {
            instance = new dTonKho();
        }
        return instance;
    }
    
    //Lấy ra danh sách thông tin tồn kho từ nhiều bảng khác nhau
    public ArrayList<TonKho> getListThongTinTon(String Date) {
        ArrayList<TonKho> result = new ArrayList<>();
        String query = "SELECT LOSANPHAM.ID_Lo_Sp, SANPHAM.Ten_Sp ,(CHITIETLOSANPHAM.So_Luong_Sp*CHITIETPHIEUNHAP.So_Luong_Lo) as SL_Ton, LOSANPHAM.HSD FROM LOSANPHAM, SANPHAM, CHITIETLOSANPHAM , CHITIETPHIEUNHAP\n" +
                    "WHERE LOSANPHAM.HSD <= ' "+Date+"  '\n" +
                "and LOSANPHAM.ID_Lo_Sp=CHITIETLOSANPHAM.ID_Lo_Sp \n" +
"and CHITIETPHIEUNHAP.ID_Phieu_Nhap = LOSANPHAM.ID_Phieu_Nhap\n" +
"and CHITIETLOSANPHAM.ID_Sp=SANPHAM.ID_Sp\n" +
"ORDER BY LOSANPHAM.HSD DESC;";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new TonKho(rs.getInt("ID_Lo_Sp"),
                        rs.getString("Ten_Sp"),
                        rs.getString("HSD"),
                        rs.getInt("SL_Ton")));
            }
            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }
        return result;
    }
    
    public ArrayList<TonKho> getTonTheoNgay(String Date1, String Date2) {
        ArrayList<TonKho> result = new ArrayList<>();
        String query = "SELECT LOSANPHAM.ID_Lo_Sp, SANPHAM.Ten_Sp ,(CHITIETLOSANPHAM.So_Luong_Sp*CHITIETPHIEUNHAP.So_Luong_Lo) as SL_Ton, LOSANPHAM.HSD FROM LOSANPHAM, SANPHAM, CHITIETLOSANPHAM , CHITIETPHIEUNHAP\n" +
"WHERE LOSANPHAM.HSD > ' "+Date1+"  '\n" + "and LOSANPHAM.HSD < ' "+Date2+"  ' \n" +
"and LOSANPHAM.ID_Lo_Sp=CHITIETLOSANPHAM.ID_Lo_Sp \n" +
"and CHITIETPHIEUNHAP.ID_Phieu_Nhap = LOSANPHAM.ID_Phieu_Nhap\n" +
"and CHITIETLOSANPHAM.ID_Sp=SANPHAM.ID_Sp\n" +
"ORDER BY LOSANPHAM.HSD DESC;";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new TonKho(rs.getInt("ID_Lo_Sp"),
                        rs.getString("Ten_Sp"),
                        rs.getString("HSD"),
                        rs.getInt("SL_Ton")));
            }
            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }
        return result;
    }
}
