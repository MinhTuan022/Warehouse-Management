/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.NhaCungCap;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

/**
 *
 * @author ADMIN
 */
public class dNhaCungCap {
    private static dNhaCungCap instance;

    public static dNhaCungCap getInstance() {
        if (instance == null) {
            instance = new dNhaCungCap();
        }
        return instance;
    }

    public dNhaCungCap() {
    }
    
    public ArrayList<NhaCungCap> getListNhaCungCap() {
        ArrayList<NhaCungCap> result = new ArrayList<>();
        String query = "select *from NHACUNGCAP where ID_Xoa=1";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new NhaCungCap(rs.getInt("ID_Nha_Cc"),
                        rs.getString("Ten_Nha_Cc"),
                        rs.getString("Ten_Dai_Dien"),
                        rs.getString("SDT"),
                        rs.getString("Dia_Chi"),
                        rs.getString("Email"),
                        rs.getInt("ID_Xoa")
                        ));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return result;
    }
//Tìm kiếm trong bảng nguồn cung cấp
    public ArrayList<NhaCungCap> FindListNhaCungCap(String ValToSearch) {
        ArrayList<NhaCungCap> NhaCungCapList = new ArrayList<>();
        ArrayList<Object> arr = new ArrayList<>();
        String searchQuery = "SELECT * FROM NHACUNGCAP WHERE CONCAT(ID_Nha_Cc, Ten_Nha_Cc,Ten_Dai_Dien,SDT,Dia_Chi) LIKE '%" + ValToSearch + "%'";
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(searchQuery, arr);
            NhaCungCap ncc;

            while (rs.next()) {
                ncc = new NhaCungCap(
                        rs.getInt("ID_Nha_Cc"),
                        rs.getString("Ten_Nha_Cc"),
                        rs.getString("Ten_Dai_Dien"),
                        rs.getString("SDT"),
                        rs.getString("Dia_Chi"),
                        rs.getString("Email"),
                        rs.getInt("ID_Xoa")
                        
                );
                NhaCungCapList.add(ncc);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return NhaCungCapList;
    }

    //Tìm kiếm trong bảng nguồn cung cấp (mới)
    public ArrayList<NhaCungCap> FindListNhaCungCap(ArrayList<NhaCungCap> DuLieuMau, String ValToSearch) {
        ArrayList<NhaCungCap> result = new ArrayList<>();
        for (int i = 0; i < DuLieuMau.size(); i++) {

            if (DuLieuMau.get(i).Dia_Chi.contains(ValToSearch)
                    || DuLieuMau.get(i).Email.contains(ValToSearch)
                    || String.valueOf(DuLieuMau.get(i).ID_Nha_Cc).contains(ValToSearch)
                    || DuLieuMau.get(i).SDT.contains(ValToSearch)
                    || DuLieuMau.get(i).Ten_Dai_Dien.contains(ValToSearch)
                    || DuLieuMau.get(i).Ten_Nha_Cc.contains(ValToSearch)) {
                //System.out.println(DuLieuXuatKho.get(i).thoi_gian_xuat);
                //System.out.println(tensp);
                // System.out.println(loaisp);
                // System.out.println(sl_sp);
                //   System.out.println(tennv);

                result.add(DuLieuMau.get(i));
            }
        }
        return result;
    }

    public NhaCungCap getNhaCungCap(String tenncc) {
        NhaCungCap result = new NhaCungCap();
        String query = "select * from NHACUNGCAP where ID_Xoa=1 and Ten_Nha_Cc ='"+ tenncc +"'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result=new NhaCungCap(rs.getInt("ID_Nha_Cc"),
                rs.getString("Ten_Nha_Cc"),
                rs.getString("Ten_Dai_Dien"),
                rs.getString("SDT"),
                rs.getString("Dia_Chi"),
                rs.getString("Email"),        
                rs.getInt("ID_Xoa"));
            }

            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex); 
        }

        return result;
    }
    //Lấy ra 1 nguồn cung cấp bằng id
    public NhaCungCap getNhaCungCap(int ID_Ncc) {
        String query = "SELECT * FROM NHACUNGCAP WHERE ID_Nha_Cc='" + ID_Ncc + "'";
        ArrayList<Object> arr = new ArrayList<>();
        NhaCungCap ncc = null;
        try {
            ConnectionDB.getIntance().open();
            ResultSet rs = ConnectionDB.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                ncc = new NhaCungCap(
                        rs.getInt("ID_Nha_Cc"),
                        rs.getString("Ten_Nha_Cc"),
                        rs.getString("Ten_Dai_Dien"),
                        rs.getString("SDT"),
                        rs.getString("Dia_Chi"),
                        rs.getString("Email"),
                        rs.getInt("ID_Xoa")
                       
                );

            } else {
                return null;
            }
            ConnectionDB.getIntance().close();
        } catch (SQLException ex) {
            ConnectionDB.getIntance().displayError(ex);
        }

        return ncc;
    }

    //Update thông tin nguồn cung cấp
    public boolean UpdateNhaCungCap(int IdNhaCungCap,
            String TenNhaCungCap,
            String TenDaiDien,
            String Sdt,
            String DiaChi,
            String Email,
            int IdNhanVien) {
        if ("".equals(TenNhaCungCap) || "".equals(TenDaiDien) || "".equals(Sdt) || "".equals(DiaChi) || "".equals(Email)) {
            JOptionPane.showMessageDialog(null,
                    "Chưa điền đầy đủ thông tin",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String query = "UPDATE NHACUNGCAP SET Ten_Nha_Cc=N'" + TenNhaCungCap + "',Ten_Dai_Dien=N'" + TenDaiDien + "',SDT='" + Sdt + "',Dia_Chi=N'" + DiaChi + "',Email='" + Email + "' WHERE ID_Nha_Cc=" + IdNhaCungCap;
        //System.out.println(query);
        ArrayList<Object> arr = new ArrayList<>();
        ConnectionDB.getIntance().open();
        ConnectionDB.getIntance().excuteUpdate(query, arr);
        ConnectionDB.getIntance().close();
        JOptionPane.showMessageDialog(null,
                "Sửa thông tin nhà cung cấp thành công",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
       
        return true;
    }
    
public boolean UpdateNCCTra(int IDNcc,String tenncc) 
{
        if ("".equals(tenncc)) {
            JOptionPane.showMessageDialog(null,
                    "Chưa điền đầy đủ thông tin",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String query = "UPDATE NHACUNGCAP SET Ten_Nha_Cc=N'" + tenncc + "' WHERE ID_Nha_Cc=" + IDNcc;
        //System.out.println(query);
        ArrayList<Object> arr = new ArrayList<>();
        ConnectionDB.getIntance().open();
        ConnectionDB.getIntance().excuteUpdate(query, arr);
        ConnectionDB.getIntance().close();
        JOptionPane.showMessageDialog(null,
                "Sửa thông tin nhà cung cấp thành công",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
       
        return true;
    }
    // them ncc
public boolean insertNhaCungCap(String tennhacc, String tendaidien, String sdt, String diachi, String email, int ID_Nv) {

        if ("".equals(tennhacc) || "".equals(tendaidien) || "".equals(sdt) || "".equals(diachi) || "".equals(email)) {
            JOptionPane.showMessageDialog(null,
                    "Chưa điền đầy đủ thông tin",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            DAO.ConnectionDB.getIntance().open();
            PreparedStatement ps = DAO.ConnectionDB.getIntance().getconn().prepareStatement("INSERT INTO NHACUNGCAP(Ten_Nha_Cc, Ten_Dai_Dien, SDT, Dia_Chi, Email, ID_Xoa) VALUES (?,?,?,?,?,1)");
            
            ps.setString(1, tennhacc);
            ps.setString(2, tendaidien);
            ps.setString(3, sdt);
            ps.setString(4, diachi);
            ps.setString(5, email);
            ps.executeUpdate();
            DAO.ConnectionDB.getIntance().close();
            JOptionPane.showMessageDialog(null,
                    "Thêm nhà cung cấp mới thành công.",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }

    //xoa nc
public boolean HuyNguonCungCap(int ID_Ncc, int ID_Nv)
    {
        String query = "UPDATE NHACUNGCAP SET ID_Xoa=0 WHERE ID_Nha_Cc=" + ID_Ncc;
        //System.out.println(query);
        ArrayList<Object> arr = new ArrayList<>();
        ConnectionDB.getIntance().open();
        ConnectionDB.getIntance().excuteUpdate(query, arr);
        ConnectionDB.getIntance().close();
        JOptionPane.showMessageDialog(null,
                "Xóa thông tin nhà cung cấp thành công",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
        
        return true;
    }
    public ArrayList<NhaCungCap> get20NhaCungCap(ArrayList<NhaCungCap> arr, long Trang) {
        ArrayList<NhaCungCap> result = new ArrayList<>();
        for (long i = (Trang * 20 - 20); i < (Trang * 20); i++) {
            if (i == arr.size()) {
                break;
            }
            result.add(arr.get((int) i));
        }
        return result;
    }
}

