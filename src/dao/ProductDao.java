package dao;

import Database.DatabaseConnection;
import Model.Produk;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    // Tambah produk baru ke database
    public void insertProduk(Produk p) {
        String sql = "INSERT INTO produk (nama, harga) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.GetConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, p.getNama());
            stmt.setDouble(2, p.getHarga());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Gagal tambah produk: " + e.getMessage());
        }
    }
    
    public void deleteProduk(int id){
        String sql = "DELETE FROM produk WHERE id=?";
        try(Connection conn = DatabaseConnection.GetConnection();){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Produk Berhasil dihapus");
            }else{
                System.out.println("Produk dengan id " + id + " Tidak Terhapus");
            }
        }
        catch(SQLException e){
            System.out.println("Gagal Menghapus Produk " + e.getMessage());
        }
    }
    
    public void updateProduk (Produk p){
        String sql = "UPDATE produk SET nama = ?, harga = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.GetConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNama());
            stmt.setDouble(2, p.getHarga());
            stmt.setInt(3, p.getId());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Produk berhasil diperbarui (ID: " + p.getId() + ")");
            } else {
                System.out.println("Produk tidak ditemukan untuk diupdate!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal update produk: " + e.getMessage());
        }
    }

    // Ambil semua produk dari database
    public List<Produk> tampilkanSemuaProduk() {
        List<Produk> list = new ArrayList<>();
        String sql = "SELECT * FROM produk";

        try (Connection conn = DatabaseConnection.GetConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produk p = new Produk();
                p.setId(rs.getInt("id"));
                p.setNama(rs.getString("nama"));
                p.setHarga(rs.getDouble("harga"));
                list.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Gagal ambil data: " + e.getMessage());
        }

        return list;
    }
}
