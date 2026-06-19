package adapter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import congnhan.dp.CongNhan;

public class CongNhanAdapter implements PersonAdapter {
    private CongNhan cn;	// has-a

    public CongNhanAdapter(CongNhan cn) {
        this.cn = cn;
    }

    @Override
    public String getHoTen() {
        return cn.getHoTen();
    }

    @Override
    public String getLoai() {
        return "CN";
    }

    @Override
    public String getXepLoai() {
        // Parse ngày để tính thâm niên (giả sử ngày trong CongNhan đang là String)
        long namLamViec = ChronoUnit.YEARS.between(cn.getNgayVaoLam(), LocalDate.now());

        if (namLamViec < 2) return "X"; // Bao gồm dưới 1 năm và dưới 2 năm
        if (namLamViec >= 2 && namLamViec < 3) return "D";
        if (namLamViec >= 3 && namLamViec < 5) return "C";
        if (namLamViec >= 5 && namLamViec < 10) return "B";
        return "A";
    }

    @Override
    public int getThuTuUuTien() {
        String xl = getXepLoai();
        if (xl.equals("A")) return 1;
        if (xl.equals("B")) return 2;
        if (xl.equals("C")) return 3;
        if (xl.equals("D")) return 4;
        return 5;
    }
}
