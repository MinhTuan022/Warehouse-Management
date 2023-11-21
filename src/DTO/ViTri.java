/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class ViTri {
    public int ID_Vi_Tri;
    public String Ten_Vi_Tri;
    public int ID_Xoa;
    public int ID_Loai_Sp;
    public ViTri(int ID_Vi_Tri, String Ten_Vi_Tri, int ID_Xoa, int ID_Loai_Sp){
        this.ID_Vi_Tri = ID_Vi_Tri;
        this.Ten_Vi_Tri = Ten_Vi_Tri;
        this.ID_Xoa = ID_Xoa;
        this.ID_Loai_Sp = ID_Loai_Sp;
    }
}
