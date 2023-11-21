/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;


/**
 *
 * @author Admin
 */
public class ThongTinNhap {
    
    public int ID_Phieu_Nhap;
    public String Thoi_Gian;
    // chi tiet phieu nhap
    public int So_Tien_Lo;
    public int So_Luong_Lo;
    // san pham
    public String Ten_Sp;
    public String Ten_Loai_Sp;
    public String Don_Vi;
    // lo san pham
    public int ID_Lo_Sp;
    public String HSD;
    public String NSX;
    // chi tiet lo sp
    public int So_Luong_Sp;
    public int So_Tien_Sp;
    // nhan vien
    public String Ten_Nv;

    //public int id_nguon_cc;
    public String Ten_Nha_Cc;
    public String SDT;
    public String Dia_Chi;
    public String Email;

    public ThongTinNhap(int ID_Phieu_Nhap, String Thoi_Gian, int So_Tien_Lo, int So_Luong_Lo, String Ten_Sp, String Ten_Loai_Sp, String Don_Vi, int ID_Lo_Sp, String HSD, String NSX, int So_Luong_Sp, int So_Tien_Sp, String Ten_Nv, String Ten_Nha_Cc, String SDT, String Dia_Chi, String Email) {
        this.ID_Phieu_Nhap = ID_Phieu_Nhap;
        this.Thoi_Gian = Thoi_Gian;
        this.So_Tien_Lo = So_Tien_Lo;
        this.So_Luong_Lo = So_Luong_Lo;
        this.Ten_Sp = Ten_Sp;
        this.Ten_Loai_Sp = Ten_Loai_Sp;
        this.Don_Vi = Don_Vi;
        this.ID_Lo_Sp = ID_Lo_Sp;
        this.HSD = HSD;
        this.NSX = NSX;
        this.So_Luong_Sp = So_Luong_Sp;
        this.So_Tien_Sp = So_Tien_Sp;
        this.Ten_Nv = Ten_Nv;
        this.Ten_Nha_Cc = Ten_Nha_Cc;
        this.SDT = SDT;
        this.Dia_Chi = Dia_Chi;
        this.Email = Email;
    }
    
    
}
   
