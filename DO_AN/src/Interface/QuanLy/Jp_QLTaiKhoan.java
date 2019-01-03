/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.QuanLy;

import Connect.ConnectSQL;
import Dao.TaiKhoanDAO;
import Dao.ThucDonDAO;
import Models.TaiKhoan;
import Models.ThucDon;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
public class Jp_QLTaiKhoan extends javax.swing.JPanel {

    /**
     * Creates new form Jp_QLTaiKhoan
     */
    public Jp_QLTaiKhoan() {
        initComponents();
        txtID.setEnabled(false);
    }

    public void getData() {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã TK");
        model.addColumn("Tên Đăng Nhập");
        model.addColumn("Mật Khẩu");
        model.addColumn("Chức Vụ");
        model.addColumn("Họ Và Tên");
        int sotk = 0;
        TaiKhoanDAO nvDao = new TaiKhoanDAO();
        for (TaiKhoan nv : TaiKhoanDAO.getData()) {
            sotk++;
            model.addRow(new Object[]{nv.getId(), nv.getUserName(), nv.getPassWord(), nv.getLv(), nv.getFullName()});
        }
        jTable1.setModel(model);
        jLTK.setText(String.valueOf(sotk) + " TK");
    }

    public void setTestfield() {
        txtID.setText("");
        txtID.setEnabled(false);
        txtUserName.setText("");
        txtPassWord.setText("");
        txtLever.setText("");
        txtFullName.setText("");
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
        txtTimTK = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnThemTK = new javax.swing.JButton();
        btnSuaTK = new javax.swing.JButton();
        btnXoaTK = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLTK = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtUserName = new javax.swing.JTextField();
        txtPassWord = new javax.swing.JTextField();
        txtLever = new javax.swing.JTextField();
        txtFullName = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Tìm Tài Khoản");

        txtTimTK.setText("Tìm Tài Khoản");
        txtTimTK.setToolTipText("Tìm Tài Khoản");
        txtTimTK.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimTKFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimTKFocusLost(evt);
            }
        });
        txtTimTK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimTKKeyReleased(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
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

        btnThemTK.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/file_add.png"))); // NOI18N
        btnThemTK.setText("THÊM");
        btnThemTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTKActionPerformed(evt);
            }
        });

        btnSuaTK.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSuaTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/document_edit.png"))); // NOI18N
        btnSuaTK.setText("SỬA");
        btnSuaTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaTKActionPerformed(evt);
            }
        });

        btnXoaTK.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoaTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/file_delete.png"))); // NOI18N
        btnXoaTK.setText("XÓA");
        btnXoaTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTKActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Tổng Số TK:");

        jLTK.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLTK.setForeground(new java.awt.Color(255, 0, 0));
        jLTK.setText("Total");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/logo.png"))); // NOI18N

        txtID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtID.setText("ID");
        txtID.setToolTipText("ID");
        txtID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDFocusLost(evt);
            }
        });

        txtUserName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUserName.setText("USERNAME");
        txtUserName.setToolTipText("USERNAME");
        txtUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserNameFocusLost(evt);
            }
        });
        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });

        txtPassWord.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPassWord.setText("PASSWORD");
        txtPassWord.setToolTipText("PASSWORD");
        txtPassWord.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassWordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassWordFocusLost(evt);
            }
        });

        txtLever.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtLever.setText("LEVER");
        txtLever.setToolTipText("LEVER");
        txtLever.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLeverFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLeverFocusLost(evt);
            }
        });

        txtFullName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtFullName.setText("FULLNAME");
        txtFullName.setToolTipText("FULLNAME");
        txtFullName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFullNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFullNameFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimTK, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThemTK)
                                .addGap(43, 43, 43)
                                .addComponent(btnSuaTK, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(btnXoaTK, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel2)
                                .addGap(23, 23, 23)
                                .addComponent(jLTK))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtID, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUserName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLever)
                                    .addComponent(txtPassWord)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)))
                        .addGap(56, 56, 56))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnThemTK)
                                    .addComponent(btnSuaTK)
                                    .addComponent(btnXoaTK)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(299, 299, 299)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLTK))))
                        .addGap(85, 85, 85))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPassWord, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtLever, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void jTable1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable1AncestorAdded
        getData();
    }//GEN-LAST:event_jTable1AncestorAdded

    private void btnThemTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTKActionPerformed
        if (txtID.getText().equals("") || txtUserName.getText().equals("") || txtPassWord.getText().equals("") || txtLever.getText().equals("") || txtFullName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Không được rỗng");
        } else {
            try (Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
                    PreparedStatement ps = conn.prepareCall("{call insertTaiKhoan(?,?,?,?)}")) {
                ps.setString(1, txtUserName.getText());
                ps.setString(2, txtPassWord.getText());
                ps.setString(3, txtLever.getText());
                ps.setString(4, txtFullName.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Thêm Tài Khoản Thành Công");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        getData();
        setTestfield();
    }//GEN-LAST:event_btnThemTKActionPerformed

    private void txtIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDFocusGained
        //Đổi màu của chữ hiện trên thanh search và ẩn nó khi click chuột vào
        if (txtID.getText().equals("ID")) {
            txtID.setText("");
        }
        txtID.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtIDFocusGained

    private void txtIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDFocusLost
        //Đổi màu của chữ hiện trên thanh search và ẩn nó khi thoát chuột ra
        if (txtID.getText().equals("")) {
            txtID.setText("ID");
        }
        //[204,204,204]
        txtID.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtIDFocusLost

    private void txtUserNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNameFocusGained
        if (txtUserName.getText().equals("USERNAME")) {
            txtUserName.setText("");
        }
        txtUserName.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtUserNameFocusGained

    private void txtUserNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNameFocusLost
        if (txtUserName.getText().equals("")) {
            txtUserName.setText("USERNAME");
        }
        //[204,204,204]
        txtUserName.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtUserNameFocusLost

    private void txtPassWordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassWordFocusGained
        if (txtPassWord.getText().equals("PASSWORD")) {
            txtPassWord.setText("");
        }
        txtPassWord.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtPassWordFocusGained

    private void txtPassWordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassWordFocusLost
        if (txtPassWord.getText().equals("")) {
            txtPassWord.setText("PASSWORD");
        }
        //[204,204,204]
        txtPassWord.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtPassWordFocusLost

    private void txtLeverFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLeverFocusGained
        if (txtLever.getText().equals("LEVER")) {
            txtLever.setText("");
        }
        txtLever.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtLeverFocusGained

    private void txtLeverFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLeverFocusLost
        if (txtLever.getText().equals("")) {
            txtLever.setText("LEVER");
        }
        //[204,204,204]
        txtLever.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtLeverFocusLost

    private void txtFullNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFullNameFocusGained
        if (txtFullName.getText().equals("FULLNAME")) {
            txtFullName.setText("");
        }
        txtFullName.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtFullNameFocusGained

    private void txtFullNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFullNameFocusLost
        if (txtFullName.getText().equals("")) {
            txtFullName.setText("FULLNAME");
        }
        //[204,204,204]
        txtFullName.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtFullNameFocusLost

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //Đỗ dữ liệu vào các ô textfield từ table
        try {
            int i = jTable1.getSelectedRow();
            TableModel model = jTable1.getModel();
            txtID.setEnabled(false);
            txtID.setText(model.getValueAt(i, 0).toString());
            txtUserName.setText(model.getValueAt(i, 1).toString());
            txtPassWord.setText(model.getValueAt(i, 2).toString());
            txtLever.setText(model.getValueAt(i, 3).toString());
            txtFullName.setText(model.getValueAt(i, 4).toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnSuaTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaTKActionPerformed
        if (txtUserName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn người muốn cập nhật");
        } else {
            try (Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
                    PreparedStatement ps = conn.prepareCall("{call updateTaiKhoan(?,?,?,?,?)}")) {
                ps.setString(1, txtUserName.getText());
                ps.setString(2, txtPassWord.getText());
                ps.setInt(3, Integer.parseInt(txtLever.getText()));
                ps.setString(4, txtFullName.getText());
                ps.setInt(5, Integer.parseInt(txtID.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cập Nhật Tài Khoản Thành Công");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
            getData();
            setTestfield();
        }
    }//GEN-LAST:event_btnSuaTKActionPerformed

    private void btnXoaTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTKActionPerformed
        if (txtUserName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn người muốn xóa");
        } else {
            try (Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
                    PreparedStatement ps = conn.prepareCall("{call deleteTaiKhoan(?)}")) {
                ps.setInt(1, Integer.parseInt(txtID.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Xóa Tài Khoản Thành Công");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        getData();
        setTestfield();
    }//GEN-LAST:event_btnXoaTKActionPerformed

    private void txtTimTKKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimTKKeyReleased
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã TK");
        model.addColumn("Tên Đăng Nhập");
        model.addColumn("Mật Khẩu");
        model.addColumn("Chức Vụ");
        model.addColumn("Họ Và Tên");
        String str = txtTimTK.getText();
        jTable1.setAutoCreateRowSorter(true);
        DefaultRowSorter<?, ?> sorter = (DefaultRowSorter<?, ?>) jTable1.getRowSorter();
        sorter.setRowFilter(RowFilter.regexFilter(str));
        sorter.setSortKeys(null);
        jTable1.setRowSorter((RowSorter<? extends TableModel>) sorter);
    }//GEN-LAST:event_txtTimTKKeyReleased

    private void txtTimTKFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimTKFocusGained
        if (txtTimTK.getText().equals("Tìm Tài Khoản")) {
            txtTimTK.setText("");
        }
        txtTimTK.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtTimTKFocusGained

    private void txtTimTKFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimTKFocusLost
        if (txtTimTK.getText().equals("")) {
            txtTimTK.setText("Tìm Tài Khoản");
        }
        //[204,204,204]
        txtTimTK.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtTimTKFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaTK;
    private javax.swing.JButton btnThemTK;
    private javax.swing.JButton btnXoaTK;
    private javax.swing.JLabel jLTK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLever;
    private javax.swing.JTextField txtPassWord;
    private javax.swing.JTextField txtTimTK;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}