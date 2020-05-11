package BaiTap1;

public class nhanSu {
	int maNs;
	String hoDem;
	String ten;
	int namSinh;
	String gioiTinh;
	public nhanSu(int maNs, String hoDem, String ten, int namSinh, String gioiTinh) {
		super();
		this.maNs = maNs;
		this.hoDem = hoDem;
		this.ten = ten;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		
	}
	public void hienThicb() {
		 canBo.hienThiCb();
	}
	public void hienThicn() {
		congNhan.hienThiCn();
	}
	public double tinhLuongcb() {
		return canBo.tinhLuongCb();
	}
	public double tinhLuongcn() {
		return congNhan.tinhLuongCn();
	}
	public nhanSu() {
		super();
	}
	public int getMaNs() {
		return maNs;
	}
	public void setMaNs(int maNs) {
		this.maNs = maNs;
	}
	public String getHoDem() {
		return hoDem;
	}
	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	
}
