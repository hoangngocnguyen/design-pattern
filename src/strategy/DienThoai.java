package strategy;

public class DienThoai {
	private CheDoHoatDong cheDoHienTai;
	
	// Khoi tao voi che do Chuan
	public DienThoai() {
		this.cheDoHienTai = new CheDoChuan();
	}


	public void setCheDoHoatDong(CheDoHoatDong cheDoHoatDong) {
		this.cheDoHienTai = cheDoHoatDong;
	}
	
	
	// Các hàm kích hoạt sự kiện - ủy quyền thẳng cho Strategy xử lý
    public void onCalling() {
        System.out.println("[SỰ KIỆN]: Có cuộc gọi đến ---");
        cheDoHienTai.xuLyCuocGoiDen();
    }

    public void onSMSReceived() {
        System.out.println("[SỰ KIỆN]: Có tin nhắn đến ---");
        cheDoHienTai.xuLyTinNhanDen();
    }

    public void onSystemNotification() {
        System.out.println("[SỰ KIỆN]: Có sự kiện hệ thống ---");
        cheDoHienTai.xuLySuKienHeThong();
    }
    
    public String getTenCheDo() {
    	return cheDoHienTai.getName();
    }
}
