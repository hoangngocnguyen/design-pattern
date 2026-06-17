package baithi;

public class DraftState implements OrderState{

	@Override
	public void confirm(Order order) {
		System.out.println("Đang DRAFT, chuyển sang CONFIRMED");
		order.setCurrentState(new ConfirmedState());
	}

	@Override
	public void ship(Order order) {
		System.out.println("Đang DRAFT. Không chuyển sang SHIPPING được");
		
	}

	@Override
	public void deliver(Order order) {
		System.out.println("Đang DRAFT. Không chuyển sang DELIVERED được");
	}

	@Override
	public void cancel(Order order) {
		System.out.println("Đang DRAFT, chuyển sang CANCELLED");
		order.setCurrentState(new CanceledState());
	}
	@Override
	public String getStatusName() {
		return "DRAFT";
	}
}
