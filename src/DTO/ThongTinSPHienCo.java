/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ADMIN
 */
public class ThongTinSPHienCo {

    public int So_Luong_Lo; // so luong lo hien ta 
    // san pham
    public String Ten_Sp;

    // lo san pham
    public int ID_Lo_Sp;
    //public String HSD;
    //public String NSX;
    //public int So_Luong_Sp; //so luong hien tai trong kho
    // chi tiet lo sp

    public ThongTinSPHienCo() {
    }

    public ThongTinSPHienCo(int So_Luong_Lo, String Ten_Sp, int ID_Lo_Sp) {
        this.So_Luong_Lo = So_Luong_Lo;
        this.Ten_Sp = Ten_Sp;
        this.ID_Lo_Sp = ID_Lo_Sp;
        //this.HSD = HSD;
        //this.NSX = NSX;
        //this.So_Luong_Sp = So_Luong_Sp;
    }

    
    
    
}
