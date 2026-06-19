package composite;

public class Product implements Component {
	private String name;
	private double price;
	private int quantity;

	public Product() {
		super();
	}

	public Product(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public double getTongTien() {
		return (double) this.price * this.quantity;
	}

	@Override
	public void in(String indent) {
		// In cấu trúc product
		System.out.println(indent + "|-- " + this.name);
	}

}
