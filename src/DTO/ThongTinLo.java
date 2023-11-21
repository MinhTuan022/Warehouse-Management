/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Dinh Tien
 */
public class ThongTinLo {
    //Lô
    public int ID_Lo_Sp;
    public String HSD;
    public String NSX;
    public int So_Luong_Sp;
    public int So_Tien_Sp;
    //Phiếu nhập
    public String Thoi_Gian;
    public int ID_Phieu_Nhap;
    public String Ten_Nv;
    public int So_Tien_Lo;
    public int So_Luong_Lo;        
    //Nhà cung cấp
    public int ID_Nha_Cc;
    public String Ten_Nha_Cc;
    //Sản phẩm
    public String Ten_Sp;
    public String Ten_Loai_Sp;

    public ThongTinLo() {
    }

    public ThongTinLo(int ID_Lo_Sp, String HSD, String NSX, int So_Luong_Sp, int So_Tien_Sp, String Thoi_Gian, int ID_Phieu_Nhap, String Ten_Nv, int So_Tien_Lo, int So_Luong_Lo, int ID_Nha_Cc, String Ten_Nha_Cc, String Ten_Sp, String Ten_Loai_Sp) {
        this.ID_Lo_Sp = ID_Lo_Sp;
        this.HSD = HSD;
        this.NSX = NSX;
        this.So_Luong_Sp = So_Luong_Sp;
        this.So_Tien_Sp = So_Tien_Sp;
        this.Thoi_Gian = Thoi_Gian;
        this.ID_Phieu_Nhap = ID_Phieu_Nhap;
        this.Ten_Nv = Ten_Nv;
        this.So_Tien_Lo = So_Tien_Lo;
        this.So_Luong_Lo = So_Luong_Lo;
        this.ID_Nha_Cc = ID_Nha_Cc;
        this.Ten_Nha_Cc = Ten_Nha_Cc;
        this.Ten_Sp = Ten_Sp;
        this.Ten_Loai_Sp = Ten_Loai_Sp;
    }
  
    

}