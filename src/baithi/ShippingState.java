package baithi;

public class ShippingState implements OrderState {

	@Override
	public void confirm(Order order) {
		System.out.println("Đang SHIPPING, không thể chuyển sang CONFIRMED");
	}

	@Override
	public void ship(Order order) {
		System.out.println("Đang SHIPPING, vô tác dụng khi chuyển sang SHIPPING");
	}

	@Override
	public void deliver(Order order) {
		System.out.println("Đang SHIPPING. Chuyển sang DELIVERED");
		order.setCurrentState(new DeliveredState());
	}

	@Override
	public void cancel(Order order) {
		System.out.println("Đang SHIPPING, không thể chuyển sang CANCELLED");
	}
	@Override
	public String getStatusName() {
		return "SHIPPING";
	}

}
