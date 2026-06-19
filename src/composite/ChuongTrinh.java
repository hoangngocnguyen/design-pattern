package composite;

import java.util.List;

public class ChuongTrinh {
	public static void main(String[] args) {
		// 1. Tạo các Product lẻ
		Component sofa = new Product("Sofa cao cấp", 15000000, 1);
		Component banTra = new Product("Bàn trà gỗ", 3500000, 1);
		Component tham = new Product("Thảm trải sàn lông cừu", 2000000, 1);
		Component goi4 = new Product("Gối tựa lưng", 250000, 4); // Số lượng là 4

		Component denDung = new Product("Đèn đứng cổ điển", 1200000, 2); // Số lượng là 2
		Component denBan = new Product("Đèn bàn học", 450000, 1);
		Component keTv = new Product("Kệ TV", 4000000, 1);

		Component manHinh = new Product("Màn hình 55 inch", 12000000, 1);
		Component loa = new Product("Loa soundbar", 3500000, 1);
		Component goi2 = new Product("Gối tựa lưng", 250000, 2); // Số lượng là 2

        // 2. Lắp ráp "Combo Phòng khách cơ bản"
        Combo comboCoBan = new Combo("Combo Phòng khách cơ bản");
        comboCoBan.add(sofa);
        comboCoBan.add(banTra);
        comboCoBan.add(tham);
        comboCoBan.add(goi4);

        // 3. Lắp ráp "Combo Ánh sáng"
        Combo comboAnhSang = new Combo("Combo Ánh sáng");
        comboAnhSang.add(denDung);
        comboAnhSang.add(denBan);

        // 4. Lắp ráp "Combo Phòng khách cao cấp" (Chứa combo con và product)
        Combo comboCaoCap = new Combo("Combo Phòng khách cao cấp");
        comboCaoCap.add(comboCoBan);
        comboCaoCap.add(comboAnhSang);
        comboCaoCap.add(keTv);

        // 5. Lắp ráp "Combo Giải trí"
        Combo comboGiaiTri = new Combo("Combo Giải trí");
        comboGiaiTri.add(manHinh);
        comboGiaiTri.add(loa);

        // 6. Gốc của cây: "Trọn bộ nội thất phòng khách"
        Combo tronBoNoiThat = new Combo("Trọn bộ nội thất phòng khách");
        tronBoNoiThat.add(comboCaoCap);
        tronBoNoiThat.add(comboGiaiTri);
        tronBoNoiThat.add(goi2);
        
        tronBoNoiThat.in("");
		
	}
}
