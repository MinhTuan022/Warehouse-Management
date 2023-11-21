/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ADMIN
 */
public class NhaCungCap {
    public int ID_Nha_Cc;
    public String Ten_Nha_Cc ;
    public String Ten_Dai_Dien;
    public String SDT; 
    public String Dia_Chi;
    public String Email;
    public int ID_Xoa;

    public NhaCungCap() {
    }

    public NhaCungCap(int ID_Nha_Cc, String Ten_Nha_Cc, String Ten_Dai_Dien, String SDT, String Dia_Chi, String Email, int ID_Xoa) {
        this.ID_Nha_Cc = ID_Nha_Cc;
        this.Ten_Nha_Cc = Ten_Nha_Cc;
        this.Ten_Dai_Dien = Ten_Dai_Dien;
        this.SDT = SDT;
        this.Dia_Chi = Dia_Chi;
        this.Email = Email;
        this.ID_Xoa = ID_Xoa;
    }
    
    
    

}
