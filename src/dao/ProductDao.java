package dao;

import Database.DatabaseConnection;
import java.sql.*;
import java.util.Scanner;

public class ProductDao {
    Scanner input = new Scanner(System.in);

    public void insertProduk(String nama, double harga) {
        String sql = "INSERT INTO produk (nama, price) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.GetConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nama);
            stmt.setDouble(2, harga);
            stmt.executeUpdate();
            System.out.println("Produk berhasil ditambahkan");
        } catch (SQLException e) {
            System.out.println("Gagal tambah produk: " + e.getMessage());
        }
    }

    public void tampilkanSemuaProduk() {
        String sql = "SELECT * FROM produk";
        try (Connection conn = DatabaseConnection.GetConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("nama") + " | Rp" +
                    rs.getDouble("price")
                );
            }

        } catch (SQLException e) {
            System.out.println("Gagal ambil data: " + e.getMessage());
        }
    }

    public void tampilkanProdukById() {
        System.out.print("Masukkan ID produk: ");
        int id = input.nextInt();

        String sql = "SELECT * FROM produk WHERE id = ?";
        try (Connection conn = DatabaseConnection.GetConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("nama") + " | Rp" +
                    rs.getDouble("price")
                );
            } else {
                System.out.println("Produk dengan ID tersebut tidak ditemukan.");
            }

        } catch (SQLException e) {
            System.out.println("Gagal ambil data: " + e.getMessage());
        }
    }
}
