package Dao;

import Connect.ConnectSQL;
import Models.Loai;
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
public class NhomMonDAO {
    public static List<Loai> getData(){
        List<Loai> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(ConnectSQL.ConnectSQL());
                PreparedStatement stmt = conn.prepareCall("{call getNhomMon}");
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                Loai nv = new Loai();
                nv.setMaLoai(rs.getString("MaLoai"));
                nv.setTenLoai(rs.getString("TenLoai"));
                nv.setMauSac(rs.getString("MauSac"));
                list.add(nv);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
