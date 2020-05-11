package BaiTap1;

public class Users {
	private int code;
	private String usersName;
	private String password;
	private String displayname;
	private int day, month, year;
	private String mobile;

	@Override
	public String toString() {
		return "\ncode=" + code + ", \nusersName=" + usersName + ", \npassword=" + password + ", \ndisplayname="
				+ displayname + ", \nday=" + day + ", \nmonth=" + month + ", \nyear=" + year + ", \nmobile=" + mobile;
	}

	public Users() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Users(int code, String usersName, String password, String displayname, int day, int month, int year,
			String mobile) {
		super();
		this.code = code;
		this.usersName = usersName;
		this.password = password;
		this.displayname = displayname;
		this.day = day;
		this.month = month;
		this.year = year;
		this.mobile = mobile;
	}
}
