package BaiTap1;

import java.text.NumberFormat;
import java.util.Locale;
public class canBo extends nhanSu{
	Phong phong;
	String chucVu;
	double heSoLuong;
	String xepLoai;

	public canBo() {
		super();
	}

	public canBo(int maNs, String hoDem, String ten, int namSinh, String gioiTinh, Phong phong, String chucVu,
			double heSoLuong, String xepLoai) {
		super(maNs, hoDem, ten, namSinh, gioiTinh);
		this.phong = phong;
		this.chucVu = chucVu;
		this.heSoLuong = heSoLuong;
		this.xepLoai = xepLoai;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public String getXepLoai() {
		return xepLoai;
	}

	public void setXepLoai(String xepLoai) {
		this.xepLoai = xepLoai;
	}

	public String getTenPhong() {
		return phong.getTenPhong();
	}

	public String getTruongPhong() {
		return phong.getTruongPhong();
	}

	public double tinhLuongcb() {
		double luong = 0;
		if (xepLoai == "A") {
			luong = 1150000 * heSoLuong + 1000000;
		} else if (xepLoai == "B") {
			luong = 1150000 * heSoLuong;
		} else if (xepLoai == "C") {
			luong = 1150000 * heSoLuong - 400000;
		} else {
			luong = 1150000 * heSoLuong - 1000000;
		}
		return luong;
	}
	public static double tinhLuongCb(){
		return tinhLuongCb();
	}
	public void hienThicb() {
		 
		System.out.printf("%4d",maNs);
		System.out.printf("\t%-8s",ten);
		System.out.printf("%5d",namSinh);
		System.out.printf("\t\t%-8s",gioiTinh);
		System.out.printf("%-5s",phong.getTenPhong());
		System.out.printf("\t%-13s",phong.getTruongPhong());
		System.out.printf("\t%-12s",chucVu); 
		System.out.printf("%6.0f",heSoLuong);
		System.out.printf("%10s",xepLoai);
		Locale local =new Locale("vi","VN");
		NumberFormat numberFormat = NumberFormat.getInstance(local);
		String moneycb = numberFormat.format(tinhLuongcb());
		System.out.printf("\t%15s",moneycb+"VNĐ");
	}

	public static void hienThiCb() {
		// TODO Auto-generated method stub
		
	}
	}



