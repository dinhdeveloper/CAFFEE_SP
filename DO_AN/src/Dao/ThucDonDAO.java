package Dao;

import Connect.ConnectSQL;
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
public class ThucDonDAO {
    public static List<ThucDon> getData(){
        List<ThucDon> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
                PreparedStatement stmt = conn.prepareCall("{call getThucDon}");
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                ThucDon nv = new ThucDon();
                nv.setMaMon(rs.getString("MaMon"));
                nv.setTenMon(rs.getString("TenMon"));
                nv.setMaLoai(rs.getString("MaLoai"));
//                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                nv.setDonGia(rs.getInt("DonGia"));
                nv.setDVT(rs.getString("DVT"));
                list.add(nv);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
