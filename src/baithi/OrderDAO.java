package baithi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class OrderDAO {
	// Dựa vào câu 4.
	// 1. Lấy đơn hàng theo orderCode
	public Order findOrder(String orderCode) throws SQLException {
        String sql = "SELECT * FROM Orders WHERE order_code = ?";
        
        KetNoi a = KetNoi.getInstance();
        
        try (Connection conn = a.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, orderCode);
            
            try (ResultSet rs = ps.executeQuery()) {
                
                if (rs.next()) {
                	int id = rs.getInt("id");
                	String code = rs.getString("order_code");
                	LocalDateTime date = rs.getObject("created_date", LocalDateTime.class);
                	double total = rs.getDouble("total_amount");
                	String status = rs.getString("status");
                	OrderState orderState = OrderStateFactory.getState(status);
                    Order order = new Order(id, code, date, total, orderState);
                    
                    return order; 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null; // Không tìm thấy hoặc xảy ra lỗi thì trả về null
	}
	
	// 2. Cập nhật đơn hàng (trang thai)
	public boolean updateOrder (Order order) throws SQLException {
        String sql = "UPDATE Orders SET total_amount = ?, status = ? WHERE order_code = ?";

        KetNoi a = KetNoi.getInstance();
        
        try (Connection conn = a.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setDouble(1, order.getTotal());
            ps.setString(2, order.getCurrentState().getStatusName());
            ps.setString(3, order.getOrderCode()); 

            int rowsAffected = ps.executeUpdate();
            
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
}


