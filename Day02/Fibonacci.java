package bai5;

public class Fibonacci {

	private static int fibonacci(int k) {
		if(k==1||k==2)
			return 1;
		else return ;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("15 số đầu tiên trong dãy Fibonacci:");
		for(int i=1; i<15; i++) {
			System.out.print((fibonacci(i))+"\t");
		}
	}

}
