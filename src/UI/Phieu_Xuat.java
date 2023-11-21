/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;


import DTO.ThongTinXuat;
import DAO.dPhieuXuat;
import DTO.NhanVien;
import DTO.TaiKhoan;
import DTO.XuatKho;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author P50
 */
public class Phieu_Xuat extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public int ID_Nv;
    public ArrayList<ThongTinXuat> DanhSachXuatKho;
    public ArrayList<ThongTinXuat> DuLieuMau = DanhSachXuatKho;  
    public long count, SoTrang, Trang = 1;
    public Phieu_Xuat(){
    }

    public Phieu_Xuat(int ID_Nv) {
        this.ID_Nv = ID_Nv;
        DanhSachXuatKho = dPhieuXuat.getInstance().getListThongTinXuatKho();
        DuLieuMau = DanhSachXuatKho;
        initComponents();
        build();
        setLocationRelativeTo(null);
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
        jLabel9 = new javax.swing.JLabel();
        cbbNv = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbxuat = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txttimkiem = new javax.swing.JTextField();
        btntimkiem = new javax.swing.JButton();
        btncreate = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btntruoc = new javax.swing.JButton();
        JTrang = new javax.swing.JLabel();
        btnsau = new javax.swing.JButton();
        JSoTrang = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(122, 165, 208));
        jPanel1.setPreferredSize(new java.awt.Dimension(1127, 130));

        jPanel2.setBackground(new java.awt.Color(2, 84, 164));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hệ thống quản lý ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("kho siêu thị");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons8-warehouse-64 (2).png"))); // NOI18N

        cbbNv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbbNv, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(cbbNv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(64, 128, 186));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/business (2).png"))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(64, 128, 186));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons8_sent_16px_1.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tổng Quan");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addGap(15, 15, 15))
        );

        jPanel8.setBackground(new java.awt.Color(58, 79, 102));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons8_sent_16px_1.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Phiếu Xuất Kho");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16))
                .addGap(15, 15, 15))
        );

        jPanel12.setBackground(new java.awt.Color(64, 128, 186));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
        });

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons8_sent_16px_1.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Phiếu Trả Nhà Cung Cấp");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel24))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 191, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(122, 165, 208));

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tbxuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Xuất", "Thời gian xuất", "Tên Sản Phẩm", "Loại Sản Phẩm", "Số lượng", "Người phụ trách"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbxuat.setRowHeight(50
        );
        tbxuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbxuatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbxuat);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Danh Sách Phiếu Xuất Kho");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        btntimkiem.setText("Tìm Kiếm");
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        btncreate.setText("Thêm");
        btncreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncreateActionPerformed(evt);
            }
        });

        btnsua.setText("Sửa");
        btnsua.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                btnsuaComponentShown(evt);
            }
        });
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btncreate)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnsua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnxoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btntimkiem))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(280, 280, 280)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntimkiem)
                    .addComponent(btncreate)
                    .addComponent(btnsua)
                    .addComponent(btnxoa)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(64, 128, 186));

        btntruoc.setText("<");
        btntruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntruocActionPerformed(evt);
            }
        });

        JTrang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JTrang.setText("1");

        btnsau.setText(">");
        btnsau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsauActionPerformed(evt);
            }
        });

        JSoTrang.setText("1/1");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btntruoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JSoTrang)
                .addGap(36, 36, 36))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntruoc)
                    .addComponent(JTrang)
                    .addComponent(btnsau)
                    .addComponent(JSoTrang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1118, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncreateActionPerformed
        /*ChonSanPhamXuat frmcsp = new ChonSanPhamXuat();
        frmcsp.setVisible(true);*/
       JFrame XuatKho = new ChonSanPhamXuat(ID_Nv);
        XuatKho.setVisible(true);
    }//GEN-LAST:event_btncreateActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        
        int selectedRowIndex = tbxuat.getSelectedRow();
        int id = tbxuat.getValueAt(selectedRowIndex, 0).hashCode();
        JFrame ThongBao = new XacNhan("PhieuXuat", id, ID_Nv);
        ThongBao.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnsuaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btnsuaComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsuaComponentShown

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void tbxuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbxuatMouseClicked
        // TODO add your handling code here:
        btnsua.setEnabled(true);
        btnxoa.setEnabled(true);
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            int selectedRowIndex = tbxuat.getSelectedRow();
            int id = tbxuat.getValueAt(selectedRowIndex, 0).hashCode();
            JFrame CT= new CTPhieuXuat(ID_Nv, id);
            CT.setVisible(true);
        }
    }//GEN-LAST:event_tbxuatMouseClicked

    private void btnsauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsauActionPerformed
        // TODO add your handling code here:
        if (Trang < SoTrang) {
            Trang++;
            ArrayList<ThongTinXuat> table = dPhieuXuat.getInstance().get20XuatKho(DanhSachXuatKho, Trang);
            listDanhSachXuatKho(table);
            JTrang.setText("" + Trang);
            JSoTrang.setText(Trang + "/" + SoTrang);
        }
    }//GEN-LAST:event_btnsauActionPerformed

    private void btntruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntruocActionPerformed
        // TODO add your handling code here:
        if (Trang > 1) {
            Trang--;
            ArrayList<ThongTinXuat> table = dPhieuXuat.getInstance().get20XuatKho(DanhSachXuatKho, Trang);
            listDanhSachXuatKho(table);
            JTrang.setText("" + Trang);
            JSoTrang.setText(Trang + "/" + SoTrang);
        }
    }//GEN-LAST:event_btntruocActionPerformed

    public void NhanVienDangNhap() {
        if (ID_Nv != 0) {
            //TaiKhoan tk = DAO.DangNhap.getInstance().getTaiKhoan(ID_Nv);
            NhanVien nv = DAO.DangNhap.getInstance().getNhanVien(ID_Nv);
            cbbNv.addItem(nv.Ten_Nv);
            cbbNv.addItem("Thông tin");
            cbbNv.addItem("Thoát");
        } else {
            cbbNv.addItem("Chưa đăng nhập");
        }
    }
    private void cbbNvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNvActionPerformed
        // TODO add your handling code here:
        String valueIn = String.valueOf(cbbNv.getSelectedItem());
        if ("Thoát".equals(valueIn)) {
            JFrame dn = new Login();
            dn.setVisible(true);
            dispose();
        }
//        if ("Đổi mật khẩu".equals(valueIn)) {
//            JFrame reset = new fResetPass(id_nv);
//            reset.setVisible(true);
//            //dispose();
//        }
        if ("Thông tin".equals(valueIn)) {
            JFrame nv = new CTNhanVien(ID_Nv);
            nv.setVisible(true);
            //dispose();
        }
    }//GEN-LAST:event_cbbNvActionPerformed

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        // TODO add your handling code here:
        Phieu_Tra_NCC pt = new Phieu_Tra_NCC(ID_Nv);
        pt.setVisible(true);
        dispose();
    }//GEN-LAST:event_jPanel12MouseClicked

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tbxuat.getSelectedRow();
        int id = tbxuat.getValueAt(selectedRowIndex, 0).hashCode();
        JFrame Xem = new SuaPhieuXuat(ID_Nv,id);
        Xem.setVisible(true);
    }//GEN-LAST:event_btnsuaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        invalidate();
        validate();
        repaint();
        DuLieuMau=DAO.dPhieuXuat.getInstance().getListThongTinXuatKho();
       //build();
        DanhSachXuatKho = DuLieuMau;
        this.count = this.DanhSachXuatKho.size();
        //jLabelKetQua.setText("Có tổng cộng " + count + " kết quả");
        if (count % 20 == 0) {
            SoTrang = count / 20;
        } else {
            SoTrang = count / 20 + 1;
        }
        JSoTrang.setText("1/" + SoTrang);
        JTrang.setText("1");
        ArrayList<ThongTinXuat> table = DAO.dPhieuXuat.getInstance().get20XuatKho(DuLieuMau, 1);
        listDanhSachXuatKho(table);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
        // TODO add your handling code here:
        DanhSachXuatKho = DuLieuMau;
        FindList();
    }//GEN-LAST:event_btntimkiemActionPerformed
public void FindList() {


        this.DanhSachXuatKho = DAO.dPhieuXuat.getInstance().FindListXuatKho(DuLieuMau, txttimkiem.getText());
        if (DanhSachXuatKho.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Không có dữ liệu xuất kho",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            build();
        } else {
            this.count = this.DanhSachXuatKho.size();
            //jLabelKetQua.setText("Có tổng cộng " + count + " kết quả");
            if (count % 20 == 0) {
                SoTrang = count / 20;
            } else {
                SoTrang = count / 20 + 1;
            }
            JSoTrang.setText("1/" + SoTrang);
            JTrang.setText("1");
            ArrayList<ThongTinXuat> table = DAO.dPhieuXuat.getInstance().get20XuatKho(DanhSachXuatKho, 1);
            listDanhSachXuatKho(table);
        }
    }    
    
    public void build() {
        
        btnsua.setEnabled(false);
        btnxoa.setEnabled(false);
        DuLieuMau = dPhieuXuat.getInstance().getListThongTinXuatKho();
        DanhSachXuatKho = DuLieuMau;
        this.count = this.DanhSachXuatKho.size();
        
        if (count % 20 == 0) {
            SoTrang = count / 20;
        } else {
            SoTrang = count / 20 + 1;
        }
        JSoTrang.setText("1/" + SoTrang);
        JTrang.setText("1");
        ArrayList<ThongTinXuat> table = dPhieuXuat.getInstance().get20XuatKho(DanhSachXuatKho, 1);
        listDanhSachXuatKho(table);
        NhanVienDangNhap();
        

    }    
    
    public void listDanhSachXuatKho(ArrayList<ThongTinXuat> arr) {
        DefaultTableModel model = (DefaultTableModel) tbxuat.getModel();
        while (tbxuat.getRowCount() > 0) {
            model.removeRow(0);
        }
  
        arr.stream().forEach((item) -> {
            model.addRow(new Object[]{item.ID_Xuat_Kho, item.Thoi_Gian_Xuat, item.Ten_Sp, item.Ten_Loai_Sp, item.SL_Sp, item.Ten_Nv});
        });
    }
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
            java.util.logging.Logger.getLogger(Phieu_Xuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Phieu_Xuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Phieu_Xuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Phieu_Xuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Phieu_Xuat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JSoTrang;
    private javax.swing.JLabel JTrang;
    private javax.swing.JButton btncreate;
    private javax.swing.JButton btnsau;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JButton btntruoc;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<String> cbbNv;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbxuat;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}