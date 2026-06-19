package strategy;

public class CheDoYenLang implements CheDoHoatDong {
	@Override
	public void xuLyCuocGoiDen() {
		Utils.rung();
	}

	@Override
	public void xuLyTinNhanDen() {
		System.out.println("Không làm gì");
	}

	@Override
	public void xuLySuKienHeThong() {
		System.out.println("Không làm gì");
	}

	@Override
	public String getName() {
		return "Chế độ Yên Lặng";
	}
}
