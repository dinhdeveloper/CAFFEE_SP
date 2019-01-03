package Dao;

import Connect.ConnectSQL;
import Models.TaiKhoan;
import Models.ThucDon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dinh
 */
public class TaiKhoanDAO {
    public static List<TaiKhoan> getData(){
        List<TaiKhoan> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
                PreparedStatement stmt = conn.prepareCall("{call getAccount}");
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                TaiKhoan nv = new TaiKhoan();
                nv.setId(rs.getInt("id"));
                nv.setUserName(rs.getString("username"));
                nv.setPassWord(rs.getString("password"));
//                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                nv.setLv(rs.getInt("lv"));
                nv.setFullName(rs.getString("fullname"));
                list.add(nv);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
