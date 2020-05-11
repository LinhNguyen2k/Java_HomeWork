package QuanLyBanHang;

public class Products {
	int ProductTypeID;
	int ID;
	String name;
	int amount;
	double price;
	
	public Products() {
		super();
	}
	public Products(int productTypeID, int iD, String name, int amount, double price) {
		super();
		ProductTypeID = productTypeID;
		ID = iD;
		this.name = name;
		this.amount = amount;
		this.price = price;
	}
	public int getProductTypeID() {
		return ProductTypeID;
	}
	public void setProductTypeID(int productTypeID) {
		ProductTypeID = productTypeID;
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Products [ProductTypeID=" + ProductTypeID + ", ID=" + ID + ", name=" + name + ", amount=" + amount
				+ ", price=" + price + "]";
	}
	
}