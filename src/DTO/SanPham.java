/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ADMIN
 */
public class SanPham {
    public int ID_Sp;
    public String Ten_Sp;
    public int ID_Loai_Sp;
    public String Don_Vi;
    public int ID_Xoa;

    public SanPham(int ID_Sp, String Ten_Sp, int ID_Loai_Sp, String Don_Vi, int ID_Xoa) {
        this.ID_Sp = ID_Sp;
        this.Ten_Sp = Ten_Sp;
        this.ID_Loai_Sp = ID_Loai_Sp;
        this.Don_Vi = Don_Vi;
        this.ID_Xoa = ID_Xoa;
    }

    public SanPham() {
    }
    
    
    
}
