package myEntity;

public class Sewa {
    private String idSewa;
    private String nik;
    private String nopol;
    private String tglSewa;
    private int durasi;
    private int totalHarga;
    private String statusSewa;

    // Constructor
    public Sewa(String idSewa, String nik, String nopol, String tglSewa, int durasi, int totalHarga, String statusSewa) {
        this.idSewa = idSewa;
        this.nik = nik;
        this.nopol = nopol;
        this.tglSewa = tglSewa;
        this.durasi = durasi;
        this.totalHarga = totalHarga;
        this.statusSewa = statusSewa;
    }

    // Getter (Pengambil Nilai)
    public String getIdSewa() { return idSewa; }
    public String getNik() { return nik; }
    public String getNopol() { return nopol; }
    public String getTglSewa() { return tglSewa; }
    public int getDurasi() { return durasi; }
    public int getTotalHarga() { return totalHarga; }
    public String getStatusSewa() { return statusSewa; }
}