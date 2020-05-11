package bai9;

public class ToanTu {
     public static void ThucHien(float a,float b,float c) {
    	 float max;
    	 max=a;	
    		max=(a>b) ? max : b;
    		max=(a>c) ? max : c;
    		System.out.print("gia tri lon hon la:"+max);
    	 
     }
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		float a=100,b=9,c=20;
       ThucHien(a,b,c);
         
	}

}
