package rpgGame;

public class Item {
	private static final int WEAPON = 1;
	private static final int ARMOR = 2;
	private static final int RING = 3;
	
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
}
