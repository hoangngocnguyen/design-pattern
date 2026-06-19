package decorator;

// Topping Sữa
public class Milk extends ToppingDecorator {
	public Milk(Drink drink) {
		super(drink); // Gọi đến constructor: ToppingDecerator -> this.protectedDrink = drink;
	}

	@Override
	public String getDescription() {
		return protectedDrink.getDescription() + " + Sữa";
	}

	@Override
	public double getCost() {
		return protectedDrink.getCost() + 5000; // Cộng thêm 5k tiền sữa
	}
}