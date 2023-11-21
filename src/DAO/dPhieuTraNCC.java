/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.NhaCungCap;
import DTO.CTLoSanPham;
import DTO.CTPhieuNhap;
import DTO.LoSanPham;
import DTO.NhanVien;
import DTO.PhieuNhap;
import DTO.PhieuTraNCC;
import DTO.SanPham;
import DTO.ThongTinTra;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class dPhieuTraNCC {
    private static dPhieuTraNCC instance;

    public static dPhieuTraNCC getInstance() {
        if (instance == null) {
            instance = new dPhieuTraNCC();
        }
        return instance;
    }

    public dPhieuTraNCC() {
    }
    
    public ArrayList<PhieuTraNCC> getListTraKho() {
        ArrayList<PhieuTraNCC> result = new ArrayList<>();
        String query = "select * from PHIEUTRANCC where ID_Xoa = 1";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new PhieuTraNCC(rs.getInt("ID_Phieu_Tra"),
                        rs.getString("Tg_Tra"),
                        rs.getInt("Sl_San_Pham"),
                        rs.getInt("ID_Nv"),
                        rs.getInt("ID_Lo_Sp"),
                        rs.getInt("ID_Nha_Cc"),
                        rs.getInt("ID_Xoa")
                        
                ));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return result;
    }
   
    
    //Lấy ra phiếu trả kho từ id
    public PhieuTraNCC getTraKho(int id_pt) {
        PhieuTraNCC result = null;
        String query = "SELECT * FROM PHIEUTRANCC WHERE ID_Phieu_Tra=" + id_pt;
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {

                result = (new PhieuTraNCC(rs.getInt("ID_Phieu_Tra"),
                        rs.getString("Tg_Tra"),
                        rs.getInt("Sl_San_Pham"),
                        
                        rs.getInt("ID_Lo_Sp"),
                        rs.getInt("ID_Nha_Cc"),
                        rs.getInt("ID_Nv"),
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
    
        public PhieuTraNCC getTraKhoNCC(int id_ncc) {
        PhieuTraNCC result = null;
        String query = "SELECT * FROM PHIEUTRANCC WHERE ID_Nha_Cc=" + id_ncc;
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {

                result = (new PhieuTraNCC(rs.getInt("ID_Phieu_Tra"),
                        rs.getString("Tg_Tra"),
                        rs.getInt("Sl_San_Pham"),
                        
                        rs.getInt("ID_Lo_Sp"),
                        rs.getInt("ID_Nha_Cc"),
                        rs.getInt("ID_Nv"),
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
        
public ThongTinTra getPhieuTra(int id_pt) {
        ThongTinTra result = null;
        String query = "SELECT PHIEUTRANCC.ID_Phieu_Tra, PHIEUTRANCC.Tg_Tra, NHACUNGCAP.Ten_Nha_Cc, SANPHAM.Ten_Sp,PHIEUTRANCC.Sl_San_Pham, NHANVIEN.Ten_Nv\n" +
                    "FROM PHIEUTRANCC, NHACUNGCAP, NHANVIEN, SANPHAM, LOSANPHAM, CHITIETLOSANPHAM\n" +
                    "Where PHIEUTRANCC.ID_Nv = NHANVIEN.ID_Nv\n" +
                    "and PHIEUTRANCC.ID_Nha_Cc = NHACUNGCAP.ID_Nha_Cc\n" +
                    "and LOSANPHAM.ID_Lo_Sp  =PHIEUTRANCC.ID_Lo_Sp\n" +
                    "and CHITIETLOSANPHAM.ID_Lo_Sp = LOSANPHAM.ID_Lo_Sp\n" +
                    "and CHITIETLOSANPHAM.ID_Sp = SANPHAM.ID_Sp\n" +
                    "and PHIEUTRANCC.ID_Xoa =1\n" +
                    "and PHIEUTRANCC.ID_Phieu_Tra='" + id_pt+"'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {

                result = (new ThongTinTra(rs.getInt("ID_Phieu_Tra"),
                        rs.getString("Tg_Tra"),
                        rs.getString("Ten_Nha_Cc"),
                        rs.getString("Ten_Sp"),
                        rs.getInt("Sl_San_Pham"),
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
    
public boolean InsertPhieuTra(int id_lo, int id_nv) {
        CTLoSanPham ctlsp = DAO.dCTLoSanPham.getInstance().getChiTietLoSanPham(id_lo);
        LoSanPham lsp = DAO.dLoSanPham.getInstance().getLoSanPham(id_lo);
        CTPhieuNhap ctpn = DAO.dCTPhieuNhap.getInstance().getChiTietPhieuNhap(lsp.ID_Phieu_Nhap);
        NhaCungCap ncc = DAO.dNhaCungCap.getInstance().getNhaCungCap(ctpn.ID_Nha_Cc);
//        PhieuTraNCC pt = DAO.dLoSanPham.getInstance().getListSPTra(ncc.);
//        NhanVien nv = DAO.DangNhap.getInstance().getNhanVien(pn.ID_Nv);
        String ngay = DAO.DateTimeNow.getIntance().Now;
        String query = "INSERT INTO PHIEUTRANCC("
                + "Tg_Tra, "
                + "Sl_San_Pham, "
                + "ID_Nha_Cc, "
                + "ID_Lo_Sp, "
                + "ID_Xoa, "
                + "ID_Nv) VALUES ("
                + "'" + ngay + "',"
                + "" + ctlsp.So_Luong_Sp + ","
                + "" + ncc.ID_Nha_Cc+ ","
                + "" + id_lo + ","
                + "1,"
                + "" + id_nv + ")";
        ArrayList<Object> arr = new ArrayList<>();
        ConnectionDB.getIntance().open();
        ConnectionDB.getIntance().excuteUpdate(query, arr);
        ConnectionDB.getIntance().close();
        // lo san pham khong rỗng id_ton_kho = 0
        //dLoSanPham.getInstance().CapNhatLoKhiTraKho(id_lo);
        //
        JOptionPane.showMessageDialog(null,
                "Tạo phiếu trả thành công",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
        //NhanVien nv = DAO.DangNhap.getInstance().getNhanVien(id_nv);
        DAO.dCTLoSanPham.getInstance().updateSoLuongKho(0, id_lo);
        String ngayluu=ngay.substring(0,10);
        //System.out.println("DAO.daoTraNhaCungCap.InsertPhieuTra()" + ngayluu);
//        DAO.daoTonKho.getInstance().updateSoLuongTonKho(kho.id_lo_sp,ngayluu,0);
//        DAO.daoThongBao.getInstance().insertThongBao("[Trả hàng] Nhân viên " + nv.ten_nv + " đã trả hàng vào lúc " + ngay, ngay, 2);
        return true;
    }
    
//Lấy ra 20 phiếu tra, để phân trang
    public ArrayList<PhieuTraNCC> get20PhieuTraKho(ArrayList<PhieuTraNCC> arr, long Trang) {
        ArrayList<PhieuTraNCC> result = new ArrayList<>();
        for (long i = (Trang * 20 - 20); i < (Trang * 20); i++) {
            if (i == arr.size()) {
                break;
            }
            result.add(arr.get((int) i));
        }
        return result;
    }
    
public boolean XoaPhieuTraNcc(int ID_Phieu_Tra, int ID_Nv)
    {
        
        String query = "UPDATE PHIEUTRANCC SET ID_Xoa=0 WHERE ID_Phieu_Tra=" + ID_Phieu_Tra;
        //System.out.println(query);
        ArrayList<Object> arr = new ArrayList<>();
        ConnectionDB.getIntance().open();
        ConnectionDB.getIntance().excuteUpdate(query, arr);
        ConnectionDB.getIntance().close();
        JOptionPane.showMessageDialog(null,
                "Xóa thông tin phiếu trả thành công",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
        
        
        
        
        return true;
    }

public boolean UpdatePhieuTra(int IDPhieuTra,
            String TgTra,
            String SoLuong
            
            ) {
        if ("".equals(TgTra) || "".equals(SoLuong)) {
            JOptionPane.showMessageDialog(null,
                    "Chưa điền đầy đủ thông tin",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String query = "UPDATE PHIEUTRANCC SET Tg_Tra='" + TgTra + "',Sl_San_Pham=" + SoLuong + " WHERE ID_Phieu_Tra=" + IDPhieuTra;
        //System.out.println(query);
        ArrayList<Object> arr = new ArrayList<>();
        ConnectionDB.getIntance().open();
        ConnectionDB.getIntance().excuteUpdate(query, arr);
        ConnectionDB.getIntance().close();
        JOptionPane.showMessageDialog(null,
                "Sửa thông tin nhà cung cấp thành công",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
       
        return true;
    }

}
