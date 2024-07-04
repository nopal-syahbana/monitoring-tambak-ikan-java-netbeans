/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package setting;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Nopal Nich
 */
public class Koneksi {
    private static String className = "Koneksi";

    public static Connection getConnection() {
        Connection connection = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost/tambak";
        String user = "root";
        String password = "";
        if (connection == null) {
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException | SQLException error) {
                System.err.println("Terjadi kesalahan pada class " + className + ", fungsi getConnection \n Detail : " + error);
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada database,silahkan cek pengaturan database anda");
                System.exit(0);
            }

        }
        return connection;
    }
}


