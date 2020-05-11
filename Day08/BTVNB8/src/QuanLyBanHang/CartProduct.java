package QuanLyBanHang;

public class CartProduct {
	int productID;
	int amount;
	public CartProduct() {
		super();
	}
	public CartProduct(int productID, int amount) {
		super();
		this.productID = productID;
		this.amount = amount;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
