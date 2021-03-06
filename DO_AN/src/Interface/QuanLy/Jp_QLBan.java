/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.QuanLy;

import Connect.ConnectSQL;
import Dao.BanDAO;
import Dao.NhomMonDAO;
import Models.Ban;
import Models.Loai;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.DefaultRowSorter;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Dinh
 */
public class Jp_QLBan extends javax.swing.JPanel {

    /**
     * Creates new form JpQLBan
     */
    public Jp_QLBan() {
        initComponents();
    }

    public void getDataBan() {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã Bàn");
        model.addColumn("Tên Bàn");
        model.addColumn("Trạng Thái");
        BanDAO nvDao = new BanDAO();
        int soban = 0;
        for (Ban nv : BanDAO.getData()) {
            soban++;
            model.addRow(new Object[]{nv.getMaBan(),nv.getTenBan(),nv.getTrangThai()});
        }
        jTable1.setModel(model);
        jLBan.setText(String.valueOf(soban) + " Bàn");
    }
    public void setTestfield() {
        txtMaBan.setText("");
        txtMaBan.setEnabled(false);
        txtTenBan.setText("");
        txtTrangThai.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTimBan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLBan = new javax.swing.JLabel();
        btnThemBan = new javax.swing.JButton();
        btnSuaBan = new javax.swing.JButton();
        btnXoaBan = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtMaBan = new javax.swing.JTextField();
        txtTenBan = new javax.swing.JTextField();
        txtTrangThai = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Tìm Bàn");

        txtTimBan.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtTimBan.setText("Tìm Bàn");
        txtTimBan.setToolTipText("Tìm Bàn");
        txtTimBan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimBanFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimBanFocusLost(evt);
            }
        });
        txtTimBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimBanActionPerformed(evt);
            }
        });
        txtTimBan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimBanKeyReleased(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jTable1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Tổng Số Bàn:");

        jLBan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLBan.setForeground(new java.awt.Color(255, 0, 0));
        jLBan.setText("Total");

        btnThemBan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/file_add.png"))); // NOI18N
        btnThemBan.setText("THÊM");
        btnThemBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemBanActionPerformed(evt);
            }
        });

        btnSuaBan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSuaBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/document_edit.png"))); // NOI18N
        btnSuaBan.setText("SỬA");
        btnSuaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaBanActionPerformed(evt);
            }
        });

        btnXoaBan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoaBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/file_delete.png"))); // NOI18N
        btnXoaBan.setText("XÓA");
        btnXoaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaBanActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/logo.png"))); // NOI18N

        txtMaBan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMaBan.setToolTipText("Mã Bàn");
        txtMaBan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaBanFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaBanFocusLost(evt);
            }
        });

        txtTenBan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTenBan.setToolTipText("Tên Bàn");
        txtTenBan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenBanFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenBanFocusLost(evt);
            }
        });

        txtTrangThai.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTrangThai.setToolTipText("Trạng Thái");
        txtTrangThai.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTrangThaiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTrangThaiFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnThemBan, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnSuaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnXoaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMaBan)
                                .addComponent(txtTenBan)
                                .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLBan)))
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimBan, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemBan)
                            .addComponent(btnSuaBan)
                            .addComponent(btnXoaBan))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(txtTenBan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLBan))
                        .addGap(64, 64, 64)
                        .addComponent(jLabel4)
                        .addGap(21, 21, 21))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimBanActionPerformed

    private void jTable1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable1AncestorAdded
        getDataBan();
    }//GEN-LAST:event_jTable1AncestorAdded

    private void btnThemBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemBanActionPerformed
        if (txtMaBan.getText().equals("") || txtTenBan.getText().equals("") || txtTrangThai.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Không được rỗng");
        } else {
            try (Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
                    PreparedStatement ps = conn.prepareCall("{call insertBan(?,?,?)}")) {
                ps.setString(1, txtMaBan.getText());
                ps.setString(2, txtTenBan.getText());
                ps.setString(3, txtTrangThai.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Thêm Bàn Thành Công");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        getDataBan();
        setTestfield();
    }//GEN-LAST:event_btnThemBanActionPerformed

    private void btnSuaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaBanActionPerformed
       if (txtTenBan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bàn muốn cập nhật");
        } else {
            try (Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
                    PreparedStatement ps = conn.prepareCall("{call updateBan(?,?,?)}")) {
                ps.setString(1, txtTenBan.getText());
                ps.setString(2, txtTrangThai.getText());
                ps.setInt(3, Integer.parseInt(txtMaBan.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cập Nhật Bàn Thành Công");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
            getDataBan();
            setTestfield();
        }
    }//GEN-LAST:event_btnSuaBanActionPerformed

    private void btnXoaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaBanActionPerformed
       int kq = JOptionPane.showConfirmDialog( null,"Bạn muốn xóa bàn này không?", "Chú ý",JOptionPane.YES_NO_OPTION);
       if(kq ==0){
           if (txtTenBan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bàn muốn xóa");
        } else {
            try (Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
                    PreparedStatement ps = conn.prepareCall("{call deleteBan(?)}")) {
                ps.setInt(1, Integer.parseInt(txtMaBan.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Xóa Bàn Thành Công");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        getDataBan();
        setTestfield();
       }
    }//GEN-LAST:event_btnXoaBanActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //Đỗ dữ liệu vào các ô textfield từ table
        try {
            int i = jTable1.getSelectedRow();
            TableModel model = jTable1.getModel();
            txtMaBan.setEnabled(false);
            txtMaBan.setText(model.getValueAt(i, 0).toString());
            txtTenBan.setText(model.getValueAt(i, 1).toString());
            txtTrangThai.setText(model.getValueAt(i, 2).toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtTimBanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimBanFocusGained
       if (txtTimBan.getText().equals("Tìm Bàn")) {
            txtTimBan.setText("");
        }
        txtTimBan.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtTimBanFocusGained

    private void txtTimBanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimBanFocusLost
        if (txtTimBan.getText().equals("")) {
            txtTimBan.setText("Tìm Bàn");
        }
        //[204,204,204]
        txtTimBan.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtTimBanFocusLost

    private void txtTimBanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimBanKeyReleased
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã Bàn");
        model.addColumn("Tên Bàn");
        model.addColumn("Trạng Thái");
        String str = txtTimBan.getText();
        jTable1.setAutoCreateRowSorter(true);
        DefaultRowSorter<?, ?> sorter = (DefaultRowSorter<?, ?>) jTable1.getRowSorter();
        sorter.setRowFilter(RowFilter.regexFilter(str));
        sorter.setSortKeys(null);
        jTable1.setRowSorter((RowSorter<? extends TableModel>) sorter);
    }//GEN-LAST:event_txtTimBanKeyReleased

    private void txtMaBanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaBanFocusGained
        if (txtMaBan.getText().equals("Mã Bàn")) {
            txtMaBan.setText("");
        }
        txtMaBan.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtMaBanFocusGained

    private void txtMaBanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaBanFocusLost
        if (txtMaBan.getText().equals("")) {
            txtMaBan.setText("Mã Bàn");
        }
        //[204,204,204]
        txtMaBan.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtMaBanFocusLost

    private void txtTenBanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenBanFocusGained
        if (txtTenBan.getText().equals("Tên Bàn")) {
            txtTenBan.setText("");
        }
        txtTenBan.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtTenBanFocusGained

    private void txtTenBanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenBanFocusLost
        if (txtTenBan.getText().equals("")) {
            txtTenBan.setText("Tên Bàn");
        }
        //[204,204,204]
        txtTenBan.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtTenBanFocusLost

    private void txtTrangThaiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTrangThaiFocusGained
        if (txtTrangThai.getText().equals("Trạng Thái")) {
            txtTrangThai.setText("");
        }
        txtTrangThai.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtTrangThaiFocusGained

    private void txtTrangThaiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTrangThaiFocusLost
        if (txtTrangThai.getText().equals("")) {
            txtTrangThai.setText("Trạng Thái");
        }
        //[204,204,204]
        txtTrangThai.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtTrangThaiFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaBan;
    private javax.swing.JButton btnThemBan;
    private javax.swing.JButton btnXoaBan;
    private javax.swing.JLabel jLBan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtMaBan;
    private javax.swing.JTextField txtTenBan;
    private javax.swing.JTextField txtTimBan;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
