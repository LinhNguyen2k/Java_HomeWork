package Java_Core;

public class LoaiHang {
private int loaiHangID;
private String tenLoai;
public LoaiHang() {
	super();
}
public LoaiHang(int iD, String tenLoai) {
	super();
	ID = iD;
	this.tenLoai = tenLoai;
}
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getTenLoai() {
	return tenLoai;
}
public void setTenLoai(String tenLoai) {
	this.tenLoai = tenLoai;
}
}
