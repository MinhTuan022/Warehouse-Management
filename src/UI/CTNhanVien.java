/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DTO.NhanVien;


import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VIENTHONGA
 */
public class CTNhanVien extends javax.swing.JFrame {

    /**
     * Creates new form fViewNhanVien
     */
   
    public int id_nv;
    //public int id;
    public CTNhanVien() {
        initComponents();
        
    }
    public CTNhanVien(int id_nv) {
        this.id_nv=id_nv;
        //this.id=id;
        initComponents();

        build();
    }

    public void build()
    {
        ShowNhanVien();
    }
    public void ShowNhanVien()
    {
        NhanVien nv = DAO.DangNhap.getInstance().getNhanVien(id_nv);
        jLabelTenNhanVien.setText(nv.Ten_Nv);
        jLabelSdt.setText(nv.Sdt_Nv);
        jLabelCmnd.setText(nv.CMND);
        jLabelNgaySinh.setText(nv.Ngay_Sinh);
        
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanelNhanVien = new javax.swing.JPanel();
        jButtonThoat = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelTenNhanVien = new javax.swing.JLabel();
        jLabelCmnd = new javax.swing.JLabel();
        jLabelSdt = new javax.swing.JLabel();
        jLabelNgaySinh = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(2, 84, 164));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Phần mềm quản lý kho");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("siêu thị S.O.S");

        jPanelNhanVien.setBackground(new java.awt.Color(64, 128, 186));
        jPanelNhanVien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanelNhanVien.setPreferredSize(new java.awt.Dimension(765, 470));

        jButtonThoat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonThoat.setText("Thoát");
        jButtonThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThoatActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(122, 165, 208));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tên nhân viên: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CMND: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SDT: ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ngày sinh: ");

        jLabelTenNhanVien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTenNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTenNhanVien.setText("Tên nhân viên: ");

        jLabelCmnd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCmnd.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCmnd.setText("CMND: ");

        jLabelSdt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSdt.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSdt.setText("SDT: ");

        jLabelNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNgaySinh.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNgaySinh.setText("Ngày sinh: ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNgaySinh)
                    .addComponent(jLabelTenNhanVien)
                    .addComponent(jLabelCmnd)
                    .addComponent(jLabelSdt))
                .addContainerGap(219, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabelTenNhanVien)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCmnd)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelSdt)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelNgaySinh))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelNhanVienLayout = new javax.swing.GroupLayout(jPanelNhanVien);
        jPanelNhanVien.setLayout(jPanelNhanVienLayout);
        jPanelNhanVienLayout.setHorizontalGroup(
            jPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNhanVienLayout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addGroup(jPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonThoat))))
                .addGap(22, 22, 22))
            .addGroup(jPanelNhanVienLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNhanVienLayout.setVerticalGroup(
            jPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNhanVienLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jButtonThoat)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel2))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(219, Short.MAX_VALUE))
            .addComponent(jPanelNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPanelNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThoatActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonThoatActionPerformed

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
            java.util.logging.Logger.getLogger(CTNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CTNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CTNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CTNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CTNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelCmnd;
    private javax.swing.JLabel jLabelNgaySinh;
    private javax.swing.JLabel jLabelSdt;
    private javax.swing.JLabel jLabelTenNhanVien;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelNhanVien;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
