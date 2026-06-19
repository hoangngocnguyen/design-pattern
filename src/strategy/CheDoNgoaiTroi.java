package strategy;

public class CheDoNgoaiTroi implements CheDoHoatDong{

	@Override
	public void xuLyCuocGoiDen() {
		Utils.rung();
		Utils.rung();
		Utils.rung();
		
		Utils.phatAmThanh(100, 5);
		
	}

	@Override
	public void xuLyTinNhanDen() {
		Utils.phatAmThanh(100, 1);
	}

	@Override
	public void xuLySuKienHeThong() {
		Utils.phatAmThanh(90, 1);
	}
	
	@Override
	public String getName() {
		return "Chế độ Ngoài trời";
	}

}
