package strategy;

public class ChuongTrinh {
	public static void main(String[] args) {
			// khởi tạo đối tượng điện thoại với chế độ hđộng đầu là "Chuẩn"
			DienThoai dt = new DienThoai(); 
	
			// 1.a) thiết lập trạng thái Ngoài trời cho dt
			dt.setCheDoHoatDong(new CheDoNgoaiTroi());
			System.out.println(dt.getTenCheDo());
			// 1.b) thử minh hoạ khi có tin nhắn đến cho dt
			dt.onSMSReceived();
	
			// 1.c) thử minh hoạ khi có sự kiện hệ thống cho dt
			dt.onSystemNotification();
	
			// 1.d) thử minh hoạ khi có cuộc gọi đến cho dt
			dt.onCalling();
			
			// 2.a) thiết lập trạng thái Yên lặng cho dt
			dt.setCheDoHoatDong(new CheDoYenLang());
			System.out.println(dt.getTenCheDo());
	
			// 2.b) thử minh hoạ khi có tin nhắn đến dt
			dt.onSMSReceived();
	
			// 2.c) thử minh hoạ khi có cuộc gói đến cho dt
			dt.onCalling();
	}
}
