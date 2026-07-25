package myEntity;

public class Kendaraan {
    private String nopol;
    private String merk;
    private String jenis;
    private int harga;
    private String status;

    // Constructor
    public Kendaraan(String nopol, String merk, String jenis, int harga, String status) {
        this.nopol = nopol;
        this.merk = merk;
        this.jenis = jenis;
        this.harga = harga;
        this.status = status;
    }

    // Getter dan Setter
    public String getNopol() { return nopol; }
    public void setNopol(String nopol) { this.nopol = nopol; }

    public String getMerk() { return merk; }
    public void setMerk(String merk) { this.merk = merk; }

    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }

    public int getHarga() { return harga; }
    public void setHarga(int harga) { this.harga = harga; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}