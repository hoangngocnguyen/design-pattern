package baithi;

import java.time.LocalDateTime;

public class Order {
	private int id;
	private String orderCode;
	private LocalDateTime createdDate;
	private double total;
	private OrderState currentState;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public OrderState getCurrentState() {
		return currentState;
	}
	public void setCurrentState(OrderState currentState) {
		this.currentState = currentState;
	}
	public Order(int id, String orderCode, LocalDateTime createdDate, double total, OrderState currentState) {
		super();
		this.id = id;
		this.orderCode = orderCode;
		this.createdDate = createdDate;
		this.total = total;
		this.currentState = currentState;
	}
	public Order() {
		super();
	}
	
	
	
	
	// State
	public void confirm(Order order) {
		this.currentState.confirm(this);
	}

	public void ship(Order order) {
		this.currentState.ship(order);
	}

	public void deliver(Order order) {
		this.currentState.deliver(order);
	}

	public void cancel(Order order) {
		this.currentState.cancel(order);
	}
}
