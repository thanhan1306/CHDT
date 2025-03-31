package DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.commons.dbutils.DbUtils;

public class MySQLConnection {
    private Connection con;
    private String url;
    private String username;
    private String password;
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    public MySQLConnection() {
        DbUtils.loadDriver(JDBC_DRIVER);
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/dbconfig.properties"));
            this.url = properties.getProperty("url");
            this.username = properties.getProperty("username");
            this.password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        if (con == null) {
            openConnection();
        }
        return con;
    }


    public void openConnection() {
        try {
            this.con = DriverManager.getConnection(url, username, password);
            if (this.con != null) {
                System.out.println("✅ Kết nối thành công đến database: " + url);
            } else {
                System.out.println("⚠️ Kết nối trả về null, kiểm tra lại thông tin!");
            }
        } catch (SQLException e) {
            System.err.println("⛔ Lỗi kết nối database: " + url);
            e.printStackTrace();
        }
    }


    public void closeConnection() {
        try {
            DbUtils.close(con);
        } catch (SQLException e) {
            System.out.println("Something went wrong when closing database");;
        }
    }
}
