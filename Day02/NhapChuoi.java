package bai7;

import java.util.Scanner;

public class NhapChuoi {
    public static String nhap() 
    {    String n;
    	 Scanner input = new Scanner(System.in);
    	 System.out.print("nhap n:");
    	 n = input.nextLine();
    	 return n;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String n;
         String t=nhap();
         System.out.printf("chuoi vua nhap la:"+t);
	}

}
