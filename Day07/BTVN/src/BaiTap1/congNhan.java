package BaiTap1;

import java.text.NumberFormat;
import java.util.Locale;
public class congNhan extends nhanSu{
	xuongSX xuongSx;
	String congViec;
	int soNgayCong;
	public congNhan() {
		super();
	}
	public congNhan(int maNs, String hoDem, String ten, int namSinh, String gioiTinh, xuongSX xuongSx, String congViec,
			int soNgayCong) {
		super(maNs, hoDem, ten, namSinh, gioiTinh);
		this.xuongSx = xuongSx;
		this.congViec = congViec;
		this.soNgayCong = soNgayCong;
	}
	
	public String getTenXuong() {
		return xuongSx.getTenXuong();
	}
	public String getQuanDoc() {
		return xuongSx.getQuanDoc();
	}
	public int getSoCongNhan() {
		return xuongSx.getSoCongNhan();
	}
	public int getSoNgayCong() {
		return soNgayCong;
	}
	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}
	public double tinhLuongcn() {
		double luong;
		if(soNgayCong <=0) return 0;
		else if(soNgayCong>=23) {
			luong=soNgayCong*250000+500000;
		}
		else if(soNgayCong>=20) {
			luong=soNgayCong*250000+300000;
		}
		else if(soNgayCong>=18) {
			luong=soNgayCong*250000;
		}
		else {
			luong=soNgayCong*250000-200000;
		}
		return luong;
	}
	public static double tinhLuongCn() {
		return tinhLuongCn();
	}
	public void hienThicn() {
		System.out.printf("%4d",maNs);
		System.out.printf("\t%-8s",ten);
		System.out.printf("%5d",namSinh);
		System.out.printf("\t\t%-8s",gioiTinh);
		System.out.printf("%-8s",xuongSx.getTenXuong());
		System.out.printf("%18s",xuongSx.getQuanDoc());
		System.out.printf("%3d",xuongSx.getSoCongNhan());
		System.out.printf("%16s",congViec);
		System.out.printf("%10d",soNgayCong);
		Locale local =new Locale("vi","VN");
		NumberFormat numberFormat = NumberFormat.getInstance(local);
		String moneycn = numberFormat.format(tinhLuongcn());
		System.out.printf("\t%18s",moneycn+"VNĐ");
	}
	public static void hienThiCn() {
		// TODO Auto-generated method stub
		
	}
}
