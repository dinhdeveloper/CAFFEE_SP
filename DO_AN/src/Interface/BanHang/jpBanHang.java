/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.BanHang;

import Connect.ConnectSQL;
import Interface.QuanLy.Jp_QLBan;
import Models.Ban;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Dinh
 */
public class jpBanHang extends javax.swing.JPanel {

    ConnectSQL cn = new ConnectSQL();
    ArrayList<Ban> arrBan;
    ArrayList<Ban> ban;
    int MaBan;
    public static jpBanHang bh;

    /**
     * Creates new form jpBanHang
     */
    public jpBanHang() {
        initComponents();
//        jLBan.setSize(10,10); 
        FillBan();
        Jp_QLBan qlban = new Jp_QLBan();
    }

//    public void getTatCaBan() {
//        try (Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
//                PreparedStatement ps = conn.prepareCall("{call getAllBan}")) {
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                
//            }
//        } catch (Exception e) {
//        }
//    }
    public void FillBan() {
        Jp_QLBan qlban = new Jp_QLBan();

        arrBan = cn.GetBan(0);
        if (arrBan != null) {
            jLBan.removeAll();
            try (Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
                    PreparedStatement ps = conn.prepareCall("{call LoadMaBan}")) {
                ResultSet rs = ps.executeQuery();
                JButton[] btn = new JButton[arrBan.size()];
                for (int i = 0; i < arrBan.size(); i++) {
                    btn[i] = new JButton();
                    btn[i].setName(String.valueOf(arrBan.get(i).getMaBan()));
                    String[] mb = arrBan.get(i).getTenBan().split(" ");
                    btn[i].setText(mb[0]);
                    btn[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/ico-Table.png")));
                    Border thickBorder = new LineBorder(Color.WHITE, 8);
                    btn[i].setBorder(thickBorder);

                    btn[i].setBackground(Color.decode("#8080ff"));
                    btn[i].setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
                    btn[i].setForeground(new java.awt.Color(51, 51, 51));
                    if (arrBan.get(i).getTrangThai().equals("Đang Phục Vụ")) {
                        btn[i].setBackground(Color.decode("#66ff66"));
                    }
                    if (arrBan.get(i).getTrangThai().equals("Đã Đặt Trước")) {
                        btn[i].setBackground(Color.decode("#ff6699"));
                    }
                    btn[i].setPreferredSize(new Dimension(90, 70));
//bắt sự kiện

                    btn[i].addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            JpGoiMon goimon;
                            int maBAN = 0;
                            ArrayList<Ban> arrBan = null;
                            if (maBAN == 0) {
                                try (Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
                                        PreparedStatement ps = conn.prepareCall("{call getAllBan}")) {
                                    ResultSet rs = ps.executeQuery();
                                    arrBan = new ArrayList<Ban>();
                                    while (rs.next()) {
                                        Ban sp = new Ban(rs.getInt(1), rs.getString(2), rs.getString(3));
                                        arrBan.add(sp);
                                    }
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                try (Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
                                        PreparedStatement ps = conn.prepareCall("{call getMaBan(?)}")) {
                                    
                                    ResultSet rs = ps.executeQuery();
                                    arrBan = new ArrayList<Ban>();
                                    while (rs.next()) {
                                        Ban sp = new Ban(rs.getInt(1), rs.getString(2), rs.getString(3));
                                        arrBan.add(sp);
                                    }
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
//                            ban = cn.GetBan(Integer.parseInt(e.getComponent().getName()));
                            if (ban != null) {
                                goimon = new JpGoiMon(ban.get(0).getTrangThai(), ban.get(0).getTenBan(), ban.get(0).getMaBan());
//                                jPanel2.removeAll();
//                                jPanel2.add(goimon);
//                                jPanel2.updateUI();
                            }
                        }
                    });
                    jLBan.add(btn[i]);
                    jLBan.updateUI();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

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
        jpTrangThai = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLBan = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jpTrangThai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton2.setBackground(new java.awt.Color(102, 255, 102));
        jButton2.setForeground(new java.awt.Color(102, 255, 102));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Đang Phục Vụ");

        jButton1.setBackground(new java.awt.Color(128, 128, 255));
        jButton1.setForeground(new java.awt.Color(128, 128, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Trống");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Đã Đặt Trước");

        jButton3.setBackground(new java.awt.Color(255, 102, 153));
        jButton3.setForeground(new java.awt.Color(255, 102, 153));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/cooltext171088793851573.png"))); // NOI18N

        javax.swing.GroupLayout jpTrangThaiLayout = new javax.swing.GroupLayout(jpTrangThai);
        jpTrangThai.setLayout(jpTrangThaiLayout);
        jpTrangThaiLayout.setHorizontalGroup(
            jpTrangThaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTrangThaiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpTrangThaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jpTrangThaiLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jpTrangThaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpTrangThaiLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpTrangThaiLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jpTrangThaiLayout.setVerticalGroup(
            jpTrangThaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTrangThaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTrangThaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpTrangThaiLayout.createSequentialGroup()
                        .addGroup(jpTrangThaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jButton1)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpTrangThaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jpTrangThaiLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(2, 2, 2)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLBan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLBan.setMinimumSize(new java.awt.Dimension(15, 15));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLBan, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                    .addComponent(jpTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLBan, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jpTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/cafe-menu-abstract-pattern-brown-colors-coffee-beans-background-32625326.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 753, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jLBan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpTrangThai;
    // End of variables declaration//GEN-END:variables
}
