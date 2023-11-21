       /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.CTLoSanPham;
import DTO.ThongTinTra;
/**
 *
 * @author ADMIN
 */
public class dCTLoSanPham {
    private static dCTLoSanPham instance;

    public static dCTLoSanPham getInstance() {
        if (instance == null) {
            instance = new dCTLoSanPham();
        }
        return instance;
    }

    //Lấy danh sách thông tin trong bảng chi tiết lô sản phẩm
    public ArrayList<CTLoSanPham> getListChiTietLoSanPham() {
        ArrayList<CTLoSanPham> result = new ArrayList<>();
        String query = "select * from CHITIETLOSANPHAM";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new CTLoSanPham( rs.getInt("So_Luong_Sp"), rs.getInt("So_Tien_Sp"), rs.getInt("ID_Lo_Sp"), rs.getInt("ID_Sp")));
            }
            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }
        return result;
    }

//Thêm Chi tiết lô sản phẩm mới
    public boolean insertChiTietLoSanPham(int So_Luong_Sp, int So_Tien_Sp, int ID_Lo_Sp, int ID_Sp) {
        String query = "INSERT INTO CHITIETLOSANPHAM( So_Luong_Sp, So_Tien_Sp, ID_Lo_Sp, ID_Sp) VALUES  ('" + So_Luong_Sp + "','" + So_Tien_Sp + "','" + ID_Lo_Sp + "','" + ID_Sp + "')";
        ArrayList<Object> arr = new ArrayList<>();
        ConnectionDB.getIntance().open();
        int result = ConnectionDB.getIntance().excuteUpdate(query, arr);
        ConnectionDB.getIntance().close();
        return result > 0;
    }
    //Lấy 1 chi tiết lô sản phẩm từ id 
    public CTLoSanPham getChiTietLoSanPham(int id_lo) {
        CTLoSanPham result = null;
        String query = "select * from CHITIETLOSANPHAM where ID_Lo_Sp=" + id_lo;
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result = new CTLoSanPham(rs.getInt("So_Luong_Sp"), rs.getInt("So_Tien_Sp"), rs.getInt("ID_Lo_Sp"), rs.getInt("ID_Sp"));
            }
            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }
        if (result == null) {
            System.out.print("Chi tiet Lo san pham bi null");
        }
        return result;
    }
    public boolean updateSoLuongKho(int sl_sp, int id_lo) {
        String query = "UPDATE CHITIETLOSANPHAM SET So_Luong_Sp='" + sl_sp + "' WHERE ID_Lo_Sp='" + id_lo + "'";
        ArrayList<Object> arr = new ArrayList<>();
        ConnectionDB.getIntance().open();
        int result = ConnectionDB.getIntance().excuteUpdate(query, arr);
        ConnectionDB.getIntance().close();
        return result > 0;
    }

    public boolean updateSoLuongTra(int sl_sp, int id_lo) {
        
        ThongTinTra pt = DAO.dPhieuTraNCC.getInstance().getPhieuTra(id_lo);
        
        String query = "UPDATE CHITIETLOSANPHAM SET So_Luong_Sp='" + sl_sp + "' WHERE ID_Lo_Sp='" + id_lo + "'";
        ArrayList<Object> arr = new ArrayList<>();
        ConnectionDB.getIntance().open();
        int result = ConnectionDB.getIntance().excuteUpdate(query, arr);
        ConnectionDB.getIntance().close();
        return result > 0;
    }
}
