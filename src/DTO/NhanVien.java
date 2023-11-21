/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;


/**
 *
 * @author ADMIN
 */
public class NhanVien {
    
    public int ID_Nv;
    public String Ten_Nv;
    public String Sdt_Nv;
    public String CMND;
    public String Ngay_Sinh;
    public int ID_Xoa;

    public NhanVien() {
    }

    public NhanVien(int ID_Nv, String Ten_Nv, String Sdt_Nv, String CMND, String Ngay_Sinh, int ID_Xoa) {
        this.ID_Nv = ID_Nv;
        this.Ten_Nv = Ten_Nv;
        this.Sdt_Nv = Sdt_Nv;
        this.CMND = CMND;
        this.Ngay_Sinh = Ngay_Sinh;
        this.ID_Xoa = ID_Xoa;
    }
    
    
    
}