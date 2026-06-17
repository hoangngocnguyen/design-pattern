package baithi;

public class DeliveredState implements OrderState{

	@Override
	public void confirm(Order order) {
		System.out.println("Đang DELIVERED, không thể chuyển sang CONFIRMED");
	}

	@Override
	public void ship(Order order) {
		System.out.println("Đang DELIVERED, không thể chuyển sang SHIPPING");
	}

	@Override
	public void deliver(Order order) {
		System.out.println("Đang DELIVERED. không thể chuyển sang DELIVERED");
	}

	@Override
	public void cancel(Order order) {
		System.out.println("Đang DELIVERED, không thể chuyển sang CANCELLED");
	}
	
	@Override
	public String getStatusName() {
		return "DELIVERED";
	}
}
