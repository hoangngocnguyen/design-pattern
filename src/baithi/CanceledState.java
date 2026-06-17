package baithi;

public class CanceledState implements OrderState{

	@Override
	public void confirm(Order order) {
		System.out.println("Đang CANCELLED, không thể chuyển sang CONFIRMED");
	}

	@Override
	public void ship(Order order) {
		System.out.println("Đang CANCELLED, không thể chuyển sang SHIPPING");
	}

	@Override
	public void deliver(Order order) {
		System.out.println("Đang CANCELLED. không thể chuyển sang DELIVERED");
	}

	@Override
	public void cancel(Order order) {
		System.out.println("Đang CANCELLED, không thể chuyển sang CANCELLED");
	}

	@Override
	public String getStatusName() {
		return "CANCELLED";
	}
}
