package BaiTap1;

public class Phong{
	String tenPhong; 
	String truongPhong;
	public Phong() {
		super();
	}
	public Phong(String tenPhong, String truongPhong) {
		super();
		this.tenPhong = tenPhong;
		this.truongPhong = truongPhong;
	}
	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	public String getTruongPhong() {
		return truongPhong;
	}
	public void setTruongPhong(String truongPhong) {
		this.truongPhong = truongPhong;
	}
}
