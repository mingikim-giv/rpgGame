package rpgGame;

public class Monster {
	private int hp;
	private int maxHp;
	private int power;
	private String name;
	
	public Monster() {}
	
	public Monster(String name, int maxHp, int pw) {
	    this.name = name;
	    this.hp = maxHp;
	    this.maxHp = maxHp;
	    this.power = pw;
	}
	
	public int getHp() {
		return this.hp;
	}
	public int getMaxHp() {
		return this.maxHp;
	}
	public int getPower() {
		return this.power;
	}
	public String getName() {
		return this.name;
	}
	
	public void setHp(int hp) { 
		this.hp = hp;
	}
	public void setName(String name) {
		this.name = name;
	}
}
