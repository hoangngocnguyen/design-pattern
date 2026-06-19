package adapter;

import dp.SinhVien;

public class SinhVienAdapter implements PersonAdapter{
	private SinhVien sv;
	
	public SinhVienAdapter(SinhVien sv) {
        this.sv = sv;
    }
	
	@Override
    public String getHoTen() {
        return sv.getHoDem() + " " + sv.getTen();
    }

    @Override
    public String getLoai() {
        return "SV";
    }

    @Override
    public String getXepLoai() {
        double dtb = sv.getDiemTrungBinh();
        if (dtb < 4.0) return "X";
        if (dtb >= 4.0 && dtb < 6.5) return "D";
        if (dtb >= 6.5 && dtb < 7.5) return "C";
        if (dtb >= 7.5 && dtb < 8.5) return "B";
        return "A";
    }

    @Override
    public int getThuTuUuTien() {
        // Đổi sang số để tí nữa Collections.sort cho dễ (A ưu tiên nhất -> số nhỏ nhất)
        String xl = getXepLoai();
        if (xl.equals("A")) return 1;
        if (xl.equals("B")) return 2;
        if (xl.equals("C")) return 3;
        if (xl.equals("D")) return 4;
        return 5; // X
    }
	
}
