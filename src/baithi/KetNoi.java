package baithi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoi {
    private static KetNoi instance;
    private Connection connection;

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=OrderDB;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASSWORD = "123456";

    private KetNoi() throws SQLException {
        try {
            // SỬA: Thay driver MySQL thành driver của MS SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Kết nối với MS SQL Server thành công!");
        } catch (ClassNotFoundException e) {
            // SỬA: Cập nhật thông báo lỗi cho đúng với SQL Server
            System.out.println("Lỗi: Không tìm thấy Driver MS SQL Server!");
            throw new SQLException("MS SQL Server JDBC Driver not found.", e);
        } catch (SQLException e) {
            // Đây là nơi chương trình sẽ nhảy vào khi Docker bị tắt hoặc sai thông tin đăng nhập
            System.out.println("Kết nối với MS SQL Server thất bại! Kiểm tra lại URL, User, Password hoặc Docker.");
            throw e; 
        }
    }

    public static KetNoi getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new KetNoi();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}