/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ADMIN
 */
public class ThongTinXuat {
    public int ID_Xuat_Kho;
    public String Thoi_Gian_Xuat;
    public String Ten_Sp;
    public String Ten_Loai_Sp;
    public int SL_Sp;
    public String Ten_Nv;
    

    public ThongTinXuat(){}

    public ThongTinXuat(int ID_Xuat_Kho, String Thoi_Gian_Xuat, String Ten_Sp, String Ten_Loai_Sp, int SL_Sp, String Ten_Nv) {
        this.ID_Xuat_Kho = ID_Xuat_Kho;
        this.Thoi_Gian_Xuat = Thoi_Gian_Xuat;
        this.Ten_Sp = Ten_Sp;
        this.Ten_Loai_Sp = Ten_Loai_Sp;
        this.SL_Sp = SL_Sp;
        this.Ten_Nv = Ten_Nv;
    }
    
}

