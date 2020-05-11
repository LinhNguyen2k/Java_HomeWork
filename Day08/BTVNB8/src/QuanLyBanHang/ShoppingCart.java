package QuanLyBanHang;

import java.util.ArrayList;

public class ShoppingCart {
	private int ID;
	private int cusID;
	private ArrayList<CartProduct> product = new ArrayList<CartProduct>();
	public ShoppingCart() {
		super();
	}
	public ShoppingCart(int iD, int cusID, ArrayList<CartProduct> product) {
		super();
		ID = iD;
		this.cusID = cusID;
		this.product = product;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getCusID() {
		return cusID;
	}
	public void setCusID(int cusID) {
		this.cusID = cusID;
	}
	public ArrayList<CartProduct> getProduct() {
		return product;
	}
	public void setProduct(CartProduct cartProduct) {
		this.product.add(cartProduct);
	}
	//Dinh nghia them cac phuong thuc cho viec cai tien chuc nang them hang vao gio
	//Phuong thuc tra ve index cua mot hang hoa trong danh sach product theo ID
	public int indexOfCartProduct(int ID) {
		for (int i=0; i<product.size(); i++)
			if (product.get(i).getProductID() == ID)
				return i;
		return -1;
	}
	//Phuong thuc lay ra mot hang hoa trong gio hang
	public CartProduct getOneProduct(int index) {
		return product.get(index);
	}
	//Phuong thuc set lai thong tin cho mot hang hoa trong gio hang
	public void setOneProduct(int index, CartProduct newCartProduct) {
		product.set(index, newCartProduct);
	}
	//Phuong thuc de xoa mot hang hoa trong gio theo index
	public void removeOneProduct(int index) {
		product.remove(index);
	}
}
