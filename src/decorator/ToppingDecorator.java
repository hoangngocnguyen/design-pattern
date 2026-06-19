package decorator;

// Lớp Decorator cha (Bắt buộc phải chứa 1 biến của Interface gốc)
// Từ khóa mấu chốt: implements lớp cha VÀ chứa một thực thể của lớp cha
public abstract class ToppingDecorator implements Drink {
    protected Drink protectedDrink; // Cái đồ uống đang được bọc bên trong

    public ToppingDecorator(Drink drink) {
        this.protectedDrink = drink;
    }
}