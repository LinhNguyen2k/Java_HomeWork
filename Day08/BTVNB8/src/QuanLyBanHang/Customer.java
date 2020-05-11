package QuanLyBanHang;

public class Customer {
	private int ID;
	private String name;
	public Customer() {
		super();
	}
	public Customer(int iD, String name) {
		super();
		ID = iD;
		this.name = name;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Customers [ID=" + ID + ", name=" + name + "]";
	}
	
}
