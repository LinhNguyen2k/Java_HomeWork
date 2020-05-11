package HoGiaDinh;
import java.util.Scanner;
public class ThucHien {
			public static String[] name = 
				{ "Dung", "Truong", "Trung", "Chien", "Binh", "Hong", "Trang", "Thuy", "Phong","Linh" };
			public static int[] cto = { 100, 58, 234, 111, 235, 100, 98, 106, 501, 46 };
			public static String swapten(String x1,String y1) {
				StringBuilder x = new StringBuilder(x1);
				StringBuilder y = new StringBuilder(y1);
				StringBuilder tg = new StringBuilder();
				tg.append(x);
				x.delete(0, x.length());
				x.insert(0,y);
				y.delete(0, y.length());
				y.insert(0,tg);
				x1=x.toString();
				y1=y.toString();
				return x1;
			}
			public static long TienDien(int soKwh) {
				long t = 0;
				if (soKwh <= 50)
					t = soKwh * 1678;
				else if (soKwh <= 100)
					t = 50 * 1678 + (soKwh - 50) * 1734;
				else if (soKwh <= 200)
					t = 50 * 1678 + 50 * 1734 + (soKwh - 100) * 2014;
				else if (soKwh <= 300) {
					t = 50 * 1678 + 50 * 1734 + 100 * 2014 + (soKwh - 200) * 2536;
				} else if (soKwh <= 400) {
					t = 50 * 1678 + 50 * 1734 + 100 * 2014 + 100 * 2536 + (soKwh - 300) * 2834;
				} else
					t = 50 * 1678 + 50 * 1734 + 100 * 2014 + 100 * 2536 + 100 * 2834 + (soKwh - 400) * 2927;
				return t;
			}
			public static void sxHoMax(){
				for(int i=0;i<cto.length-1;i++) {
					for(int j=i+1;j<cto.length;j++) {
						if(cto[i]>cto[j]) {
							int tg=cto[i];
							cto[i]=cto[j];
							cto[j]=tg;
							String tg1=name[i];
							name[i]=swapten(name[i],name[j]);
							name[j]=swapten(name[i],tg1);
						}
					}
				}			
			}
			public static void sxTen() {
				for(int i=0;i<name.length-1;i++) {
					for(int j=i+1;j<name.length;j++) {
						if(name[i].compareTo(name[j]) > 0) {
							String tg1 =name[i];
							name[i]=swapten(name[i],name[j]);
							name[j]=swapten(name[j],tg1);
							int tg = cto[j];
							cto[j] = cto[i];
							cto[i] = tg;
						}
					}
				}
				System.out.println("-------DANH SACH CAC HO GIA DINH-------"); 
				System.out.println("STT Ten      So Kwh  	Thanh Tien"); 
				for(int i=0;i<name.length;i++) {
					System.out.printf("%2d.",(i+1));
					System.out.printf(" %-10s",name[i]);
					System.out.printf("%6d",cto[i]);
					System.out.printf("%12d vnd\n",TienDien(cto[i])); 
				}
			}
			public static void timTen() {
				for(int i=0;i<name.length;i++)
				{
					if(name[i]=="Truong") {
						System.out.println(name[i]);
						System.out.println("STT Ten      So Kwh  	Thanh Tien"); 
							System.out.printf("%2d.",(i+1));
							System.out.printf(" %-10s",name[i]);
							System.out.printf("%6d",cto[i]);
							System.out.printf("%12d vnd\n",TienDien(cto[i])); 
					}
				}
				
				
			}
			public static void timMax() {
				System.out.println("3 ho co so cto dien lon nhat la:");
				sxHoMax();
				for(int i=9;i>=7;i--) {
					System.out.printf("%2d.",(10-i));
					System.out.printf(" %-10s",name[i]);
					System.out.printf("%6d",cto[i]);
					System.out.printf("%12d vnd\n",TienDien(cto[i])); 
				}
			}
			public static void hienThi() {
				System.out.println("-------DANH SACH CAC HO GIA DINH-------"); 
				System.out.println("STT Ten      So Kwh  	Thanh Tien"); 
				for(int i=0;i<name.length;i++) {
					System.out.printf("%2d.",(i+1));
					System.out.printf(" %-10s",name[i]);
					System.out.printf("%6d",cto[i]);
					System.out.printf("%12d vnd\n",TienDien(cto[i])); 
				}
			}	
			public static void main(String[] args) {
				
				int BaiToan;
				System.out.println("hay chon mot bai toan:");
				System.out.println("bam 1 chon mot bai toan 1:");
				System.out.println("bam 2 chon mot bai toan 2:");
				System.out.println("bam 3 chon mot bai toan 3:");
				System.out.println("bam 4 chon mot bai toan 4:");
				System.out.println("bam 5 chon mot bai toan 5:");
				do {
				System.out.println("bam 0 de thoat chuong trinh:");
				System.out.println("ban chon may:");
				Scanner input = new Scanner(System.in);
				BaiToan = input.nextInt();
				switch(BaiToan){
				case 1:hienThi(); break;
				case 2:sxHoMax(); break;
				case 3:sxTen(); break;
				case 4: timTen(); break;
				case 5:timMax(); break;
				case 0: return ;
				default: System.out.println("chon khong hop le");
				}
				}while(true);
			}
}
			
	
