package bai6;

import java.util.Scanner;

public class ThucHien {
         public static float XuLy( )
         {  float n;
        	 Scanner input = new Scanner(System.in);
        	 System.out.print("nhap n:");
        	 n = input.nextFloat();
        	 return n;
         }
         public static void HienThi(float n )
         {
        	 System.out.print("chu so n la:"+n);
         }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	float n;
		float t = XuLy();
		HienThi(t);
   
	}

}
