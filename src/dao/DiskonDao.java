package dao;

import Database.DatabaseConnection;
import Model.Diskon;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiskonDao {

    public Diskon getDiskonHariIni() {
    Diskon diskon = null;
    String sql = "SELECT * FROM diskon WHERE tanggal = CURDATE() ORDER BY id ASC LIMIT 1";

    try (Connection conn = DatabaseConnection.GetConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        if (rs.next()) {
            diskon = new Diskon();
            diskon.setId(rs.getInt("id"));
            diskon.setTanggal(rs.getDate("tanggal"));
            diskon.setPersen1(rs.getDouble("persen1"));
            diskon.setPersen2(rs.getDouble("persen2"));
        }

    } catch (SQLException e) {
        System.out.println("Gagal ambil diskon hari ini: " + e.getMessage());
    }

        return diskon; // bisa null kalau tidak ada diskon hari ini
    }


    public void insertDiskon(Diskon d) {
        String sql = "INSERT INTO diskon (tanggal, persen1, persen2) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.GetConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, d.getTanggal());
            stmt.setDouble(2, d.getPersen1());
            stmt.setDouble(3, d.getPersen2());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal tambah diskon: " + e.getMessage());
        }
    }

    public void deleteDiskon(int id) {
        String sql = "DELETE FROM diskon WHERE id = ?";
        try (Connection conn = DatabaseConnection.GetConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal hapus diskon: " + e.getMessage());
        }
    }

    public void updateDiskon(Diskon d) {
        String sql = "UPDATE diskon SET tanggal=?, persen1=?, persen2=? WHERE id=?";
        try (Connection conn = DatabaseConnection.GetConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, d.getTanggal());
            stmt.setDouble(2, d.getPersen1());
            stmt.setDouble(3, d.getPersen2());
            stmt.setInt(4, d.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal update diskon: " + e.getMessage());
        }
    }

    public List<Diskon> getSemuaDiskon() {
    List<Diskon> list = new ArrayList<>();
    String sql = "SELECT * FROM diskon ORDER BY tanggal DESC";

    try (Connection conn = DatabaseConnection.GetConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            Diskon d = new Diskon();
            d.setId(rs.getInt("id"));
            d.setTanggal(rs.getDate("tanggal"));
            d.setPersen1(rs.getDouble("persen1"));
            d.setPersen2(rs.getDouble("persen2"));
            list.add(d);
        }

    } catch (SQLException e) {
        System.out.println("Gagal ambil semua diskon: " + e.getMessage());
    }

    return list;
}

}
