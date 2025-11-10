package dao;

import Database.DatabaseConnection;
import Model.Diskon;
import java.sql.*;

public class DiskonDao {

    public Diskon getDiskonHariIni() {
        double persen1 = 0;
        double persen2 = 0;
        String sql = "SELECT persen1, persen2 FROM diskon WHERE hari = DAYOFWEEK(CURDATE())";

        try (Connection conn = DatabaseConnection.GetConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                persen1 = rs.getDouble("persen");
                persen2 = rs.getDouble("persen2");
            }

        } catch (SQLException e) {
            System.out.println("Gagal ambil diskon: " + e.getMessage());
        }

        return new Diskon(persen1, persen2);
    }
}
