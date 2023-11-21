/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import DTO.NhanVien;
import java.util.ArrayList;

import DTO.ThongTinXuat;
import DTO.XuatKho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
/**
 *
 * @author ADMIN
 */
public class dPhieuXuat {
    private static dPhieuXuat instance;

    public static dPhieuXuat getInstance() {
        if (instance == null) {
            instance = new dPhieuXuat();
        }
        return instance;
    }
    public ArrayList<ThongTinXuat> get20XuatKho(ArrayList<ThongTinXuat> arr, long Trang) {
        ArrayList<ThongTinXuat> result = new ArrayList<>();

        for (long i = (Trang * 20 - 20); i < (Trang * 20); i++) {
            if (i == arr.size()) {
                break;
            }
            result.add(arr.get((int) i));
        }
        return result;
    }
    public dPhieuXuat() {
    }
    public ArrayList<XuatKho> getListXuatKho() {
        ArrayList<XuatKho> result = new ArrayList<>();
        String query = "select * from PHIEUXUAT WHERE ID_Xoa = 1";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new XuatKho(rs.getInt("ID_Xuat_Kho"), rs.getInt("SL_Sp"), rs.getString("Thoi_Gian_Xuat"), rs.getInt("ID_Lo_Sp"), rs.getInt("ID_Nv")));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return result;
    }

    public ArrayList<ThongTinXuat> getListThongTinXuatKho() {
        ArrayList<ThongTinXuat> result = new ArrayList<>();
        String sql =    "SELECT PHIEUXUAT.ID_Xuat_Kho, PHIEUXUAT.Thoi_Gian_Xuat, SANPHAM.Ten_Sp, LOAISANPHAM.Ten_Loai_Sp, PHIEUXUAT.SL_Sp,NHANVIEN.Ten_Nv \n" +
                        "FROM PHIEUXUAT,CHITIETLOSANPHAM,SANPHAM,LOAISANPHAM,NHANVIEN\n" +
                        "WHERE PHIEUXUAT.ID_Lo_Sp=CHITIETLOSANPHAM.ID_Lo_Sp\n" +
                        "and CHITIETLOSANPHAM.ID_Sp=SANPHAM.ID_Sp\n" +
                        "and SANPHAM.ID_Loai_Sp = LOAISANPHAM.ID_Loai_Sp\n" +
                        "and PHIEUXUAT.ID_Nv=NHANVIEN.ID_Nv\n"
                        + "and PHIEUXUAT.ID_Xoa =1" +
                        "ORDER by PHIEUXUAT.Thoi_Gian_Xuat DESC";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(sql, arr);
            while (rs.next()) {
                result.add(new ThongTinXuat(rs.getInt("ID_Xuat_Kho"),
                        rs.getString("Thoi_Gian_Xuat"),
                        rs.getString("Ten_Sp"),
                        rs.getString("Ten_Loai_Sp"),
                        rs.getInt("SL_Sp"),
                        rs.getString("Ten_Nv")));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return result;
    }
    
public ThongTinXuat getPhieuXuat(int id_px) {
        ThongTinXuat result = null;
        String query = "SELECT PHIEUXUAT.ID_Xuat_Kho, PHIEUXUAT.Thoi_Gian_Xuat, SANPHAM.Ten_Sp, LOAISANPHAM.Ten_Loai_Sp, PHIEUXUAT.SL_Sp,NHANVIEN.Ten_Nv  \n" +
"                        FROM PHIEUXUAT,CHITIETLOSANPHAM,SANPHAM,LOAISANPHAM,NHANVIEN \n" +
"                        WHERE PHIEUXUAT.ID_Lo_Sp=CHITIETLOSANPHAM.ID_Lo_Sp \n" +
"                        and CHITIETLOSANPHAM.ID_Sp=SANPHAM.ID_Sp \n" +
"                        and SANPHAM.ID_Loai_Sp = LOAISANPHAM.ID_Loai_Sp \n" +
"                        and PHIEUXUAT.ID_Nv=NHANVIEN.ID_Nv\n" +
"                        and PHIEUXUAT.ID_Xoa =1 \n" +
"			 and PHIEUXUAT.ID_Xuat_Kho = "+ id_px +
"                        ORDER by PHIEUXUAT.Thoi_Gian_Xuat DESC";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {

                result = (new ThongTinXuat(rs.getInt("ID_Xuat_Kho"),
                        rs.getString("Thoi_Gian_Xuat"),
                        rs.getString("Ten_Sp"),
                        rs.getString("Ten_Loai_Sp"),
                        rs.getInt("SL_Sp"),
                        rs.getString("Ten_Nv")
                        
                        
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
    
        public XuatKho getXuatKho(int id_lo) {
        XuatKho result = null;
        String query = "SELECT * FROM PHIEUXUAT WHERE ID_Lo_Sp=" + id_lo;
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {

                result = (new XuatKho(rs.getInt("ID_Xuat_Kho"),
                        rs.getInt("SL_Sp"),
                        rs.getString("Thoi_Gian_Xuat"),
                        rs.getInt("ID_Lo_Sp"),
                        rs.getInt("ID_Nv")
                       
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
        
        public XuatKho getPXuatKho(int id_px) {
        XuatKho result = null;
        String query = "SELECT * FROM PHIEUXUAT WHERE ID_Xuat_Kho=" + id_px;
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {

                result = (new XuatKho(rs.getInt("ID_Xuat_Kho"),
                        rs.getInt("SL_Sp"),
                        rs.getString("Thoi_Gian_Xuat"),
                        rs.getInt("ID_Lo_Sp"),
                        rs.getInt("ID_Nv")
                       
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
        
public boolean KiemTraXuatKho(String id_lo, String slton, String slxuat, String ngay, int id_nv) {
        if (slton == null || "".equals(id_lo)) {
            JOptionPane.showMessageDialog(null,
                    "Chưa chọn sản phẩm",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        int sl = Integer.parseInt(slton);
        int slx = Integer.parseInt(slxuat);
        if (slx <= 0 || slx > sl) {
            JOptionPane.showMessageDialog(null,
                    "Số lượng xuất không hợp lệ",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        ngay = DAO.DateTimeNow.getIntance().Now;
        
        String query = "INSERT INTO PHIEUXUAT(SL_Sp, Thoi_Gian_Xuat, ID_Lo_Sp, ID_Nv, ID_Xoa) VALUES (" + slxuat + ",'" + ngay + "'," + id_lo + "," + id_nv + ","+1+")";
        ArrayList<Object> arr = new ArrayList<>();
        ConnectionDB.getIntance().open();
        ConnectionDB.getIntance().excuteUpdate(query, arr);
        ConnectionDB.getIntance().close();
        
        if(slx == sl){
            dLoSanPham.getInstance().CapNhatLoKhiTraKho(Integer.parseInt(id_lo));
        }
        
        JOptionPane.showMessageDialog(null,
                "Thêm phiếu xuất thành công",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
        NhanVien nv = DAO.DangNhap.getInstance().getNhanVien(id_nv);
        int soluong = sl - slx;
        int id_loi = Integer.parseInt(id_lo);
        DAO.dCTLoSanPham.getInstance().updateSoLuongKho(soluong, id_loi);
        //DAO.daoThongBao.getInstance().insertThongBao("[Xuất kho] Nhân viên " + nv.ten_nv + " đã xuất hàng ra kho vào lúc " + ngay, ngay, 2);
        //daoTonKho.getInstance().CapNhatTonKho();
        return true;
    }

public ArrayList<ThongTinXuat> FindListXuatKho(ArrayList<ThongTinXuat> DuLieuMau, String ValToSearch) {
        ArrayList<ThongTinXuat> result = new ArrayList<>();
        for (int i = 0; i < DuLieuMau.size(); i++) {
            if (DuLieuMau.get(i).Thoi_Gian_Xuat.contains(ValToSearch)
                    || String.valueOf(DuLieuMau.get(i).ID_Xuat_Kho).contains(ValToSearch)
                    || DuLieuMau.get(i).Ten_Loai_Sp.contains(ValToSearch)
                    || String.valueOf(DuLieuMau.get(i).SL_Sp).contains(ValToSearch)
                    || DuLieuMau.get(i).Ten_Nv.contains(ValToSearch)
                    || DuLieuMau.get(i).Ten_Sp.contains(ValToSearch)) {
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
public boolean XoaPhieuXuat(int ID_Xuat, int ID_Nv)
    {
        
        String query = "UPDATE PHIEUXUAT SET ID_Xoa=0 WHERE ID_Xuat_Kho=" + ID_Xuat;
        //System.out.println(query);
        ArrayList<Object> arr = new ArrayList<>();
        ConnectionDB.getIntance().open();
        ConnectionDB.getIntance().excuteUpdate(query, arr);
        ConnectionDB.getIntance().close();
        JOptionPane.showMessageDialog(null,
                "Xóa thông tin phiếu xuất thành công",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
        
        
        
        
        return true;
    }


public boolean UpdatePhieuXuat(int IDPhieuXuat,
            String TgXuat,
            String SoLuong
            
            ) {
        if ("".equals(TgXuat) || "".equals(SoLuong)) {
            JOptionPane.showMessageDialog(null,
                    "Chưa điền đầy đủ thông tin",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String query = "UPDATE PHIEUXUAT SET Thoi_Gian_Xuat='" + TgXuat + "',Sl_Sp=" + SoLuong + " WHERE ID_Xuat_Kho=" + IDPhieuXuat;
        //System.out.println(query);
        ArrayList<Object> arr = new ArrayList<>();
        ConnectionDB.getIntance().open();
        ConnectionDB.getIntance().excuteUpdate(query, arr);
        ConnectionDB.getIntance().close();
        JOptionPane.showMessageDialog(null,
                "Sửa thông phiếu xuất thành công",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
       
        return true;
    }
//Lấy ra số lần xuất kho trong thời gian tương ứng
    public int SoLanXuatKhoTheoThoiGian(String thoi_gian) {
        int so_lan = 0;
        String query = "SELECT COUNT(ID_Xuat_Kho) AS lan_xuat_kho FROM PHIEUXUAT\n" +
"WHERE CONVERT(VARCHAR(25), Thoi_Gian_Xuat, 126) LIKE '%" + thoi_gian + "%'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                so_lan = rs.getInt("lan_xuat_kho");
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }
        return so_lan;
    }

}
