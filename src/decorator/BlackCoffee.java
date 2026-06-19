package decorator;

// Đối tượng cơ bản, nguyên bản (Concrete Component)
public class BlackCoffee implements Drink {
    @Override
    public String getDescription() { return "Cà phê đen"; }

    @Override
    public double getCost() { return 20000; } // 20k
}