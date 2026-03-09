
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;

public class SQLServerConnect {
    public static Connection getConnection() {
        Connection con = null;
        try {
            // Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Chuỗi kết nối
            String url =
                "jdbc:sqlserver://localhost:1433;" +
                "databaseName=QLBanHangDT;" +
                "encrypt=false";
            String user = "sa";
            String pass = "123";
            
            // Kết nối
            con = DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.println("Kết nối SQL Server thành công");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy Driver JDBC");
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối CSDL: " + e.getMessage());
        }
        return con;
    }
    public static void closeConnection(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Đã đóng kết nối CSDL");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi đóng kết nối: " + e.getMessage());
        }
    }
}
