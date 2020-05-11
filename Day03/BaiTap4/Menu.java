package BaiTap4;

import java.util.Scanner;

public class Menu {
	public static Scanner input = new Scanner(System.in);
	public static void BaiToan1()
	{ 
		int dem=0,n,i;
		System.out.println("nhập n:");
		n = input.nextInt();
		if(n<2) 
		{
			System.out.println("không có số NT nào");
		}
		else
		{
			for(i=2;i<n;i++)
			if(n%i==0) dem=dem+1;
			if(dem!=0) 
				System.out.println(n+" không phải SNT");
			else
				System.out.println(n+" là SNT");
	    }
	}
	public static int snt(int n)
	{
		int dem=0,i;
		if(n<2) return 0;
		for(i=2;i<n;i++)
			{
			if(n%i==0) dem=dem+1;
			if(dem!=0) return 0;
			}
		return 1;
	}
	public static void BaiToan2()
	{
		int n,s=0,i,dem=0;
		System.out.println("nhập n:");
		n = input.nextInt();
		for(i=2;dem<n;i++)
		{
			if(snt(i)==1)
				s=s+i;
			dem++;
		}
		System.out.println("tổng của n SNT là:"+s);
	}
	public static void BaiToan3()
	{
		int i,j;
		for(i=2;i<=10;i++)
		{
			for(j=1;j<=10;j++)
			{
				System.out.println(i+"*"+j+"="+j*i);
			}
			System.out.println("\t");
		}
	}
	public static float gt(int n)
	{
		if(n==0 || n==1)
			return 1;
		else return n*gt(n-1);
	}
	public static void BaiToan4()
	{
		 double x,esl,val=1;
			int i=1,n;
					System.out.print("nhap so thuc x:");
					x = input.nextDouble();
					System.out.print("nhap sai so esl :");
					esl = input.nextDouble();
					System.out.print("nhap n");
					n = input.nextInt();
					double s=1;
					while(Math.abs(s)>=esl)
					{
						s=Math.pow(-1,i)* Math.pow(x, 2*i+1)/gt(2*i+1);
						val +=s;
						i++;
					}
					System.out.print("sin"+x+" = "+ val);
	}
	public static long Fibonacci( int n)
	{
		if(n==0||n==1)
			return 1;
		else return Fibonacci(n-1) + Fibonacci(n-2);
	}
	public static void BaiToan5()
	{ 
		int i,n;
		System.out.print("nhap so nguyen x:");
		n= input.nextInt();
		System.out.print("day fibonacci la:");
		for(i=0;i<n;i++)
			System.out.print(Fibonacci(i)+"\t");		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int BaiToan;
		System.out.println("hay chon mot bai toan:");
		System.out.println("bam 1 chon mot bai toan 1:");
		System.out.println("bam 2 chon mot bai toan 2:");
		System.out.println("bam 3 chon mot bai toan 3:");
		System.out.println("bam 4 chon mot bai toan 4:");
		System.out.println("bam 4 chon mot bai toan 5:");
		System.out.println("bam 0 de thoat chuong trinh:");
		System.out.println("ban chon may:");
		Scanner input = new Scanner(System.in);
		BaiToan = input.nextInt();
		switch(BaiToan){
		case 1:BaiToan1(); break;
		case 2:BaiToan2(); break;
		case 3:BaiToan3(); break;
		case 4:BaiToan4(); break;
		case 5:BaiToan5(); break;
		case 0: return ;
		default: System.out.println("chon khong hop le");
		}		

	}

}
