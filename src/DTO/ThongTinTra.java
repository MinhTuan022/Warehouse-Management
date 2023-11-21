/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ADMIN
 */
public class ThongTinTra {
    public int ID_Phieu_Tra;
    public String Tg_Tra;
    
    public String Ten_Nha_Cc;
    public String Ten_Sp;
    
    public int Sl_San_Pham;
    public String Ten_Nv;

    public ThongTinTra() {
    }

    public ThongTinTra(int ID_Phieu_Tra, String Tg_Tra, String Ten_Nha_Cc, String Ten_Sp, int Sl_San_Pham, String Ten_Nv) {
        this.ID_Phieu_Tra = ID_Phieu_Tra;
        this.Tg_Tra = Tg_Tra;
        this.Ten_Nha_Cc = Ten_Nha_Cc;
        this.Ten_Sp = Ten_Sp;
        this.Sl_San_Pham = Sl_San_Pham;
        this.Ten_Nv = Ten_Nv;
    }
    
    
}
