package decorator;

public class ChuongTrinh {
	public static void main(String[] args) {
        // 1. Gọi một ly cà phê đen nguyên bản
        Drink lyCafe = new BlackCoffee();
        System.out.println(lyCafe.getDescription() + " -> Giá: " + lyCafe.getCost()); 
        // In ra: Cà phê đen -> Giá: 20000.0

        // 2. Khách thích thêm sữa? Bọc ly cafe đó bằng lớp "Milk"
        lyCafe = new Milk(lyCafe);
        System.out.println(lyCafe.getDescription() + " -> Giá: " + lyCafe.getCost());
        // In ra: Cà phê đen + Sữa -> Giá: 25000.0

        // 3. Khách lại thích thêm Pudding? Bọc tiếp ly cafe sữa đó bằng "Pudding"
        lyCafe = new Pudding(lyCafe);
        System.out.println(lyCafe.getDescription() + " -> Giá: " + lyCafe.getCost());
        // In ra: Cà phê đen + Sữa + Pudding -> Giá: 32000.0
    }
}
