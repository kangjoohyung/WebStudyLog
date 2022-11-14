package ex1006.el;

public class Product {
	private String code="A01";
	private String name="새우깡";
	private int price=3500;
	private int qty=5;
	
	public Product() {
		System.out.println("Product 생성자");
	}
	
	public String getCode() {
		System.out.println("getCode() 호출");
		return code;
	}
	public String getName() {
		System.out.println("getName() 호출");
		return name;
	}
	public int getPrice() {
		System.out.println("getPrice() 호출");
		return price;
	}
	public int getQty() {
		System.out.println("getQty() 호출");
		return qty;
	}
	
	
}
