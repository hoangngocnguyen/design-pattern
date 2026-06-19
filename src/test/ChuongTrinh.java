package test;

import java.sql.SQLException;
import java.time.LocalDate;

public class ChuongTrinh {
	public static void main(String[] args) throws SQLException {
		System.out.println("Hello world");
//		KetNoi a = KetNoi.getInstance();
		
		String ngay = "19/06/2026";
		LocalDate date = Utils.toLocalDate(ngay);
		System.out.println(date);
		
		String out = Utils.toString(date);
		System.out.println(out);
		
		System.out.println(Utils.formatVND(12345.12));
	}
}
