package QuanLyBanHang;

public class ProductType {
	int ID;
	String name;
	
	public ProductType(int iD, String name) {
		super();
		ID = iD;
		this.name = name;
	}

	public ProductType() {
		super();
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
		return "ProductType [ID=" + ID + ", name=" + name + "]";
	}
}
