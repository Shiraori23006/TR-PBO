package Model;
public class Produk {

    private int id;
    private String nama;
    private Double harga;
    
    public Produk(int id, String nama, Double harga){
        this.id = id;
        this.nama = nama;
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
