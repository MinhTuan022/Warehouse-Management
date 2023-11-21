/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ADMIN
 */
public class TaiKhoan {
    public int ID_Tk;
    public int ID_Nv;
    public String Ten_Tai_Khoan;
    public String Mat_Khau;
    public int Loai;
    public int ID_Xoa;

    public TaiKhoan(int ID_Tk, int ID_Nv, String Ten_Tai_Khoan, String Mat_Khau, int Loai, int ID_Xoa) {
        this.ID_Tk = ID_Tk;
        this.ID_Nv = ID_Nv;
        this.Ten_Tai_Khoan = Ten_Tai_Khoan;
        this.Mat_Khau = Mat_Khau;
        this.Loai = Loai;
        this.ID_Xoa = ID_Xoa;
    }

    

    public TaiKhoan() {
    }

  
    
    

    public int getID_Tk() {
        return ID_Tk;
    }

    public void setID_Tk(int ID_Tk) {
        this.ID_Tk = ID_Tk;
    }

    public int getID_Nv() {
        return ID_Nv;
    }

    public void setID_Nv(int ID_Nv) {
        this.ID_Nv = ID_Nv;
    }

    public String getTen_Tai_Khoan() {
        return Ten_Tai_Khoan;
    }

    public void setTen_Tai_Khoan(String Ten_Tai_Khoan) {
        this.Ten_Tai_Khoan = Ten_Tai_Khoan;
    }

    public String getMat_Khau() {
        return Mat_Khau;
    }

    public void setMat_Khau(String Mat_Khau) {
        this.Mat_Khau = Mat_Khau;
    }

    public int getLoai() {
        return Loai;
    }

    public void setLoai(int Loai) {
        this.Loai = Loai;
    }
    
    
    
    
            
            
            
}
