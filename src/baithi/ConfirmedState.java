package baithi;

public class ConfirmedState implements OrderState{

	@Override
	public void confirm(Order order) {
		System.out.println("Đang CONFIRMED, chuyển sang CONFIRMED không có tác dụng gì.");
	}

	@Override
	public void ship(Order order) {
		System.out.println("Đang CONFIRMED, chuyển sang SHIPPING");
		order.setCurrentState(new ShippingState());
	}

	@Override
	public void deliver(Order order) {
		System.out.println("Đang CONFIRMED. Không chuyển sang DELIVERED được");
	}

	@Override
	public void cancel(Order order) {
		System.out.println("Đang CONFIRMED, chuyển sang CANCELLED");
		order.setCurrentState(new CanceledState());
	}
	
	@Override
	public String getStatusName() {
		return "CONFIRMED";
	}

}
