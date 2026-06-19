package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dp.SinhVien;

public class Utils {
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	// Đọc file
	public static List<SinhVien> readFromFile(String filename) throws IOException {
		List<SinhVien> lst = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(filename));
		while (true) {
			String line = br.readLine();
			if (line == null)
				break;

			// Tách chuỗi: mã sinh viên,họ đệm, tên,điểm trung bình
			String[] info = line.split(",");
			if (info.length < 4)
				continue;

			String maSinhVien = info[0];
			String hoDem = info[1];
			String ten = info[2];

			String stDiemTrungBinh = info[3];
			double diemTrungBinh = Double.parseDouble(stDiemTrungBinh);

			SinhVien x = new SinhVien(maSinhVien, hoDem, ten, diemTrungBinh);

			lst.add(x);
		}
		br.close();

		return lst;
	}

	// Ghi file
	public static void writeToFile(String filename, List<SinhVien> lst) throws IOException {
		// Dùng BufferedWriter để ghi file tối ưu hiệu năng
		BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

		for (SinhVien sv : lst) {
			// Nối các thuộc tính thành 1 chuỗi phân tách bằng dấu phẩy đúng định dạng đọc
			String line = sv.getMaSinhVien() + "," + sv.getHoDem() + "," + sv.getTen() + "," + sv.getDiemTrungBinh();

			bw.write(line);
			bw.newLine(); // Xuống dòng cho sinh viên tiếp theo
		}

		bw.close(); // Bắt buộc phải close để dữ liệu thực sự được ghi xuống ổ đĩa
	}

	// --- STRING -> DATE (Parse từ file "19/06/2026" thành đối tượng Java) ---
	public static LocalDate toLocalDate(String dateStr) {
		if (dateStr == null || dateStr.trim().isEmpty())
			return null;
		return LocalDate.parse(dateStr, DATE_FORMATTER);
	}

	public static LocalDateTime toLocalDateTime(String dateTimeStr) {
		if (dateTimeStr == null || dateTimeStr.trim().isEmpty())
			return null;
		return LocalDateTime.parse(dateTimeStr, DATETIME_FORMATTER);
	}

	// --- DATE -> STRING (Chuyển ngược lại để in ra màn hình hoặc ghi vào file) ---
	public static String toString(LocalDate date) {
		if (date == null)
			return "";
		return date.format(DATE_FORMATTER);
	}

	public static String toString(LocalDateTime dateTime) {
		if (dateTime == null)
			return "";
		return dateTime.format(DATETIME_FORMATTER);
	}

	// CurrencyUtil
	// Biến 250000 -> "250,000 VND" hoặc "250.000 VND" tùy cấu hình máy
	public static String formatVND(double amount) {
		DecimalFormat formatter = new DecimalFormat("###,###,### VND");
		return formatter.format(amount);
	}

}
