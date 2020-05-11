package BaiTAP2;

public class footballPlayer {
	private int code;
	private String firstName;
	private String name;
	private int age;
	private String gender;
	private String viTri;
	private int salary;
	public footballPlayer() {
		super();
	}
	public footballPlayer(int code, String firstName, String name, int age, String gender, String viTri, int salary) {
		super();
		this.code = code;
		this.firstName = firstName;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.viTri = viTri;
		this.salary = salary;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getViTri() {
		return viTri;
	}
	public void setViTri(String viTri) {
		this.viTri = viTri;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Code: "+code+"\tName: " + firstName + " " + name + "\tAge: " + age + "\tGender: " + gender
				+ "\tviTri: " + viTri + "\t\tSalary = " + salary + "$";
	} 
}
