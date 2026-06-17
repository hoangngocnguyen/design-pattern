package baithi;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChuongTrinh {
	public static void main(String[] args) throws SQLException {
		OrderDAO daoOrder = new OrderDAO();
		String orderCodeDraft = "OD-DRAFT-001";
		cau4a(daoOrder, orderCodeDraft);
		cau4b(daoOrder, orderCodeDraft);
	}

	private static void cau4a(OrderDAO daoOrder, String maDonHangDraft) {
		try {
			Order donHang = daoOrder.findOrder(maDonHangDraft);
			inDonHang(donHang);
			
			donHang.confirm(donHang);	//1
			
			daoOrder.updateOrder(donHang); //2
			
			// Sau khi update, lấy ra
			donHang = daoOrder.findOrder(maDonHangDraft);
			inDonHang(donHang);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void cau4b(OrderDAO daoOrder, String maDonHangDraft) {
		try {
			Order donHang = daoOrder.findOrder(maDonHangDraft);
			inDonHang(donHang);
			
			donHang.deliver(donHang);	//1
			
			daoOrder.updateOrder(donHang); //2 ko co tac dung
			
			// Sau khi update, lấy ra
			donHang = daoOrder.findOrder(maDonHangDraft);
			inDonHang(donHang);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void inDonHang(Order order) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dateString = order.getCreatedDate().format(formatter);
		System.out.printf("Đơn hàng: %d, %s, %s, %.2f, %s \n",
				order.getId(),
				order.getOrderCode(),
				dateString,
				order.getTotal(),
				order.getCurrentState().getStatusName());
	}
}
