package myConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DB0 {
    public Connection getConnection() {
        Connection cn = null;
        try {
            // Nama database disesuaikan dengan milik Anda di phpMyAdmin
            String db = "dbrental2"; 
            String url = "jdbc:mysql://localhost:3306/" + db;
            
            // Driver khusus untuk mysql-connector versi 8 ke atas
            String driver = "com.mysql.cj.jdbc.Driver"; 
            
            Class.forName(driver);
            cn = DriverManager.getConnection(url, "root", "");
            return cn;
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "Error SQL di DB0: " + s.getMessage());
            return null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Umum di DB0: " + e.getMessage());
            return null;
        }
    }
}