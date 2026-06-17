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
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
//	        System.out.println("Kết nối với CSDL thành công!");
	    } catch (ClassNotFoundException e) {
//	        System.out.println("Lỗi: Không tìm thấy Driver MySQL!");
	        throw new SQLException("MySQL JDBC Driver not found.", e);
	    } catch (SQLException e) {
	        // Đây là nơi chương trình sẽ nhảy vào khi Docker bị tắt
	        System.out.println("Kết nối với CSDL thất bại!.");
	        throw e; // Ném lỗi lên để nơi gọi hàm biết mà xử lý
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
