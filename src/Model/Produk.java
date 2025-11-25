package Model;
public class Produk {

    private int id;
    private String nama;
    private Double harga;
    
    
    public Produk() {
        
    }
    
    public Produk(String nama, Double harga) {
        this.nama = nama;
        this.harga = harga;
    }
    
    public Produk(int id, String nama, Double harga) {
    this.id = id;
    this.nama = nama;
    this.harga = harga;
}


    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }
  
    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public Double getHarga() {
        return harga;
    }
    
//    @override
//    public String toString(){
//        return name + " - Rp" + price;
//    }
    
}
