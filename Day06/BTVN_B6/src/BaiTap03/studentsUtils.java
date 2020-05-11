package BaiTap03;

import java.util.Scanner;

public class studentsUtils {
	static Scanner in = new Scanner(System.in);
	public static Subjects[] diem = new Subjects[6];
	public static students sv = new students(2018602659, "Nguyễn Anh Linh", "27/09/2000", "Công Nghệ Thông Tin", diem);

	public static void titel() {
		System.out.printf("%-4s", "STT");
		System.out.printf("%-7s ", "Mã HP |");
		System.out.printf("%-7s ", "    Tên Học Phần |  ");
		System.out.printf("%-8s ", " Số Tín Chỉ |");
		System.out.printf("%-8s ", " Điểm Học Phần |");
		System.out.println();
	}

	public static void swap(int i, int j) {
		String tgname = diem[i].getName();
		diem[i].setName(diem[j].getName());
		diem[j].setName(tgname);

		double tgdiem = diem[i].getMark();
		diem[i].setMark(diem[j].getMark());
		diem[j].setMark(tgdiem);

		int tgTinChi = diem[i].getCredit();
		diem[i].setCredit(diem[j].getCredit());
		diem[j].setCredit(tgTinChi);

		int tgcode = diem[i].getCode();
		diem[i].setCode(diem[j].getCode());
		diem[j].setCode(tgcode);

	}

	public static void function1() {
		System.out.println("-----------------BẢNG ĐIỂM CÁ NHÂN------------------\n");
		System.out.println("Mã Sinh Viên:" + sv.getCode() + "\t\t Họ Và Tên:" + sv.getName() + "\n Ngày Sinh:"
				+ sv.getYears() + "\t\t Ngành:" + sv.getNganh());
		System.out.println();
		titel();
		for (int i = 0; i < diem.length; i++) {
			for (int j = i + 1; j < diem.length; j++) {
				if (diem[i].getCode() > diem[j].getCode()) {
					swap(i, j);
				}
			}
			System.out.printf("%-3s",i+1);
			diem[i].display();
			
		}
		System.out.println(avgMark());
	}

	static public double avgMark() {
		double t = 0;
		int d = 0;
		for (int i = 0; i < diem.length; i++) {
			t += diem[i].getMark() * diem[i].getCredit();
			d += diem[i].getCredit();
		}
		return t / d;
	}

	static public void function2() {
		System.out.println("Mã Sinh Viên:" + sv.getCode() + "\t\t Họ Và Tên:" + sv.getName() + "\n Ngày Sinh:"
				+ sv.getYears() + "\t\t Ngành:" + sv.getNganh());
		System.out.println(" New name:");
		in.nextLine();
		String newName = in.nextLine();
		System.out.println("new Ngày Tháng Năm Sinh:");
		String newyears = in.nextLine();
		System.out.print("new ngành:");
		String newNganh = in.nextLine();
		sv.setName(newName);
		sv.setYears(newyears);
		sv.setNganh(newNganh);
		System.out.println("Tên Mới" + newName);
		System.out.println(" Ngày Tháng năm sinh mới" + newyears);
		System.out.println(" Nghành mới" + newNganh);
	}

	static public void function3() {
		titel();
		for (int i = 0; i < diem.length; i++) {
			if (diem[i].getMark() < 6) {
				System.out.println("----DANH SÁCH HỌC PHẦN CÓ ĐIỂM DƯỚI 6 LÀ----");
			}
			System.out.printf("%3d ", i + 1);
			System.out.printf("%5d ", diem[i].getCode());
			System.out.printf("%5s   ", diem[i].getName());
			System.out.printf("%5s   \t \t ", diem[i].getCredit());
			System.out.printf("%5s \t   ", diem[i].getMark());

			System.out.println();
		}
	}

	static public void function4() {
		Scanner in = new Scanner(System.in);
		System.out.print("nhap ma hoc phan can sua :");
		int code = in.nextInt();
		int i = 0;

		while (i < diem.length && diem[i].getCode() != code) {
			i++;
		}
		if (i == diem.length) {
			System.out.println("Ma vua nhap khong ton tai");
			return;
		}
		System.out.println("new học phần mới: ");
		in.nextLine();
		String newName = in.nextLine();
		System.out.println("new số tín chỉ:");
		int newTinChi = in.nextInt();
		System.out.println("new điểm học phần:");
		int newĐiemHP = in.nextInt();
		System.out.println("new điểm tổng kết:");
		diem[i].setName(newName);
		diem[i].setCredit(newTinChi);
		diem[i].setMark(newĐiemHP);
		titel();
		System.out.printf("%3d ", i + 1);
		System.out.printf("%3s\t ", diem[i].getCode());
		System.out.printf("%1s\t\t ", diem[i].getName());
		System.out.printf("%1s \t\t ", diem[i].getCredit());
		System.out.printf("%1s\t \t", diem[i].getMark());
		System.out.println();
		function1();
	}

	public static void main(String[] args) {
		diem[0] = new Subjects(101, "Lập trình căn bản", 3, 8.2);
		diem[1] = new Subjects(102, "Kỹ thuật lập trình", 4, 9.1);
		diem[2] = new Subjects(103, "Cơ sở dữ liệu", 3, 8.5);
		diem[3] = new Subjects(104, "Lập trình Java", 3, 9.5);
		diem[4] = new Subjects(105, "Pháp luật đại cương", 2, 5.4);
		diem[5] = new Subjects(106, "NLCB Mác - LêNin", 5, 4.6);
		System.out.println("------------------------------MENU CHƯƠNG TRÌNH------------------------------\n");
		System.out.println("\t\t\t0. Thoát chương trình ");
		System.out.println("\t\t\t1. Hiển thị các danh sách");
		System.out.println("\t\t\t2.Sửa thông tin về sinh viên");
		System.out.println("\t\t\t3.  Hiển thị các học phần có điểm dưới 6.0.");
		System.out.println("\t\t\t4. Sửa thông tin về học phần");
		System.out.println();
		int chose;
		do {
			System.out.print("\t Bạn chọn việc thứ mấy (0->4) ? : ");
			chose = in.nextInt();
			switch (chose) {
			case 0:
				System.out.println("Chương trình đã thoát !");
				return;
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
			default:
				System.out.println("Khong hop le");
				break;
			}
		} while (true);
	}

}
