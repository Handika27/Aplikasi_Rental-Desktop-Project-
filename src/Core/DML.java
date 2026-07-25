package Core;

import myConnection.DB0;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DML {
    static Connection Cnn;
    static DB0 db = new DB0();
    static Statement st;

    // Fungsi EQuery ini sama persis dengan yang ada di Modul Praktikum Anda
    public static int EQuery(String sql) {
        try { 
            Cnn = db.getConnection();
            st = Cnn.createStatement();
            int i = st.executeUpdate(sql);
            return i;
        } catch (SQLException e) {
            System.out.println("Gagal Eksekusi SQL: " + e.getMessage());
            return 0;
        } finally {
            try {
                if (Cnn != null) Cnn.close();
            } catch (SQLException ex) {
                System.out.println("Gagal menutup koneksi: " + ex.getMessage());
            }
        }
    }
}