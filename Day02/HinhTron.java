package bai3;

public class HinhTron {
	 public static double ChuVi(double r)
	{
		return 2*Math.PI*r;
	}
    public static double DienTich(double r)
    {
    	return Math.PI*Math.pow(r,2);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double r=2;
		double P=ChuVi(r);
		double S=DienTich(r);
		System.out.println("chu vi ="+P);
		System.out.println("dien tich="+S);
	}

}
