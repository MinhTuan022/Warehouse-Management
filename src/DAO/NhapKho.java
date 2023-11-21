/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.LoSanPham;
import DTO.LoaiSanPham;
import DTO.NhanVien;
import DTO.PhieuNhap;
import DTO.SanPham;
import DTO.ThongTinNhap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class NhapKho {
     private static NhapKho instance;

    public static NhapKho getInstance() {
        if (instance == null) {
            instance = new NhapKho();
        }
        return instance;
    }

    public int So_Luong_Sp;
    public int So_Tien_Sp;
    public int ID_Sp;
    public String Thoi_Gian;
    public int ID_Nv;
    public String HSD;
    public String NSX;
    public int ID_Nha_Cc; 
    public int So_Tien_Lo; 
    public int So_Luong_Lo;

    public NhapKho() {
    }

    public NhapKho(String Thoi_Gian, int So_Luong_Sp, int So_Tien_Sp, int ID_Sp, int ID_Nv, String HSD, String NSX, int ID_Nha_Cc, int So_Tien_Lo, int So_Luong_Lo) {
        this.So_Luong_Sp = So_Luong_Sp;
        this.So_Tien_Sp = So_Tien_Sp;
        this.ID_Sp = ID_Sp;
        this.Thoi_Gian = Thoi_Gian;
        this.ID_Nv = ID_Nv;
        this.HSD = HSD;
        this.NSX = NSX;
        this.ID_Nha_Cc = ID_Nha_Cc;
        this.So_Tien_Lo = So_Tien_Lo;
        this.So_Luong_Lo = So_Luong_Lo;
    }
    public boolean check() {
        return true;
    }
    public ArrayList<ThongTinNhap> getListDanhSachNhapKho() {
        ArrayList<ThongTinNhap> result = new ArrayList<>();
        String query = "SELECT * FROM PHIEUNHAP,CHITIETPHIEUNHAP,NHANVIEN,LOSANPHAM,SANPHAM,LOAISANPHAM,CHITIETLOSANPHAM,NHACUNGCAP WHERE PHIEUNHAP.ID_Phieu_Nhap =CHITIETPHIEUNHAP.ID_Phieu_Nhap AND PHIEUNHAP.ID_Nv = NHANVIEN.ID_Nv AND SANPHAM.ID_Loai_Sp = LOAISANPHAM.ID_Loai_Sp AND SANPHAM.ID_Sp = CHITIETLOSANPHAM.ID_Sp AND CHITIETLOSANPHAM.ID_Lo_Sp = LOSANPHAM.ID_Lo_Sp AND NHACUNGCAP.ID_Nha_Cc = CHITIETPHIEUNHAP.ID_Nha_Cc AND LOSANPHAM.ID_Phieu_Nhap = PHIEUNHAP.ID_Phieu_Nhap AND PHIEUNHAP.ID_Xoa = 1 ORDER BY PHIEUNHAP.Thoi_Gian ASC";
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
    public void Run() {
        dPhieuNhap.getInstance().insertPhieuNhap(ID_Nv, Thoi_Gian, 1);
        PhieuNhap pn = dPhieuNhap.getInstance().getPhieuNhap(Thoi_Gian, ID_Nv);
        int ID_Phieu_Nhap = pn.ID_Phieu_Nhap;
        // lấy lại id phieu nhập vừa nhập
        dLoSanPham.getInstance().insertLoSanPham(HSD, NSX, ID_Phieu_Nhap, 1);
        LoSanPham lsp = dLoSanPham.getInstance().getLoSanPham(HSD, NSX, ID_Phieu_Nhap);
        int ID_Lo_Sp = lsp.ID_Lo_Sp;
        // lấy lại id lô sản phẩm vừa nhập
        dCTLoSanPham.getInstance().insertChiTietLoSanPham(So_Luong_Sp, So_Tien_Sp, ID_Lo_Sp, ID_Sp);
        // nhap vao thong tin của chi tiet phieu nhap
        dCTPhieuNhap.getInstance().insertChiTietPhieuNhap(So_Tien_Lo, So_Luong_Lo, ID_Nha_Cc, ID_Phieu_Nhap);
        //System.out.println("so_luong_lo" + so_luong_lo );
        // luu vào thông báo
        NhanVien nv = DangNhap.getInstance().getNhanVien(ID_Nv);
        // luu vào kho 
        SanPham sp = dSanPham.getInstance().getSanPham(ID_Sp);
        LoaiSanPham loaisp = dLoaiSanPham.getInstance().getLoaiSanPham(sp.ID_Loai_Sp);
   
    }
    public ThongTinNhap getThongTinNhap(ArrayList<ThongTinNhap> arr, String Thoi_Gian) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).Thoi_Gian.equals(Thoi_Gian)) {
                return (ThongTinNhap) arr.get(i);
            }
        }
        return null;
    }
    
public ThongTinNhap getThongTinNhap(int id) {
        ThongTinNhap result = null;
        String query = "SELECT * FROM PHIEUNHAP,CHITIETPHIEUNHAP,NHANVIEN,LOSANPHAM,SANPHAM,LOAISANPHAM,CHITIETLOSANPHAM,NHACUNGCAP WHERE PHIEUNHAP.ID_Phieu_Nhap =CHITIETPHIEUNHAP.ID_Phieu_Nhap AND PHIEUNHAP.ID_Nv = NHANVIEN.ID_Nv AND SANPHAM.ID_Loai_Sp = LOAISANPHAM.ID_Loai_Sp AND SANPHAM.ID_Sp = CHITIETLOSANPHAM.ID_Sp AND CHITIETLOSANPHAM.ID_Lo_Sp= LOSANPHAM.ID_Lo_Sp AND NHACUNGCAP.ID_Nha_Cc = CHITIETPHIEUNHAP.ID_Nha_Cc AND LOSANPHAM.ID_Phieu_Nhap = PHIEUNHAP.ID_Phieu_Nhap AND PHIEUNHAP.ID_Xoa = 1 AND PHIEUNHAP.ID_Phieu_Nhap=" + id;
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result = new ThongTinNhap(rs.getInt("ID_Phieu_Nhap"),
                        rs.getString("Thoi_Gian"),
                        rs.getInt("So_Tien_Lo"), rs.getInt("So_Luong_Lo"), rs.getString("Ten_Sp"), rs.getString("Ten_Loai_Sp"), rs.getString("Don_Vi"), rs.getInt("ID_Lo_Sp"), rs.getString("HSD"), rs.getString("NSX"), rs.getInt("So_Luong_Sp"), rs.getInt("So_Tien_Sp"), rs.getString("Ten_Nv"), rs.getString("Ten_Nha_Cc"), rs.getString("SDT"), rs.getString("Dia_Chi"), rs.getString("Email"));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return result;
    }
}
