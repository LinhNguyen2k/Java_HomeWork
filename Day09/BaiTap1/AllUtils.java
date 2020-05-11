package BaiTap1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
public class AllUtils {
	private static ArrayList<Users> list = new ArrayList<Users>();
	private static int autocode = 1;
	static Scanner in = new Scanner(System.in);

	public static void menu() {
		int chon;
		int index=0;
		System.out.println("1.Đăng nhập:");
		System.out.println("2.Đăng ký:");
		System.out.println("3.Thoát ");
		do {
			System.out.println("Bạn chọn (1/2/3)?:");
			chon = in.nextInt();
			switch (chon) {
			case 1:
                logIn();
                display(index);
				break;
			case 2:
				try {
					addUser();
				} catch (UsersNameException e) {
					System.out.println(e.getMessage());
				} catch (PasswordException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				return;
			default:
				System.out.println("Không hợp lệ");
			}
		} while (true);
	}

	public static void main(String[] args) {
		list.add(new Users(1, "NguyenAnhLinh1", "NguyenAnhLinh123!@#", "NguyenAnhLinh", 27, 9, 2000, "0815619200"));
		menu();
	}

	public static void logIn() {
		int index = 0;
		int ktra1 = 0;
		int ktra2 = 0;
		String password;
		String usrename;
		System.out.println("\tEnter name:");
		in.nextLine();
		usrename = in.nextLine();
		for (int i = 0; i < list.size(); i++) {
			if (usrename.equals(list.get(i).getUsersName()))
				ktra1 = 1;
			break;
		}
		if (ktra1 == 0) {
			System.out.println("Tài khoản không tồn tại");
		} else {
			
			System.out.println("Nhập mật khẩu");
			password = in.nextLine();
			for (int i = 0; i < list.size(); i++) {
				if (usrename.equals(list.get(i).getUsersName()) && password.equals(list.get(i).getPassword()))
					ktra2 = 1;
				index = i;
				break;
			}
			if (ktra2 == 1) {
				System.out.println("Đăng nhập thành công");
			} else {
				System.out.println("Sai mật khẩu");
				return;
			}
			System.out.println("\tDanh sách bạn vừa nhập");
			display(index);
		}
		int luachon;
		System.out.println("\tBạn chọn sửa gì:");
		System.out.println("\t1. sửa mật khẩu");
		System.out.println("\t2. sửa tên");
		System.out.println("\t3. sửa số điện thoại");
		System.out.println("\t4. sửa ngày tháng năm sinh ");
		System.out.println("\t5. thoát");
		luachon = in.nextInt();
		switch (luachon) {
		case 1:
			setPassword(index);
			break;
		case 2:
			setName(index);
			break;
		case 3:setMobile(index);
			break;
		case 4:setDayMonthYears(index);
			break;
		case 5:
			return;
		}

	}

	public static void setPassword(int index) {
		String newPassword;
		System.out.println("\tEnter newPassword");
		newPassword = in.nextLine();
		int check = 0;
		for (int i = 0; i < newPassword.length(); i++) {
			char let = newPassword.charAt(i);
			if (isDigit(newPassword.charAt(i))) {
				check = 1;
				break;
			}
		}
		if (check == 0)
			System.out.println("Mật khẩu phải có chữ số");
		check = 0;
		for (int i = 0; i < newPassword.length(); i++) {
			char let = newPassword.charAt(i);
			if (isUpper(newPassword.charAt(i))) {
				check = 1;
				break;
			}
		}
		if (check == 0)
			System.out.println("Mật khẩu phải có chữ in hoa");
		check = 0;
		for (int i = 0; i < newPassword.length(); i++) {
			char let = newPassword.charAt(i);
			if (isSpecial(newPassword.charAt(i))) {
				check = 1;
				break;
			}
		}
		if (check == 0) {
			System.out.println("Mk phải có ký tự đặc biệt");
		}
		list.get(index).setPassword(newPassword);
	}

	public static void setName(int index) {
		String newName = "";
		System.out.println("\tHọ tên");
		newName = in.nextLine();
		if (newName.length() < 0) {
			System.out.println("\tHọ và tên không được để trống");
			return;
		} else {
			for (int i = 0; i < newName.length(); i++) {
				char let = newName.charAt(i);
				if (!isLower(let) && !isUpper(let)) {
					System.out.println("\tHọ tên không hợp lệ");
				}
			}
		}
		list.get(index).setDisplayname(newName);
	}

	public static void setMobile(int index) {
		String newmobile = "";
		System.out.println("\tnhập số điện thoại:");
		newmobile = in.nextLine();
		if (newmobile.charAt(0) != '0' || newmobile.length() != 10) {
			System.out.println("\tSố điện thoại không hợp lệ");
			return;
		} else {
			for (int i = 0; i < newmobile.length(); i++) {
				char let = newmobile.charAt(i);
				if (!isLower(let) && !isUpper(let)) {
					System.out.println("\tSố điện thoại không hợp lệ");
				}
			}
		}

	}

	public static void setDayMonthYears(int index) {
		System.out.println("\tNăm Sinh:");
		String strNum = in.nextLine();
		if (!isIntegerNumber(strNum)) {
			System.out.println("\tNăm sinh phải là số nguyên");
			return;
		}
		in.nextLine();
		int newYear = Integer.parseInt(strNum);
		Calendar cal = Calendar.getInstance();
		int y = cal.get(Calendar.YEAR);
		if (newYear < 0 || newYear > y) {
			System.out.println("\tNăm sinh lớn hơn không và nhỏ hơn " + y + 1);
			return;
		}
		System.out.println("\tTháng Sinh");
		int newmonth = Integer.parseInt(strNum);
		if (newmonth < 1 || newmonth > 12) {
			System.out.println("\tTháng không hợp lệ(1->12)");
			return;
		}

		System.out.println("\tNgày sinh");
		strNum = in.nextLine();
		if (!isIntegerNumber(strNum)) {
			System.out.println("\tNgày phải là số nguyên");
			return;
		}
		int newDay = Integer.parseInt(strNum);
		switch (newmonth) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (newDay < 1 || newDay > 31) {
				System.out.println("\tNgày sinh không hợp lệ");
				return;
			}
		case 4:
		case 6:
		case 9:
		case 11:
			if (newDay < 1 || newDay > 30) {
				System.out.println("Ngày sinh không hợp lệ");
				return;
			}
		case 2:
			if (newYear % 4 == 0)
				if (newDay < 1 || newDay > 29) {
					System.out.println("Ngày sinh không hợp lệ");
					return;
				} else {
					if (newDay < 1 || newDay > 28) {
						System.out.println("Ngày sinh không hợp lệ");
						return;
					}
				}
		}
		list.get(index).setDay(newDay);
		list.get(index).setMonth(newmonth);
		list.get(index).setYear(newYear);

	}

	public static void addUser() throws UsersNameException, PasswordException {
		String usrename = "";
		System.out.println("\tUser name:");
		in.nextLine();
		usrename = in.nextLine();
		if (usrename.length() < 8) {
			throw new UsersNameException("\tTên không dưới 8 kí tự");
		} else {
			for (int i = 0; i < usrename.length(); i++) {
				char let = usrename.charAt(i);
				if (!isLower(let) && !isUpper(let) && !isDigit(let)) {
					throw new UsersNameException("\tTên tài khoản không hợp lệ");
				}
			}
		}
		String password = " ";
		System.out.println("\tPassword:");
		password = in.nextLine();
		if (password.length() < 6) {
			throw new PasswordException("\tMK duoi 6 ky tu");
		} else {
			int check = 0;
			for (int i = 0; i < password.length(); i++) {
				char let = password.charAt(i);
				if (isLower(password.charAt(i))) {
					check = 1;
					break;
				}
			}
			if (check == 0)
				throw new PasswordException("\tMK phai co chu thuong");
		}
		int check = 0;
		for (int i = 0; i < password.length(); i++) {
			char let = password.charAt(i);
			if (isDigit(password.charAt(i))) {
				check = 1;
				break;
			}
		}
		if (check == 0)
			throw new PasswordException("\tMK phải có chữ số");
		check = 0;
		for (int i = 0; i < password.length(); i++) {
			char let = password.charAt(i);
			if (isUpper(password.charAt(i))) {
				check = 1;
				break;
			}
		}
		if (check == 0)
			throw new PasswordException("\tMK phải có chữ in hoa");
		check = 0;
		for (int i = 0; i < password.length(); i++) {
			char let = password.charAt(i);
			if (isSpecial(password.charAt(i))) {
				check = 1;
				break;
			}
		}
		if (check == 0) {
			throw new PasswordException("\tMK phải có ký tự đặc biệt");
		}
		// DisplayName
		String displayName = "";
		System.out.println("\tHọ tên");
		displayName = in.nextLine();
		if (displayName.length() < 0) {
			System.out.println("\tHọ và tên không được để trống");
			return;
		} else {
			for (int i = 0; i < displayName.length(); i++) {
				char let = displayName.charAt(i);
				if (!isLower(let) && !isUpper(let)) {
					System.out.println("\tHọ tên không hợp lệ");
				}
			}
			int day;
			System.out.println("\tNăm Sinh:");
			String strNum = in.nextLine();
			if (!isIntegerNumber(strNum)) {
				System.out.println("Năm sinh phải là số nguyên");
				return;
			}
			int year = Integer.parseInt(strNum);
			Calendar cal = Calendar.getInstance();
			int y = cal.get(Calendar.YEAR);
			if (year < 0 || year > y) {
				System.out.println("Nam sinh phai lon hon 0 va nho hon " + y + 1);
				return;
			}
			System.out.println("\tTháng Sinh");
			strNum = in.nextLine();
			int month = Integer.parseInt(strNum);
			if (month < 1 || month > 12) {
				System.out.println("\tTháng không hợp lệ(1->12)");
				return;
			}
       
			System.out.println("\tngay sinh");
			strNum = in.nextLine();
			if (!isIntegerNumber(strNum)) {
				System.out.println("Ngày phải là số nguyên");
				return;
			}
			day = Integer.parseInt(strNum);
			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if (day < 1 || day > 31) {
					System.out.println("Ngày sinh không hợp lệ");
					return;
				}
			case 4:
			case 6:
			case 9:
			case 11:
				if (day < 1 || day > 30) {
					System.out.println("Ngày sinh không hợp lệ");
					return;
				}
			case 2:
				if (year % 4 == 0)
					if (day < 1 || day > 29) {
						System.out.println("Ngày sinh không hợp lệ");
						return;
					} else {
						if (day < 1 || day > 28) {
							System.out.println("Ngày sinh không hợp lệ");
							return;
						}
					}
				 
			}
			// xu ly sdt
			String mobile = "";
			System.out.println("\tnhập số điện thoại:");
			mobile = in.nextLine();
			if (mobile.charAt(0) != '0' || mobile.length() < 0 && mobile.length() > 10) {
				System.out.println("\tSố điện thoại không hợp lệ");
				return;
			} else {
				for (int i = 0; i < mobile.length(); i++) {
					char let = mobile.charAt(i);
					if (!isLower(let) && !isUpper(let)) {
						System.out.println("\tSố điện thoại không hợp lệ");
					}
				}
				Users user = new Users(autocode, usrename, password, displayName, day, month, year, mobile);
				list.add(user);
				autocode++;
			}
		}
	}

	public static boolean isIntegerNumber(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!isDigit(s.charAt(i)))
				return false;
		}
		return true;
	}

	public static void display(int i) {
		System.out.println(list.get(i).toString());
	}

	public static boolean isLower(char let) {
		return let >= 'a' && let <= 'z';
	}

	public static boolean isDigit(char let) {
		return let >= '0' && let <= '9';
	}

	public static boolean isUpper(char let) {
		return let >= 'A' && let <= 'Z';
	}

	public static boolean isSpecial(char let) {
		String s = "~!@#$%^&*";
		return s.indexOf(let) != -1;
	}

}
