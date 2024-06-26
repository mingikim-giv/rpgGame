package rpgGame;

public class Item {
	public static final int WEAPON = 1;
	public static final int ARMOR = 2;
	public static final int RING = 3;
	
	private int kind;		// 종류
	private String name;	// 이름
	private int power;		// 능력
	private int price;		// 가격
	
	public void setItem(int kind, String name, int power, int price) {
		this.kind = kind;
		this.name = name;
		this.power = power;
		this.price = price;
	}
	
	public int getKind() {
		return this.kind;
	}
	public int getPower() {
		return this.power;
	}
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
	
	public void setKind(int kind) {
		this.kind = kind;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
