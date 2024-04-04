package rpgGame;

abstract public class Monster {
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
	
	public void init(int maxHp, int power) {
		this.hp = maxHp;
		this.maxHp = maxHp;
		this.power = power;
	}
	
	public void init(String name, int maxHp, int power) {
	    this.name = name;
	    this.hp = maxHp;
	    this.maxHp = maxHp;
	    this.power = power;
	}
	
	// attack
	public void attack(Unit target) {
		target.setHp(this.power - target.getDefense());
		System.out.printf("[%s](이)가 [%s]에게 %d의 데미지를 입힌다.\n", name, target.getName(), this.power - target.getDefense());
		
		if(target.getHp() <= 0) {
			System.out.printf("[%s](를)을 처치했습니다.\n", target.getName());
			target.setHp(0);
		}
	}
	
	// printData
	public void printData() {
		System.out.printf("[%s][HP:%d/%d][공격력:%d]\n", name, hp, maxHp, power);
	}
}
