package strategy;

public class CheDoChuan implements CheDoHoatDong{

	@Override
	public void xuLyCuocGoiDen() {
		Utils.rung();
		Utils.phatAmThanh(80, 3);
	}

	@Override
	public void xuLyTinNhanDen() {
		Utils.phatAmThanh(60, 1);
	}

	@Override
	public void xuLySuKienHeThong() {
		Utils.phatAmThanh(50, 1);
	}
	
	@Override
	public String getName() {
		return "Chế độ Chuẩn";
	}

}
