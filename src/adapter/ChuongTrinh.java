package adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import congnhan.dp.CongNhan;
import congnhan.dp.CongNhanReader;
import dp.SinhVien;
import dp.SinhVienReader;

public class ChuongTrinh {
	public static void main(String[] args) throws IOException {
		// Danh sách chung (sv, công nhân)
		List<PersonAdapter> lst = new ArrayList<PersonAdapter>();
		
		// Đọc sinh viên và nạp vào
		List<SinhVien> lstSinhVien = SinhVienReader.readFromFile("sinhvien.txt");
		for (SinhVien sv : lstSinhVien) {
            lst.add(new SinhVienAdapter(sv));
        }
		
		// Đọc công nhân và nạp vào
		List<CongNhan> lstCongNhan = CongNhanReader.docDanhSach("congnhan.txt");
		for (CongNhan sv : lstCongNhan) {
            lst.add(new CongNhanAdapter(sv));
        }
		
		
		// 3. Sắp xếp danh sách chung theo thứ tự độ ưu tiên (Thứ tự tăng dần: 1 -> 5 tương ứng A -> X)
		Collections.sort(lst, (p1, p2) -> Integer.compare(p1.getThuTuUuTien(), p2.getThuTuUuTien()));

        // 4. In ra màn hình chuẩn định dạng đề bài
        System.out.printf("%-10s %-25s %-12s %-15s\n", "STT", "Họ tên", "Loại", "Độ ưu tiên");
        int stt = 1;
        for (PersonAdapter p : lst) {
            System.out.printf("%-10d %-25s %-12s %-15s\n", 
                    stt++, 
                    p.getHoTen(), 
                    p.getLoai(), 
                    p.getXepLoai());
        }
	}
}
