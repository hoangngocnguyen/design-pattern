package adapter;

public interface PersonAdapter {
    String getHoTen();
    String getLoai();    // Trả về "SV" hoặc "CN"
    String getXepLoai(); // Trả về "A", "B", "C", "D", "X"
    int getThuTuUuTien(); // Đổi chữ A,B,C.. thành số để máy tính sắp xếp (A là 1, B là 2...)
}
