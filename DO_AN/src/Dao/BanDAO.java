package Dao;

import Connect.ConnectSQL;
import Models.Ban;
import Models.Loai;
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
public class BanDAO {
    public static List<Ban> getData(){
        List<Ban> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
                PreparedStatement stmt = conn.prepareCall("{call getAllBan}");
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                Ban nv = new Ban();
                nv.setMaBan(rs.getInt("MaBan"));
                nv.setTenBan(rs.getString("TenBan"));
                nv.setTrangThai(rs.getString("TrangThai"));
                list.add(nv);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
