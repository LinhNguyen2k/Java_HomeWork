package BaiTap03;

public class Subjects {
	private int code;
	private String name;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	public void display() {
		System.out.printf(" %-8s ",code);
		System.out.printf("%-16s",name);
		System.out.printf("%-19d", credit);
		System.out.printf("%8.2f" , mark);
		System.out.println();
	}
	public Subjects() {
		super();
	}
	public Subjects(int code, String name, int credit, double mark) {
		super();
		this.code = code;
		this.name = name;
		this.credit = credit;
		this.mark = mark;
	}
	private int credit;
	private double mark;

}
