package QuanLyBanHang;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagemenUtils {
	
	static ArrayList<ProductType> ptList = new ArrayList<ProductType>();
	static ArrayList<Products> pList = new ArrayList<Products>();
	static ArrayList<Customer>cList = new ArrayList<Customer>();
	static ShoppingCart shop = new ShoppingCart();
	
	static Scanner in = new Scanner(System.in);
	
	public static void menu() {
		int choose;
		System.out.println("-----CHUONG TRINH QUAN LY BAN HANG-----");
		System.out.println("Chon mot trong cac chuc nang");
		System.out.println("\t1. Quan ly danh sach loai hang");
		System.out.println("\t2. Quan ly danh sach hang hoa");
		System.out.println("\t3. Quan l� khach hang");
		System.out.println("\t4. Quan ly gio hang cua khach");
		System.out.println("\t5. Thoat chuong trinh");
		do {
			System.out.println("Hay chon 1 chuc nang: ");
			choose = in.nextInt();
			
			switch(choose) {
				case 1: productTypeUpdate(); break;
				case 2: productUpdate(); break;
				case 3: CustomerUpdate();break;
				case 4: shoppingCartManage(); break;
				case 5: return;
				default: System.out.println("Khong hop le, chon lai");
			}
		}while (true);
	}
//Phan cap nhat danh sach loai hang	
	public static void productTypeUpdate() {
		int choice;
		System.out.println("Cap nhat danh sach loai hang");
		System.out.println("\t1. Them loai hang");
		System.out.println("\t2. Sua loai hang");
		System.out.println("\t3. Xoa loai hang");
		System.out.println("\t4. Xem danh sach loai hang");
		System.out.println("\t5. Quay lai");
		do {
			System.out.print("Chon 1 chuc nang: ");
			choice = in.nextInt();
			switch (choice) {
				case 1: addProductType(); break;
				case 2: updateProductType(); break;
				case 3: removeProductType(); break;
				case 4: displayListProductType(); break;
				case 5: return;
			}
		}while (true);
	}
	public static int indexOfProductType(int ID) {
		int i=0;
		while (i < ptList.size()) {
			if (ptList.get(i).getID() == ID)
				return i;
			i++;
		}
		return -1;
	}
	public static void addProductType() {
		System.out.println("Nhap thong tin loai hang");
		System.out.print("\tID: ");
		int ID = in.nextInt();
		if (indexOfProductType(ID) != -1) {
			System.out.println("\tMa loai hang da ton tai");
			return;
		}
		System.out.print("\tTen loai hang: ");
		in.nextLine();
		String name = in.nextLine();
		ProductType pt = new ProductType(ID, name);
		ptList.add(pt);
	}
	public static void updateProductType() {
		System.out.println("Sua thong tin loai hang");
		System.out.print("\tNhap ma loai hang can sua: ");
		int ID = in.nextInt();
		int index = indexOfProductType(ID);
		if (index == -1) {
			System.out.println("\tLoai hang khong co trong DS");
			return;
		}
		System.out.print("\tTen loai hang: ");
		in.nextLine();
		String name = in.nextLine();
		ProductType pt = new ProductType(ID, name);
		ptList.set(index, pt);
	}
	public static void removeProductType() {
		System.out.println("\nXoa thong tin loai hang");
		System.out.print("\tNhap ma loai hang can xoa: ");
		int ID = in.nextInt();
		int index = indexOfProductType(ID);
		if (index == -1) {
			System.out.println("\tLoai hang khong co trong DS");
			return;
		}
		ptList.remove(index);
	}
	public static void displayListProductType() {		
		System.out.println("\nDanh sach loai hang");
		for (ProductType pt : ptList) {
			System.out.println("\t" + pt.getID() + "\t" + pt.getName());
		}
	}
	
	//Phan cap nhat danh sach hang hoa	
		public static void productUpdate() {
			int choice;
			System.out.println("\nCap nhat danh sach hang hoa");
			System.out.println("\t1. Them hang hoa");
			System.out.println("\t2. Sua thong tin hang hoa");
			System.out.println("\t3. Xoa hang hoa");
			System.out.println("\t4. Xem danh sach hang hoa");
			System.out.println("\t5. Quay lai");
			do {
				System.out.print("Chon 1 chuc nang: ");
				choice = in.nextInt();
				switch (choice) {
					case 1: addProduct(); break;
					case 2: updateProduct(); break;
					case 3: removeProduct(); break;
					case 4: displayListProduct(); break;
					case 5: return;
				}
			}while (true);
		}
		public static String getIdProductType() {
			String s = "[ ";
			for (ProductType pt : ptList)
				s += pt.getID() + " ";
			s += "]";
			return s;
		}
		public static int indexOfProduct(int ID) {
			int i=0;
			while (i < pList.size()) {
				if (pList.get(i).getID() == ID)
					return i;
				i++;
			}
			return -1;
		}
		public static void addProduct() {
			System.out.println("\nNhap thong tin hang hoa");
			//CHon loai hang cho hang hoa
			String s = getIdProductType();
			System.out.print("\tMa loai hang " + s + ": ");
			int ptID = in.nextInt();
			if (indexOfProductType(ptID) == -1) {
				System.out.println("\tMa loai hang chua co");
				return;
			}			
			System.out.print("\tID: ");
			int ID = in.nextInt();
			if (indexOfProduct(ID) != -1) {
				System.out.println("\tMa hang hoa da ton tai");
				return;
			}
			
			System.out.print("\tTen hang hoa: ");
			in.nextLine();
			String name = in.nextLine();
			System.out.print("\tSo luong hang hoa: ");
			int amount = in.nextInt();
			System.out.print("\tDon gia hang: ");
			double price = in.nextDouble();
			Products p = new Products(ptID, ID, name, amount, price);
			pList.add(p);
		}
		public static void updateProduct() {
			System.out.println("Sua thong tin hang hoa");
			System.out.print("\tNhap ma hang hoa can sua: ");
			int ID = in.nextInt();
			int index = indexOfProduct(ID);
			if (index == -1) {
				System.out.println("\tHang hoa khong co trong DS");
				return;
			}
			String s = getIdProductType();
			System.out.print("\tMa loai hang " + s + ": ");
			int ptID = in.nextInt();
			if (indexOfProductType(ptID) == -1) {
				System.out.println("\tMa loai hang chua co");
				return;
			}			
			System.out.print("\tTen hang hoa: ");
			in.nextLine();
			String name = in.nextLine();
			System.out.print("\tSo luong hang hoa: ");
			int amount = in.nextInt();
			System.out.print("\tDon gia hang: ");
			double price = in.nextDouble();
			Products p = new Products(ptID, ID, name, amount, price);
			pList.set(index, p);
		}
		public static void removeProduct() {
			System.out.println("\nXoa thong tin hang hoa");
			System.out.print("\tNhap ma hang hoa can xoa: ");
			int ID = in.nextInt();
			int index = indexOfProduct(ID);
			if (index == -1) {
				System.out.println("\tHang hoa khong co trong DS");
				return;
			}
			pList.remove(index);
		}
		public static void displayListProduct() {		
			System.out.println("\nDanh sach hang hoa");
			for (Products p : pList) {
				System.out.println("\t" + p.toString());
			}
		}
	//Cap nhat gio hang cua khach mua hang
	public static String getCustomerName(int ID) {
		for (Customer cs : cList) {
			if (cs.getID() == ID)
				return cs.getName();
		}
		return null;
	}
	public static String getProductName(int ID) {
		for (Products p : pList)
			if (p.getID() == ID)
				return p.getName();
		return null;
	}
	public static int getProductAmount(int ID) {
		for (Products p : pList)
			if (p.getID() == ID)
				return p.getAmount();
		return 0;
	}
	public static double getProductPrice(int ID) {
		for (Products p : pList)
			if (p.getID() == ID)
				return p.getPrice();
		return 0;
	}
	public static int indexOfCustomer(int ID) {
		for (int i = 0; i<cList.size(); i++)
			if (cList.get(i).getID() == ID)
				return i;
		return -1;
	}
	public static void shoppingCartManage() { 
		System.out.println("\nQuan ly gio hang cho khach");
		System.out.println("\tTao moi gio hang");
		System.out.print("\t\tNhap ma gio hang: ");
		int ID = in.nextInt();
		String s = getIdCustomer();
		System.out.print("\t\tNhap ma khach hang: " + s + ": " );
		int cusID = in.nextInt();
		if (indexOfCustomer(cusID) == -1) {
			System.out.println("\tKhach hang chua ton tai");
			return;
		}
		shop.setID(ID);
		shop.setCusID(cusID);
		
		System.out.println("Chon chuc nang quan ly gio hang");
		System.out.println("\t1. Them hang vao gio");
		System.out.println("\t2. Xoa hang khoi gio");
		System.out.println("\t3. Xem gio hang");
		System.out.println("\t4. Quay lai");
		int chon;
		
		do {
			System.out.print("Chon 1 chuc nang: ");
			chon = in.nextInt();
			switch (chon) {
				case 1: addProductToCart(); break;
				case 2: deleteProductFromCart(); break;
				case 3: displayShoppingCart(); break;
				case 4: return;
			}
		}while (true);
	}
	//Code lai chuc nang de khi them hang vao gio, neu hang da co thi chi tang them so luong, nhung khong
	//duoc vuot qua so luong cua hang hoa dang ban
	public static void addProductToCart() {
		String s = getIdProduct();
		System.out.print("\tNhap ma hang " + s + ": ");
		int productID = in.nextInt();
		if (indexOfProduct(productID) == -1) {
			System.out.println("\tKhong co hang hoa nay");
			return;
		}
		System.out.print("\tSo luong mua: ");
		int buyAmount = in.nextInt();
		
		//Kiem tra xem hang nay co trong gio chua
		int index = shop.indexOfCartProduct(productID); //Lay index theo ID - Phuong thuc ben lop ShoppingCart
		if (index != - 1) { //Hang them da Co trong gio
			//Lay hang da co nay tu trong gio hang ra de set lai so luong
			CartProduct newCartProduct = shop.getOneProduct(index); //Phuong thuc ben lop ShoppingCart
			//Can kiem tra tong so luong xem co vuot so luong cua hang dang ban khong
			int newAmount = buyAmount + newCartProduct.getAmount();
			if (newAmount > getProductAmount(productID)) {//Neu so luong lon hon so luong hang dang ban
				System.out.print("\tSo luong mua khong duoc nhieu ");
				System.out.println("hon so luong cua hang co la "
									+ getProductAmount(productID));
				return;
				//Khong them duoc, nhung hang trong gio thi van duoc giu nguyen
			}
			else { //So luong moi la ok thi set lai
				newCartProduct.setAmount(newAmount);//set lai soluong moi cho hang mua
				shop.setOneProduct(index, newCartProduct);//set lai hang trong gio - xem phuong thuc ben lop ShoppingCart
			}
		}
		else {//Hang them Chua co trong gio
		
			if (buyAmount > getProductAmount(productID)) {
				System.out.print("\tSo luong mua khong duoc nhieu ");
				System.out.println("hon so luong cua hang co la "
									+ getProductAmount(productID));
				return;
			}
			CartProduct cp = new CartProduct(productID, buyAmount);
			shop.setProduct(cp);
		}
	}
	
	public static void deleteProductFromCart(){
		System.out.println("Xoa hang hoa da chon mua trong gio hang");
		System.out.print("\tNhap ma hang can xoa: ");
		int productId = in.nextInt();
		int index = shop.indexOfCartProduct(productId); //Lay index theo ID
		if (index == -1) {
			System.out.println("\tHang khong co trong gio");
			return;
		}
		shop.removeOneProduct(index);
		System.out.println("\tDa xoa hang trong gio...!");
	}
	
	public static void displayShoppingCart() {
		System.out.println("\nGio hang cua ban");
		System.out.println("\tMa gio hang: " + shop.getID());
		System.out.println("\tTen khach hang: " + 
				getCustomerName(shop.getCusID()));
		System.out.println("\tDanh sach hang hoa");
		ArrayList<CartProduct> list = new ArrayList<CartProduct>();
		list = shop.getProduct();
		double thanhTien = 0, tongTien = 0;
		for (CartProduct cp : list) {
			System.out.print("\t" + getProductName(cp.getProductID()));
			System.out.print("\t" + cp.getAmount());
			System.out.print("\t" + getProductPrice(cp.productID));
			thanhTien = getProductPrice(cp.productID) * cp.getAmount();
			System.out.println("\t" + thanhTien);
			tongTien += thanhTien;
		}
		System.out.println("\t\t\tCong thanh tien: " + tongTien);
	}
	
	public static String getIdCustomer() {
		String s = "[ ";
		for (Customer cs : cList)
			s += cs.getID() + " ";
		s += "]";
		return s;
	}
	public static String getIdProduct() {
		String s = "[ ";
		for (Products p : pList)
			s += p.getID() + " ";
		s += "]";
		return s;
	}
	// Cap nhat danh sach khach hang
		public static void CustomerUpdate() {
			int choice;
			System.out.println("Cap nhat danh sach khach hang");
			System.out.println("\t1. Them khach hang");
			System.out.println("\t2. Sua khach hang");
			System.out.println("\t3. Xoa khach hang");
			System.out.println("\t4. Xem danh sach khach hang");
			System.out.println("\t5. Quay lai");
			do {
				System.out.print("Chon 1 chuc nang: ");
				choice = in.nextInt();
				switch (choice) {
					case 1: addCustomer(); break;
					case 2: updateCustomer(); break;
					case 3: removeCustomer(); break;
					case 4: displayListCustomer(); break;
					case 5: return;
				}
			}while (true);
		}
		public static void addCustomer() {
			System.out.println("Nhap thong tin loai hang");
			System.out.print("\tID: ");
			int ID = in.nextInt();
			if (indexOfCustomer(ID) != -1) {
				System.out.println("\tKhach hang da ton tai");
				return;
			}
			System.out.print("\tTen khach hang: ");
			in.nextLine();
			String name = in.nextLine();
			Customer cus = new Customer(ID,name);
			cList.add(cus);
		}
		public static void updateCustomer() {
			System.out.println("Sua thong tin khach hang");
			System.out.print("\tNhap ID khach hang can sua: ");
			int ID = in.nextInt();
			int index = indexOfCustomer(ID);
			if (index == -1) {
				System.out.println("\tKhach hang khong co trong DS");
				return;
			}
			System.out.print("\tTen khach hang: ");
			in.nextLine();
			String name = in.nextLine();
			Customer cus = new Customer(ID,name);
			cList.set(index, cus);
		}
		public static void removeCustomer() {
			System.out.println("\nXoa thong tin khach hang");
			System.out.print("\tNhap ma khach hang can xoa: ");
			int ID = in.nextInt();
			int index = indexOfCustomer(ID);
			if (index == -1) {
				System.out.println("\tKhach hang khong co trong DS");
				return;
			}
			cList.remove(index);
		}
		public static void displayListCustomer() {		
			System.out.println("\nDanh sach loai hang");
			for (Customer cus : cList) {
				System.out.println("\t" + cus.getID() + "\t" + cus.getName());
			}
		}
	// end cap nhat khach hang
	public static void main(String[] args) {
		cList.add(new Customer(1, "Trang"));
		cList.add(new Customer(2, "Duong"));
		menu();
	}

}
