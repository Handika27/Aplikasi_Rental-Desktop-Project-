package Core;

public class Session {
    private static String id_petugas;
    private static String nama;
    private static String status;

    public static String getIdPetugas() { return id_petugas; }
    public static void setIdPetugas(String id) { id_petugas = id; }

    public static String getNama() { return nama; }
    public static void setNama(String nm) { nama = nm; }

    public static String getStatus() { return status; }
    public static void setStatus(String st) { status = st; }
}