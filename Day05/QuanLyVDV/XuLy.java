package QuanLyVDV;

import java.util.Scanner;

public class XuLy {
	public static String[] name = { "hung", "dung", "linh", "phong", "dat", "kien", "cuong", "khang", "chien",
			"thang" };
	public static int[][] result = { { 136, 147, 150 }, { 136, 147, 150 }, { 190, 135, 122 }, { 111, 122, 133 },
			{ 134, 124, 126 }, { 122, 155, 124 }, { 123, 151, 135 }, { 154, 121, 124 }, { 128, 153, 124 },
			{ 127, 150, 120 } };

	public static int sumresult(int i) {
		int s = 0;
		for (int j = 0; j < 3; j++) {
			s = s + result[i][j];
		}
		return s;
	}

	public static void main(String[] args) {
		int BaiToan;
		System.out.println("-------CHUONG TRINH QUAN LY VDV VU TA-------");
		System.out.println("hay chon mot trong cac yeu cau quan ly sau:");
		System.out.println("\t1. hien thi toan bo danh sach:");
		System.out.println("\t2.xem VDV co tong thanh tich cao nhat:");
		System.out.println("\t3. xem 3 VDV co thanh tich cao nhat:");
		System.out.println("\t4.sap xep danh sach VDV theo ten:");
		System.out.println("\t5. xem cac VDV co ten bat dau bang chu T:");
		System.out.println("\t6. xem cac VDV co van chu an:");
		System.out.println("\t7. sap xep danh sach VDV theo chieu tang dan cua chu cai:");
		System.out.println("\t8. xem cac VDV co cung tong thanh tich va xep thu 2:");
		System.out.println("\t9. 3 VDV co tong 3 lan cu ta thap nhat:");
		System.out.println("\t10. xem cac VDV co lan cu ta thu nhat cao nhat:");
		do {
			System.out.println("bam 0 de thoat chuong trinh:");
			System.out.println("moi ban lua chon :");
			Scanner input = new Scanner(System.in);
			BaiToan = input.nextInt();
			switch (BaiToan) {
			case 1:
				function1();
				break;
			case 2:
				function2();
				break;
			case 3:
				function3();
				break;
			case 4:
				function4();
				break;
			case 5:
				function5();
				break;
			case 6:
				function6();
				break;
			case 7:
				function7();
				break;
			case 8:
				function8();
				break;
			case 9:
				function9();
				break;
			case 10:
				function10();
				break;
			case 0:
				return;
			default:
				System.out.println("chon khong hop le");
			}
		} while (true);
	}

	// Hien thi danh sach va tong thanh tich.
	public static void title() {
		System.out.printf("%-4s", "STT");
		System.out.printf("%-7s ", "Ten");
		System.out.printf("%-4s ", "Lan 1");
		System.out.printf("%-5s ", "Lan 2");
		System.out.printf("%-5s ", "Lan 3");
		System.out.printf("%-5s ", "Tong TT");
		System.out.println();
	}

	public static void function1() {// DANH SACH VDV
		System.out.println("-------DANH SACH TOAN BO VDV VA TONG THANH TICH-------");
		title();
		for (int i = 0; i < name.length; i++)
		// if(name[i].charAt(0)=='t')

		{
			System.out.printf("%3d ", i + 1);
			System.out.printf("%-4s ", name[i]);
			System.out.printf("%5d ", result[i][0]);
			System.out.printf("%5d  ", result[i][1]);
			System.out.printf("%5d  ", result[i][2]);
			System.out.printf("%6d  ", sumresult(i));
			System.out.println();
		}
	}

	public static void function2() {
		int max = sumresult(0);
		int vt = 0;
		for (int i = 0; i < result.length; i++) {
			if (max < sumresult(i)) {
				max = sumresult(i);
				vt = i;
			}
		}
		System.out.println("\n ------VDV co tong 3 la cu ta cao nhat------");
		System.out.println("\tname:" + name[vt] + "\ttong TT:" + max);
	}

	public static void daoten(String[] name, int i, int j) {
		String temp = name[i];
		name[i] = name[j];
		name[j] = temp;
	}

	public static void daoTT(int[][] result, int i, int j) {
		for (int k = 0; k < 3; k++) {
			int temp = result[i][k];
			result[i][k] = result[j][k];
			result[j][k] = temp;
		}
	}

	public static void sort1() {// sap theo tong giam theo thanh tich
		for (int i = 0; i < name.length; i++) {
			for (int j = i + 1; j < name.length; j++)
				if (sumresult(i) < sumresult(j)) {
					daoten(name, i, j);
					daoTT(result, i, j);
				}

		}

	}

	public static void function3() {// DANH SACH 3 VDV CO TONG CU CAO NHAT
		System.out.println("------DANH SACH 3 VDV CO TONG SO LAN CU TA CAO NHAT------");
		title();
		sort1();
		for (int i = 0; i < 3; i++) {
			System.out.printf("%3d ", i + 1);
			System.out.printf("%-8s ", name[i]);
			System.out.printf("%4d ", result[i][0]);
			System.out.printf("%4d ", result[i][1]);
			System.out.printf("%4d ", result[i][2]);
			System.out.printf("%5d ", sumresult(i));
			System.out.println();
		}
	}

	public static void function4() {// SAP XAP TEN THEO VAN
		title();
		sort1();
		for (int i = 0; i < name.length; i++) {
			for (int j = i + 1; j < name.length; j++) {
				if (name[i].compareTo(name[j]) > 0) {
					String tg = name[i];
					name[i] = name[j];
					name[j] = tg;
				}
			}
			System.out.printf("%3d ", i + 1);
			System.out.printf("%-8s ", name[i]);
			System.out.printf("%4d ", result[i][0]);
			System.out.printf("%4d ", result[i][1]);
			System.out.printf("%4d ", result[i][2]);
			System.out.printf("%5d ", sumresult(i));
			System.out.println();
		}

	}

	public static void function5() {// DANH SACH HIEN THI TEN BAT DAU BANG CHU 't'
		for (int i = 0; i < name.length; i++) {
			if (name[i].charAt(0) == 't') {
				System.out.printf("%3d ", i + 1);
				System.out.printf("%-8s ", name[i]);
				System.out.printf("%4d ", result[i][0]);
				System.out.printf("%4d ", result[i][1]);
				System.out.printf("%4d ", result[i][2]);
				System.out.printf("%5d ", sumresult(i));
				System.out.println();

			}
		}
	}

	public static void function6() {// DANH SACH TEN CO XUAT HIEN VAN 'an'
		for (int i = 0; i < name.length; i++) {
			if (name[i].indexOf("an") != -1) {
				System.out.printf("%3d ", i + 1);
				System.out.printf("%-8s ", name[i]);
				System.out.printf("%4d ", result[i][0]);
				System.out.printf("%4d ", result[i][1]);
				System.out.printf("%4d ", result[i][2]);
				System.out.printf("%5d ", sumresult(i));
				System.out.println();

			}
		}
	}

	public static void function7() {// DANH SACH TANG DAN VE DO DAI CUA CHU
		title();
		for (int i = 0; i < name.length; i++) {
			for (int j = i + 1; j < name.length; j++) {
				if (name[i].length() > name[j].length()) {
					daoten(name, i, j);
					daoTT(result, i, j);
				}
			}
			System.out.printf("%3d ", i + 1);
			System.out.printf("%-8s ", name[i]);
			System.out.printf("%4d ", result[i][0]);
			System.out.printf("%4d ", result[i][1]);
			System.out.printf("%4d ", result[i][2]);
			System.out.printf("%5d ", sumresult(i));
			System.out.println();
		}

	}

	public static void function8() {
		title();
		sort1();
		for (int i = 0; i < name.length; i++) {
			for (int j = i + 1; j < name.length; j++)
				if (sumresult(i) < sumresult(j)) {
					daoten(name, i, j);
					daoTT(result, i, j);
				}
			while (sumresult(0) == sumresult(i)) {
				i++;

			}

		}
		for (int i = 1; i < 10; i++) {
			if (sumresult(1) == sumresult(i)) {
				System.out.printf("%3d ", i + 1);
				System.out.printf("%-4s ", name[i]);
				System.out.printf("%5d ", result[i][0]);
				System.out.printf("%5d  ", result[i][1]);
				System.out.printf("%5d  ", result[i][2]);
				System.out.printf("%6d  ", sumresult(i));
				System.out.println();
			}
		}

	}

	public static void function9() {

		title();
		for (int i = 0; i < name.length; i++) {
			for (int j = i + 1; j < name.length; j++) {
				if (sumresult(i) > sumresult(j)) {
					daoten(name, i, j);
					daoTT(result, i, j);
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			System.out.printf("%3d ", i + 1);
			System.out.printf("%-8s ", name[i]);
			System.out.printf("%4d ", result[i][0]);
			System.out.printf("%4d ", result[i][1]);
			System.out.printf("%4d ", result[i][2]);
			System.out.printf("%5d ", sumresult(i));
			System.out.println();
		}
	}

	public static void function10() {
		int vt = 0;
		int max = result[0][0];
		for (int i = 0; i < result[0].length; i++) {
			if (max < result[i][0]) {
				max = result[i][0];
				vt = i;
			}
		}

		System.out.println("\tname:" + name[vt] + "\ttong TT:" + max);

	}
}
