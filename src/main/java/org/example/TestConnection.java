package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void test() {
        String url = "jdbc:mysql://localhost:3306/CHDT?useSSL=false&serverTimezone=UTC";
        String user = "root"; // Thay bằng user của bạn
        String password = "123456"; // Thay bằng mật khẩu của bạn

        try {
            // Kiểm tra xem MySQL Connector có hoạt động không
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Kết nối đến MySQL
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Kết nối thành công đến MySQL!");
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("⛔ Lỗi: Không tìm thấy MySQL Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("⛔ Lỗi kết nối MySQL!");
            e.printStackTrace();
        }
    }
}
