package BaiTap03;

import java.util.Arrays;

public class students {
private int code;
private String name;
private String years;
private String nganh;
private Subjects[]Subjects;
public students(int code, String name, String years, String nganh, BaiTap03.Subjects[] subjects) {
	super();
	this.code = code;
	this.name = name;
	this.years = years;
	this.nganh = nganh;
	Subjects = subjects;
}
public students() {
	super();
}
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
@Override
public String toString() {
	return "students [code=" + code + ", name=" + name + ", years=" + years + ", nganh=" + nganh + ", Subjects="
			+ Arrays.toString(Subjects) + "]";
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getYears() {
	return years;
}
public void setYears(String years) {
	this.years = years;
}
public String getNganh() {
	return nganh;
}
public void setNganh(String nganh) {
	this.nganh = nganh;
}
}
