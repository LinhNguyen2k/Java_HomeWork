package MaTran;
import java.util.Scanner;
public class ThucHien {
	public static int [][]a = new int[][] {
		{4,5,8,9},
		{3,7,9,2},
		{9,0,4,2},
		{5,3,6,7}		
	};

	public static void htMT(int [][]a) {
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++)
			{
				System.out.printf("%5d",a[i][j]);
			}
			System.out.println();
		}
	}
	public static void ChuyenVi(int [][]a) {
		int [][]b = new int[a[0].length][a.length];
		for(int i=0; i<a.length;i++) {
			for(int j=0;j<a[i].length;j++)
				b[j][i]=a[i][j];
		}
		htMT(b);
	}
	public static void Tich(int [][]a)
	{
		int [][]c = new int[4][4];
		{
			int [][]b = new int[a[0].length][a.length];
			for(int i=0; i<a.length;i++) {
				for(int j=0;j<a[i].length;j++)
					b[j][i]=a[i][j];
			}
		for(int i=0;i<a.length;i++) {

			for(int j=0;j<a[0].length;j++) {
				c[i][j]=0;
				for(int k=0;k<a[i].length;k++) {
					c[i][j]=c[i][j]+a[i][k]*b[k][j];
				}
			}
		}
		}
		htMT(c);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ma tran a la:");
           htMT(a);
   		System.out.println("ma tran chuyen vi la:");
		ChuyenVi(a);
   		System.out.println("tich hai ma tran la:");
		Tich(a);
	}

}
