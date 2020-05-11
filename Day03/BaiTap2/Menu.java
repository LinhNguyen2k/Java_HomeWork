package BaiTap2;

import java.util.Scanner;

public class Menu {
	public static Scanner input = new Scanner(System.in);
	public static void BaiToan1()
	{
		int  n;
		System.out.println("nhap n:");
		n = input.nextInt();
		if(n==0)
		{
			System.out.println("số không ");
		}
		else if(n==1)
		{
			System.out.println("số một ");
		}
		else if(n==2)
		{
			System.out.println("số hai ");
		}
		else if(n==3)
		{
			System.out.println("số ba ");
		}
		else if(n==4)
		{
			System.out.println("số bốn ");
		}
		else if(n==5)
		{
			System.out.println("số năm ");
		}
		else if(n==6)
		{
			System.out.println("số sáu ");
		}
		else if(n==7)
		{
			System.out.println("số bảy ");
		}
		else if(n==8)
		{
			System.out.println("số tám ");
		}
		else if(n==9)
		{
			System.out.println("số chín");
		}
	}
	public static void BaiToan2()
	{
		double x,s=0;
		System.out.println("nhap x:");
		x = input.nextDouble();
		if(x>2 && x<3)
		{
			s=5*Math.cos(3*x+2)-Math.log(x*x+2);
		}
		else if(x>=3){
			s=(x+3)*(x+3);
		}
		else {
			s=1;
		}
		System.out.println("giá trị của biểu thức là:"+s);
	}
	public static void BaiToan3()
	{ double n,s=0; 
		System.out.println("nhap n:");
		n = input.nextInt();
		if(n<=50)
		{
		s= n*14000;	
		}
		else 
		{
			if(n<=75)
			{
				s=50*14000+(n-50)*(14000-500);
			}
			else if(n<=90)
			{
				s=50*14000+(n-50)*(14000-750);
			}
			else if(n<=105)
			{
				s=50*14000+(n-50)*(14000-1000);
			}
			else
			{
				s=50*14000+(n-50)*(14000-1500);
			}
		}
		System.out.println("số tiền mua gạo của bạn là:"+s);
	}
	public static void BaiToan4()
	{ double ax,ay,bx,by,cx,cy;
		System.out.println("nhap ax:");
		ax = input.nextDouble();
		System.out.println("nhap ay:");
		ay = input.nextDouble();
		System.out.println("nhap bx:");
		bx = input.nextDouble();
		System.out.println("nhap by:");
		by = input.nextDouble();
		System.out.println("nhap cx:");
		cx = input.nextDouble();
		System.out.println("nhap cy:");
		cy = input.nextDouble();
		double s1=Math.sqrt((bx-ax)*(bx-ax)+(by-ay)*(by-ay));
		double s2=Math.sqrt((cx-bx)*(cx-bx)+(cy-by)*(cy-by));
		double s3=Math.sqrt((cx-ax)*(cx-ax)+(cy-ay)*(cy-ay));
		System.out.println("độ dài cạnh AB là:"+s1);
		System.out.println("độ dài cạnh BC là:"+s2);
		System.out.println("độ dài cạnh AC là:"+s3);
		if(s1+s2<=s3 || s2+s3<=s1 || s3+s1<=s2)
		{
			System.out.println("đây không phải là tam giác");
		}
		else
		{
			double ChuVi=s1+s2+s3;
			double DienTich=Math.sqrt((s1+s2+s3)/2*((s1+s2+s3)/2-s1)*((s1+s2+s3)-s2)*((s1+s2+s3)-s3));
			double BanKinh=(s1*s2*s3)/(4*DienTich);
			System.out.println("chu vi của tam giác là:"+ChuVi);
			System.out.println("diện tích của tam giác là:"+DienTich);
			System.out.println("Bán Kính của tam giác là:"+BanKinh);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int BaiToan;
		System.out.println("hay chon mot bai toan:");
		System.out.println("bam 1 chon mot bai toan 1:");
		System.out.println("bam 2 chon mot bai toan 2:");
		System.out.println("bam 3 chon mot bai toan 3:");
		System.out.println("bam 4 chon mot bai toan 4:");
		do {
		System.out.println("bam 0 de thoat chuong trinh:");
		System.out.println("ban chon may:");
		Scanner input = new Scanner(System.in);
		BaiToan = input.nextInt();
		switch(BaiToan){
		case 1:BaiToan1(); break;
		case 2:BaiToan2(); break;
		case 3:BaiToan3(); break;
		case 4:BaiToan4(); break;
		case 0: return ;
		default: System.out.println("chon khong hop le");
		}
		}while(true);
	}

	}

