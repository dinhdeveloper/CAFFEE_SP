/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.BanHang;

import Connect.ConnectSQL;
import Interface.QuanLy.Jp_QLThucDon;
import Interface.Run;
import Models.DsOrder;
import Models.HoaDon;
import Models.ThucDon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Dinh
 */
public class JpGoiMon extends javax.swing.JPanel {

    String TenBan;
    int MaBan;
    int MaHD, tienmon = 0, tongtien = 0;
    ConnectSQL cn = new ConnectSQL();
    HoaDon arrhd;
    NumberFormat chuyentien = new DecimalFormat("#,###,###");
    ArrayList<DsOrder> order;
    public static JpGoiMon gm;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
    /**
     * Creates new form JpGoiMon
     */
    public JpGoiMon() {
        initComponents();
    }

    public JpGoiMon(String trangthai, String tenban, int maban) {
        initComponents();
        gm = this;
        MaBan = maban;
        TenBan = tenban;
        
        jpDsMon.setVisible(false);
        jpDsMon.setVisible(false);
        
        arrhd = cn.GetHDbyMaBan(maban);
        if(arrhd != null){
            order = cn.GetDsOrder(arrhd.getMaHoaDon());
            fillDsMon(0);
            MaHD = arrhd.getMaHoaDon();
            lblgioden.setText(df.format(arrhd.getGioDen()));  
        }
        lblTenBan.setText(tenban);
        lbltrangthai.setText(trangthai);

        if(lbltrangthai.getText().equals("Trống")){
            btnDatCho.setText("Đặt chỗ");
            return;
            
        }if(lbltrangthai.getText().equals("Đã đặt trước")){
            btnDatCho.setText("Hủy đặt");
            return;
        }if(lbltrangthai.getText().equals("Đang phục vụ")){
            btnDatCho.setVisible(false);
            btnQuayLai.setVisible(false);
            jpThucDon thucdon = new jpThucDon();
            thucdon.tenban = TenBan;
            thucdon.maban = maban;
            jpthucdon.removeAll();
            jpthucdon.add(thucdon);
            jpthucdon.updateUI();
        }         
    }
    
    public void fillDsMon(int mahd){
        if(mahd != 0){
            order = cn.GetDsOrder(mahd);
            arrhd = cn.GetHDbyMaBan(MaBan);
            tienmon = 0;
        }
        mahd = MaHD;
        if(order != null){
            jpDsMon.setVisible(true);
            jpDsMon.setVisible(true);
            btnDatCho.setText("Thanh toán");
                     
            JPanel[] pn = new JPanel[order.size()];
            jpDsMon.removeAll();
            jpDsMon.setLayout(new BoxLayout(jpDsMon, BoxLayout.Y_AXIS));
            for(int i=0;i<order.size();i++){
                tienmon += order.get(i).getGia() * order.get(i).getSoLuong();
                pn[i] = new JPanel();
                pn[i].setName(order.get(i).getMaMon());
                pn[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                pn[i].setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
                pn[i].setBackground(Color.decode("#b3ff99"));
                pn[i].setLayout(new GridLayout());
                pn[i].setPreferredSize(new Dimension(270, 50));
                pn[i].setMaximumSize(new Dimension(270, 50));
                pn[i].setMinimumSize(new Dimension(270, 50));
                pn[i].add(new JLabel(order.get(i).getTenMon(),JLabel.CENTER)).setForeground(Color.decode("#001a66"));
                pn[i].add(new JLabel(String.valueOf(chuyentien.format(order.get(i).getGia()))+" VNĐ",JLabel.CENTER)).setForeground(Color.decode("#ff0000"));
                pn[i].add(new JLabel(String.valueOf(order.get(i).getSoLuong())+" "+ order.get(i).getDVT(),JLabel.RIGHT)).setForeground(Color.decode("#008000"));
                Icon ic = new ImageIcon("src/Icons/DeleteRed.png");
                JLabel lbl = new JLabel("", ic,JLabel.CENTER);
                lbl.setForeground(Color.decode("#b3ff99"));
                lbl.setName(order.get(i).getMaMon());
                pn[i].add(lbl).addMouseListener(new MouseAdapter() {
                  @Override
                    public void mouseClicked(MouseEvent e){
                        int qs;
                        ArrayList<ThucDon> td = cn.GetHDbyMaBan(e.getComponent().getName());
                        
                        qs = JOptionPane.showConfirmDialog(null, "Hủy món: "+td.get(0).getTenMon()+" ?", "Hủy món", JOptionPane.YES_NO_OPTION);
                        if (qs == JOptionPane.YES_OPTION) {
                            int xoa = cn.DeleteMon(e.getComponent().getName(),MaHD, MaBan);
                            if(xoa == 1){
                                fillDsMon(MaHD);
                            }
                            if(xoa == 2){
                                fillDsMon(MaHD);
                                HuyHD();
                            }
                        }
                    }
                });
                pn[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e){
                        DLSoLuong sl = new DLSoLuong(Run.QlCafe, true, e.getComponent().getName(), TenBan, MaBan);
                        sl.setVisible(true);
                    }
                });
                jpDsMon.add(pn[i]);
                jpDsMon.updateUI();
                
            }

            fillThongTin();
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

        jpThongTinBan = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblTenBan = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblgioden = new javax.swing.JLabel();
        lbltrangthai = new javax.swing.JLabel();
        jpDsMon = new javax.swing.JScrollPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnDatCho = new javax.swing.JButton();
        btnGoiMon = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();
        jpthucdon = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jpThongTinBan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/logo_goi_mon.png"))); // NOI18N

        lblTenBan.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        lblTenBan.setText("BÀN 1");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Giờ Đến:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Status:");

        lblgioden.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblgioden.setText("............................");

        lbltrangthai.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltrangthai.setText("...........................");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Tiền Món:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Giảm Giá:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("0");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("0");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Thành Tiền:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("0");

        btnDatCho.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDatCho.setText("Đặt Chổ");
        btnDatCho.setFocusTraversalPolicyProvider(true);

        btnGoiMon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGoiMon.setText("Gọi Món");
        btnGoiMon.setFocusTraversalPolicyProvider(true);

        btnQuayLai.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnQuayLai.setText("<<");
        btnQuayLai.setFocusTraversalPolicyProvider(true);

        javax.swing.GroupLayout jpThongTinBanLayout = new javax.swing.GroupLayout(jpThongTinBan);
        jpThongTinBan.setLayout(jpThongTinBanLayout);
        jpThongTinBanLayout.setHorizontalGroup(
            jpThongTinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpThongTinBanLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(lblTenBan)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jpThongTinBanLayout.createSequentialGroup()
                .addGroup(jpThongTinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpThongTinBanLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jpThongTinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpThongTinBanLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9))
                            .addGroup(jpThongTinBanLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8))
                            .addGroup(jpThongTinBanLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(lbltrangthai))
                            .addGroup(jpThongTinBanLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblgioden))
                            .addComponent(jpDsMon, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpThongTinBanLayout.createSequentialGroup()
                                .addGroup(jpThongTinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnDatCho)
                                    .addGroup(jpThongTinBanLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11)))
                                .addGap(35, 35, 35)
                                .addComponent(btnGoiMon))))
                    .addGroup(jpThongTinBanLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(btnQuayLai)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jpThongTinBanLayout.setVerticalGroup(
            jpThongTinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpThongTinBanLayout.createSequentialGroup()
                .addGroup(jpThongTinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jpThongTinBanLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblTenBan)))
                .addGap(26, 26, 26)
                .addGroup(jpThongTinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblgioden))
                .addGap(18, 18, 18)
                .addGroup(jpThongTinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbltrangthai))
                .addGap(18, 18, 18)
                .addComponent(jpDsMon, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpThongTinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpThongTinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpThongTinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jpThongTinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDatCho)
                    .addComponent(btnGoiMon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuayLai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/cafe-menu-background-28410418.jpg"))); // NOI18N

        javax.swing.GroupLayout jpthucdonLayout = new javax.swing.GroupLayout(jpthucdon);
        jpthucdon.setLayout(jpthucdonLayout);
        jpthucdonLayout.setHorizontalGroup(
            jpthucdonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpthucdonLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpthucdonLayout.setVerticalGroup(
            jpthucdonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpthucdonLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpThongTinBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpthucdon, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpThongTinBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpthucdon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatCho;
    private javax.swing.JButton btnGoiMon;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jpDsMon;
    private javax.swing.JPanel jpThongTinBan;
    private javax.swing.JPanel jpthucdon;
    private javax.swing.JLabel lblTenBan;
    private javax.swing.JLabel lblgioden;
    private javax.swing.JLabel lbltrangthai;
    // End of variables declaration//GEN-END:variables
}
