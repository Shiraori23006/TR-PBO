package Model;

import java.sql.Date;

public class Diskon {
    private int id;
    private Date tanggal;
    private double persen1;
    private double persen2;

    public Diskon() {}

    public Diskon(Date tanggal, double persen1, double persen2) {
        this.tanggal = tanggal;
        this.persen1 = persen1;
        this.persen2 = persen2;
    }

    public int getId() { return id; }
    public Date getTanggal() { return tanggal; }
    public double getPersen1() { return persen1; }
    public double getPersen2() { return persen2; }

    public void setId(int id) { this.id = id; }
    public void setTanggal(Date tanggal) { this.tanggal = tanggal; }
    public void setPersen1(double persen1) { this.persen1 = persen1; }
    public void setPersen2(double persen2) { this.persen2 = persen2; }
}
