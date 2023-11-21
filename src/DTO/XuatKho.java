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
public class XuatKho {
    public int ID_Xuat_Kho;
    public int SL_Sp;
    public String Thoi_Gian_Xuat;
    public int ID_Lo_Sp;   
    public int ID_Nv;
   
    //Hàm khởi tạo

    public XuatKho(int ID_Xuat_Kho, int SL_Sp, String Thoi_Gian_Xuat, int ID_Lo_Sp, int ID_Nv) {
        this.ID_Xuat_Kho = ID_Xuat_Kho;
        this.SL_Sp = SL_Sp;
        this.Thoi_Gian_Xuat = Thoi_Gian_Xuat;
        this.ID_Lo_Sp = ID_Lo_Sp;
        this.ID_Nv = ID_Nv;
        
    }

    

    
  
}
