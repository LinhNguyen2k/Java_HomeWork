package bai2;

import java.util.Scanner;

public class TamGiac {
	public static void nhap(float a, float b, float h)
	{
		if(a+b<=h || a+h<=b || b+h<=a)
		System.out.print("day khong phai tam giac");
	}
	public static float ChuVi(float a, float b, float h)
	{
		return a+b+h;
	}
	public static double DienTich(float a, float b, float h)
	{		
		return Math.sqrt((a+b+h)/2*((a+b+h)/2-a)*((a+b+h)-b)*((a+b+h)-h));
	}
	public static void main(String[] args) {
			float a,b,h;
        Scanner input = new Scanner(System.in);
        System.out.print("nhap a:");
        a = input.nextFloat();
        System.out.print("nhap b:");
        b = input.nextFloat();
        System.out.print("nhap h:");
        h = input.nextFloat();    
		double P=ChuVi(a,b,h);
		double S=DienTich(a,b,h);
		System.out.println("chu vi ="+P);
		System.out.println("dien tich="+S);
	}

}
