package hwjava05_광주_3반_김수혁;

public class Product {
	private int id;
	private String name;
	private int price;
	private int cnt;
	public Product() {}
	public Product(int id, String name, int price, int cnt) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "[ 상품번호 = " + id + "\t 상품이름 = " + name + "\t 상품가격 = " + price + "\t 상품수량 = " + cnt + " ]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
