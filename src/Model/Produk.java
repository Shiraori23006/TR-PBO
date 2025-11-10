package Model;
public class Produk {

    private int id;
    private String nama;
    private Double harga;
    private int stok;
    
    
    public Produk() {
        
    }
    
    public Produk(String nama, Double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }
    
    public Produk(int id, String nama, Double harga, int stok) {
    this.id = id;
    this.nama = nama;
    this.harga = harga;
    this.stok = stok;
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

    public void setStok(int stok) {
        this.stok = stok;
    }

    

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }

    public Double getHarga() {
        return harga;
    }
    
//    @override
//    public String toString(){
//        return name + " - Rp" + price;
//    }
    
}
