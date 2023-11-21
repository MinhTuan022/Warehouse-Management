/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import DTO.CTLoSanPham;
import DTO.LoSanPham;
import DTO.LoaiSanPham;
import DTO.NhaCungCap;
import DTO.NhanVien;
import DTO.PhieuNhap;
import DTO.SanPham;
import DTO.TaiKhoan;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.util.Date;

/**
 *
 * @author P50
 */
public class TaoPhieuXuat extends javax.swing.JFrame {

    /**
     * Creates new form TaoPhieuXuat
     */
    
    
//    private static TaoPhieuXuat PX;
//    private static boolean isopen = false;
//    public static TaoPhieuXuat getInstance() {
//        if(PX==null)PX=new TaoPhieuXuat();
//        return PX;
//    }
//    public static boolean checkOpen() {
//        
//        return isopen;
//    }
//    public static int ID_Nv;
//    public TaoPhieuXuat(int id_nv, int k)
//    {
//        PX = new TaoPhieuXuat(id_nv);
//        PX.setVisible(true);
//        isopen=true;
//    }
//    public TaoPhieuXuat() {
//        initComponents();
//    }
//    public TaoPhieuXuat(int ID_Nv) {
//        this.ID_Nv=ID_Nv;
//        initComponents();
//        setLocationRelativeTo(null);
//        
//        build();
//    }
//    public void build()
//    {
//        getNhanVien();
//    }
//    public void getNhanVien()
//    {
//        TaiKhoan tk = DAO.DangNhap.getInstance().getTaiKhoan(this.ID_Nv);
//        NhanVien nv=null;
//        if(tk!=null)
//            nv =DAO.DangNhap.getInstance().getNhanVien(tk.ID_Nv);
//        String tennv =null;
//        if(nv==null) tennv="";
//        else tennv = nv.Ten_Nv;
//        txtNV.setText(tennv);
//    }
    public int ID_Nv;
    public int ID_Lo_Sp;
    public TaoPhieuXuat() {
        initComponents();
     
    }
    public TaoPhieuXuat(int ID_Nv,int ID_Lo_Sp) {
        initComponents();
        setLocationRelativeTo(null);
        this.ID_Nv=ID_Nv;
        this.ID_Lo_Sp= ID_Lo_Sp;
        
        build();
    }

    public void build()
    {
        ThongTin();

    }
    public void ThongTin()
    {
        //LoSanPham kho = DAO.daoKho.getInstance().getIdKho(id_kho);
        //CTPhieuNhap pn = DAO.dCTPhieuNhap.getInstance().getChiTietPhieuNhap(ID_Lo_Sp)
        CTLoSanPham ctlsp = DAO.dCTLoSanPham.getInstance().getChiTietLoSanPham(ID_Lo_Sp);
        LoSanPham lsp = DAO.dLoSanPham.getInstance().getLoSanPham(ID_Lo_Sp);
        //CTPhieuNhap ctpn = DAO.dCTPhieuNhap.getInstance().getChiTietPhieuNhap(lsp.ID_Phieu_Nhap);
        //NhaCungCap ncc = DAO.dNhaCungCap.getInstance().getNhaCungCap(ctpn.ID_Nha_Cc);
        SanPham sp = DAO.dSanPham.getInstance().getSanPham(ctlsp.ID_Sp);
        LoaiSanPham loaisp = DAO.dLoaiSanPham.getInstance().getLoaiSanPham(sp.ID_Loai_Sp);
        //PhieuNhap pn = DAO.dPhieuNhap.getInstance().getPhieuNhap(lsp.ID_Phieu_Nhap);
        NhanVien nv = DAO.DangNhap.getInstance().getNhanVien(ID_Nv);
        
        txtNV.setText(nv.Ten_Nv);
        //txtnhacc.setText(ncc.Ten_Nha_Cc);
        txtnsx.setText(lsp.NSX);
        txthsd.setText(lsp.HSD);
        txtloaisp.setText(loaisp.Ten_Loai_Sp);
        txttensp.setText(sp.Ten_Sp);
        txtsoluong.setText(String.valueOf(ctlsp.So_Luong_Sp));
        txtIDLo.setText(String.valueOf(lsp.ID_Lo_Sp));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIDLo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txttensp = new javax.swing.JTextField();
        txtloaisp = new javax.swing.JTextField();
        txtnsx = new javax.swing.JTextField();
        txthsd = new javax.swing.JTextField();
        txtsoluong = new javax.swing.JTextField();
        txtchonsp = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNV = new javax.swing.JTextField();
        SpinnerSLxuat = new javax.swing.JSpinner();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jXDatePickerThoiGian = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jXDatePickerThoiGian.setFormats(new String[]{"yyyy-MM-dd"});
        Date date = new Date();
        jXDatePickerThoiGian.setDate(date);
        jPanel1.setBackground(new java.awt.Color(122, 165, 208));

        jPanel2.setBackground(new java.awt.Color(64, 128, 186));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Phiếu Xuất Kho Siêu Thị");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Thông tin sản phẩm");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Loại Sản Phẩm");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID Lô");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tên Sản Phẩm");

        txtIDLo.setEditable(false);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ngày Sản Xuất");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Hạn Sử Dụng");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Số Lượng Hiện Có");

        txttensp.setEditable(false);

        txtloaisp.setEditable(false);

        txtnsx.setEditable(false);

        txthsd.setEditable(false);

        txtsoluong.setEditable(false);

        txtchonsp.setText("Chọn Sản Phẩm");
        txtchonsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtchonspActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtloaisp, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(txttensp, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIDLo, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtnsx)
                    .addComponent(txthsd)
                    .addComponent(txtsoluong, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                .addGap(139, 139, 139))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtchonsp, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDLo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtnsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txttensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthsd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtloaisp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(32, 32, 32)
                .addComponent(txtchonsp)
                .addGap(25, 25, 25))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Thông Tin Phiếu Xuất Kho");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Số Lượng Xuất");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Thời Gian Xuất");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Người Phụ Trách");

        txtNV.setEditable(false);

        jButton4.setText("Lưu");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Thoát");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel12))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNV, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(SpinnerSLxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePickerThoiGian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(35, 35, 35)
                .addComponent(jButton5)
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel9)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SpinnerSLxuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jXDatePickerThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtchonspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtchonspActionPerformed
        // TODO add your handling code here:
        JFrame ex = new ChonSanPhamXuat();
        ex.setVisible(true);
    }//GEN-LAST:event_txtchonspActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        //isopen=false;
    }//GEN-LAST:event_formWindowClosed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    String soluong = SpinnerSLxuat.getValue().toString();
    String thoigian ="";
    String id_lo = txtIDLo.getText();
    String soluongton = txtsoluong.getText();
    DAO.dPhieuXuat.getInstance().KiemTraXuatKho(id_lo, soluongton, soluong, thoigian, ID_Nv);
    dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TaoPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaoPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaoPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaoPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new TaoPhieuXuat().setVisible(true);
                new TaoPhieuXuat().setVisible(true);
            }
        });
    }
//    public void setText(String tensp, String hsd, String sl, String nsx,String loaisp, String id_lo)
//    {
//        
//        PX.txtsoluong.setText(sl);
//        PX.txttensp.setText(tensp);
//        PX.txthsd.setText(hsd);
//        PX.txtnsx.setText(nsx);
//        PX.txtloaisp.setText(loaisp);
//        PX.txtIDLo.setText(id_lo);
//        
//        
//        int id = Integer.parseInt(id_lo);
//        CTLoSanPham ct = DAO.dCTLoSanPham.getInstance().getChiTietLoSanPham(id);
//        SanPham sp = DAO.dSanPham.getInstance().getSanPham(ct.ID_Sp);
//
//   
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner SpinnerSLxuat;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerThoiGian;
    private javax.swing.JTextField txtIDLo;
    private javax.swing.JTextField txtNV;
    private javax.swing.JButton txtchonsp;
    private javax.swing.JTextField txthsd;
    private javax.swing.JTextField txtloaisp;
    private javax.swing.JTextField txtnsx;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txttensp;
    // End of variables declaration//GEN-END:variables
}
