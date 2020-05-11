package BaiTAP2;

import java.util.ArrayList;
import java.util.Scanner;

public class AllUtilsFootball {

	static ArrayList<footballPlayer> list = new ArrayList<footballPlayer>();
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		list.add(new footballPlayer(101, "NguyenAnh", "Linh", 20, "Nam", "Tien dao", 150));
		list.add(new footballPlayer(102, "NguyeDuc", "Diep", 20, "Nam", "Trung ve", 200));
		list.add(new footballPlayer(103, "VuVan", "Doan", 20, "Nam", "Hau ve", 200));
		list.add(new footballPlayer(104, "NguyenVan", "Manh", 20, "Nam", "Thu mon", 100));
		System.out.println("\t\t--------------DANH SACH CAC CAU THU TRONG CLUB-----------------");
		displayList();
		System.out.println("\t\t----------------------------------------------------------------");
		System.out.println("\t1.Thêm cầu thủ vào cuối danh sách");
		System.out.println("\t2.Hiển thị danh sách");
		System.out.println("\t3.Chèn thêm một cầu thủ vào vị trí k");
		System.out.println("\t4.Sắp xếp danh sách theo tên cầu thủ tên / vị trí");
		System.out.println("\t5.Hiển thị danh sách cầu thủ theo vị trí được lựa chọn");
		System.out.println("\t6.Hiển thị thông tin một cầu thủ theo mã");
		System.out.println("\t0.Thoát");
		int chose;
		do {
			System.out.print("Nhập lựa chọn: ");
			chose = in.nextInt();
			switch (chose) {
			case 0:
				return;
			case 1:
				try {
					list.add(createFootballPlayer());
				} catch (playerException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				displayList();
				break;
			case 3:
				try {
					addFootballPlayer();
				} catch (playerException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				sortList();
				break;
			case 5:
				displaybyVitri();
				break;
			case 6:
				displayPlayerByCode();
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ");
				return;
			}
		} while (true);
	}

	public static footballPlayer createFootballPlayer() throws playerException {
		//
		System.out.print("\tNhập mã cầu thủ: ");
		int code = in.nextInt();
		//
		String firstName = "";
		System.out.print("\tNhập họ đệm: ");
		in.nextLine();
		firstName = in.nextLine();
		for (int i = 0; i < firstName.length(); i++)
			if (!isLower(firstName.charAt(i)) && !isUper(firstName.charAt(i))) {
				throw new playerException("Họ đệm chỉ được chứa chữ cái thường hoặc in hoa");
			}
		String name = "";
		System.out.print("\tNhập tên: ");
		name = in.nextLine();
		for (int i = 0; i < name.length(); i++)
			if (!isLower(name.charAt(i)) && !isUper(name.charAt(i))) {
				throw new playerException("Tên chỉ được chứa chữ cái thường hoặc in hoa");
			}
		System.out.print("\tNhập tuổi: ");
		int age = in.nextInt();
		if (age < 16 || age > 40) {
			throw new playerException("Tuổi chỉ từ 16 đến 40");
		}
		String gender = "";
		System.out.print("\tNhập giới tính: ");
		in.nextLine();
		gender = in.nextLine();
		if (gender.compareTo("Nam") != 0) {
			throw new playerException("giới tính phải là nam");
		}
		String location = "";
		System.out.print("\tNhập vị trí: ");
		location = in.nextLine();
		if (location.length() == 0) {
			throw new playerException("Vị trí không được để trống");
		}

		System.out.print("\tNhập lương: ");
		int salary = in.nextInt();
		footballPlayer fp = new footballPlayer(code, firstName, name, age, gender, location, salary);
		return fp;
	}

	public static boolean isLower(char let) {
		return let >= 'a' && let <= 'z';
	}

	public static boolean isUper(char let) {
		return let >= 'A' && let <= 'Z';
	}

	public static void displayList() {
		int stt = 1;
		for (footballPlayer fp : list) {
			System.out.print(stt + ". ");
			stt++;
			System.out.println(fp.toString());
		}
	}

	public static void addFootballPlayer() throws playerException {
		System.out.print("\tNhập vị trí cần chèn: ");
		int k = in.nextInt();
		if (k < 1 || k > list.size()) {
			throw new playerException("Vị trí phải thuộc " + 1 + " => " + (list.size()));
		}
		System.out.print("\tNhập mã cầu thủ cần thêm: ");
		int newCode = in.nextInt();
		int index = indexOfPlayerList(newCode);
		if (index != -1) {
			System.out.println("Cầu thủ này đã có trong danh sách");
			return;
		}
		try {
			list.add(k - 1, createFootballPlayer());
		} catch (playerException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int indexOfPlayerList(int code) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCode() == code) {
				return i;
			}
		}
		return -1;
	}

	public static void sortList() {
		System.out.println("\t1. Sắp xếp danh sách theo tên");
		System.out.println("\t2. Sắp xếp danh sách theo vị trí");
		System.out.println("\t3. Hiển thị lại danh sach");
		System.out.println("\t4. Quay lại");
		int chose;
		do {
			System.out.print("Nhập lựa chọn: ");
			chose = in.nextInt();
			switch (chose) {
			case 0:
				return;
			case 1:
				for (int i = 0; i < list.size() - 1; i++)
					for (int j = i + 1; j < list.size(); j++) {
						if (list.get(i).getName().compareTo(list.get(j).getName()) > 0) {
							footballPlayer fp = list.get(i);
							list.set(i, list.get(j));
							list.set(j, fp);
						}
					}
				System.out.println("Danh sách đã được sắp xếp theo tên");
				break;
			case 2:
				for (int i = 0; i < list.size() - 1; i++)
					for (int j = i + 1; j < list.size(); j++) {
						if (list.get(i).getViTri().compareTo(list.get(j).getViTri()) > 0) {
							footballPlayer fp = list.get(i);
							list.set(i, list.get(j));
							list.set(j, fp);
						}
					}
				System.out.println("\tDanh sách đã được sắp xếp theo vị trí");
				break;
			case 3:
				displayList();
				break;
			default:
				System.out.println("không hợp lệ");
				return;
			}
		} while (true);
	}

	public static void displaybyVitri() {
		System.out.print("Nhập vị trí cần hiển thị: ");
		in.nextLine();
		String viTri = in.nextLine();
		int index = indexOfVitri(viTri);
		if (index == -1) {
			System.out.println("Vi tri nay khong co trong danh sach cau thu");
			return;
		}
		for (int i = index; i < list.size(); i++) {
			if (list.get(i).getViTri().compareTo(viTri) == 0) {
				System.out.println(list.get(i).toString());
			}
		}
	}

	public static int indexOfVitri(String s) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getViTri().compareTo(s) == 0) {
				return i;
			}
		}
		return -1;
	}

	public static void displayPlayerByCode() {
		System.out.print("\tNhập mã cầu thủ cần hiển thị: ");
		int code = in.nextInt();
		int index = indexOfPlayerList(code);
		if (index == -1) {
			System.out.println("Cầu thủ này không có trong đội");
			return;
		}
		System.out.println(list.get(index).toString());
	}
}
