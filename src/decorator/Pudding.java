package decorator;

//Topping Trân châu
public class Pudding extends ToppingDecorator {
	public Pudding(Drink drink) {
		super(drink);
	}

	@Override
	public String getDescription() {
		return protectedDrink.getDescription() + " + Pudding";
	}

	@Override
	public double getCost() {
		return protectedDrink.getCost() + 7000; // Cộng thêm 7k tiền pudding
	}
}