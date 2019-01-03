package Connect;

import Interface.Run;
import Models.Ban;
import Models.ChiTietHD;
import Models.DsOrder;
import Models.HoaDon;
import Models.Loai;
import Models.TaiKhoan;
import Models.ThucDon;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dinh
 */
public class ConnectSQL {

    private Connection cn;

    public static String ConnectSQL() {
        String url = null;
        try (FileInputStream stream = new FileInputStream("db.properties")) {
            Properties properties = new Properties();
            properties.load(stream);
            url = properties.getProperty("url") + properties.getProperty("serverName") + ":"
                    + properties.getProperty("portNumber") + "; databaseName = " + properties.getProperty("databaseName")
                    + "; user = " + properties.getProperty("user")
                    + "; password = " + properties.getProperty("password")
                    + "; integratedSecurity = " + properties.getProperty("integratedSecurity");
        } catch (Exception ex) {
            ex.printStackTrace();
            url = null;
        }
        return url;
    }

    //kiểm tra đăng nhập
    public boolean CheckLogin(TaiKhoan tk) {
        boolean check = false;
        try (Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
                PreparedStatement ps = conn.prepareCall("{call getTaiKhoan(?,?)}")) {
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Run.QLCF();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi đăng nhập !");
        }
        return check;
    }

    public int LVTK(TaiKhoan tk) {
        int lvtk = 0;
        try (Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
                PreparedStatement ps = conn.prepareCall("{call getLvTaiKhoan(?)}")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lvtk = rs.getInt(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return lvtk;
    }

    //get tài khoản
    public TaiKhoan GetTaiKhoan(String name, String pass) {
        TaiKhoan td = null;
        try (Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
                PreparedStatement ps = conn.prepareCall("{call getTK}")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                td = new TaiKhoan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "lỗi tên đăng nhập và mật khẩu !");
        }
        return td;
    }

    public int UpdateTK(TaiKhoan b) {
        int update = 0;
        String sql = "UPDATE TAIKHOAN SET username = '" + b.getUserName() + "', password = '" + b.getPassWord() + "', lv = '" + b.getLv() + "' WHERE id = '" + b.getId() + "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return update;
    }

    //lấy ra tất cả loại sản phẩm
    public ArrayList<Loai> GetLoai() {
        ArrayList<Loai> arrloai = null;
        try (Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
                PreparedStatement ps = conn.prepareCall("{call getTK}")) {
            ResultSet rs = ps.executeQuery();
            arrloai = new ArrayList<Loai>();
            while (rs.next()) {
                Loai sp = new Loai(rs.getString(1), rs.getString(2), rs.getString(3));
                arrloai.add(sp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrloai;
    }

    //lấy ra tất cả các bàn
    public ArrayList<Ban> GetBan(int maBAN) {
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

//        String sql;
//        if (maBAN == 0) {
//            sql = "Select * From BAN";
//        } else {
//            sql = "Select * From BAN Where MaBan = '" + maBAN + "'";
//        }
//        try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
        return arrBan;
    }

    //hóa đơn
    public int GetMaHD(int ma) {
        String sql;
        int mahd = 0;
        sql = "Select MaHoaDon From HOADON Where MaBan = '" + ma + "' AND TrangThai = 0";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                mahd = rs.getInt(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return mahd;
    }

    public int UpdateHD(HoaDon hd) {
        int update = 0;
        String sql = "UPDATE HOADON SET GiamGia = '" + hd.getGiamGia() + "' WHERE MaHoaDon = '" + hd.getMaHoaDon() + "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Giảm giá không thành công !");
        }
        return update;
    }

    public int InsertChiTietHD(ChiTietHD cthd) {
        int insert = 0;
        String sql = "Insert into CHITIETHOADON (MaHoaDon, MaMon, SoLuong, Gia) values ('" + cthd.getMaHoaDon() + "', '" + cthd.getMaMon() + "', '" + cthd.getSoLuong() + "', '" + cthd.getGia() + "')";
        try {
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm chi tiết hóa đơn không thành công !" + ex.toString());
        }
        return insert;
    }//nhóm món

    public Vector GetNhomMon() {
        Vector arrloai = null;
        try (Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
                PreparedStatement ps = conn.prepareCall("{call getNhomMon}")) {
            ResultSet rs = ps.executeQuery();
            arrloai = new Vector();
            Loai all = new Loai();
            arrloai.add(all);
            while (rs.next()) {
                Loai sp = new Loai(rs.getString(1), rs.getString(2), rs.getString(3));
                arrloai.add(sp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrloai;
    }

    //gọi món
    public ArrayList<DsOrder> GetDsOrder(int ma) {
        ArrayList<DsOrder> arrDs = null;
        try (Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
                PreparedStatement ps = conn.prepareCall("{call getDsOrder(?)}")) {
            ResultSet rs = ps.executeQuery();
            arrDs = new ArrayList<DsOrder>();
            while (rs.next()) {
                DsOrder order = new DsOrder(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách Order !");
        }
        return arrDs;
    }

    public HoaDon GetHDbyMaBan(int ma) {
        String sql;
        HoaDon arrhd = null;
        try(Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
                PreparedStatement ps = conn.prepareCall("{ call getHDByMaBan(?)}")){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                arrhd = new HoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),rs.getTimestamp(6));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách hóa đơn !");
        }
        return arrhd;
    }
    public int DeleteMon(String mamon, int mahd, int maBAN){
        int check = 0;
        try{
            String sql;
            sql = "Delete From CHITIETHOADON Where MaMon = '"+mamon+"' AND MaHoaDon = '"+mahd+"'";
            Statement st = cn.createStatement();
            st.executeUpdate(sql);
            check = 1;
            if(CheckDsMon(mahd, maBAN) == 0){
                check = 2;
            }
        }catch(SQLException ex){
            
        }
        return check;
    }
    public int CheckDsMon(int mahd, int maBAN){
        int dem = 0;
        try(Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
                PreparedStatement ps = conn.prepareCall("{call CheckDsMon(?,?)}")){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                dem++;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách hóa đơn !");
        }
        return dem;        
    }
    public int HuyHD(HoaDon hd){
        int update = 0;
        try(Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
                PreparedStatement ps = conn.prepareCall("{call HuyHD(?)}")){
            update = ps.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Thanh toán không thành công !");
        }
        return update;        
    }   
}
