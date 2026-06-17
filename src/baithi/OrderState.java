package baithi;

public interface OrderState {
	void confirm(Order order);
	void ship(Order order);
	void deliver(Order order);
	void cancel(Order order);
	String getStatusName();
}
