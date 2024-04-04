package rpgGame;

abstract public class Unit {
	private String name;	// 이름
	private int level;		// 레벨
	private int hp;			// 체력
	private int maxHp;		// 최대 체력
	private int power;		// 공격력
	private int defense;	// 방어력
	private int exp;		// 경험치
	private boolean party;	// 파티 가입 여부
	private Item weapon;	// 무기
	private Item armor;		// 갑옷
	private Item ring;		// 장신구
	
	public Unit() {}
	
	public Unit(String name, int lv, int hp, int pw, int df, int exp) {
		this.name = name;
		this.level = lv;
		this.maxHp = hp;
		this.hp = hp;
		this.power = pw;
		this.defense = df;
		this.exp = exp;
		party = false;
		weapon = null;
		armor = null;
		ring = null;
	}
	
	// overloading
	public Unit(String name, int lv, int hp, int pw, int df, int exp, boolean party) {
		super();
		this.name = name;
		this.level = lv;
		this.maxHp = hp;
		this.hp = hp;
		this.power = pw;
		this.defense = df;
		this.exp = exp;
		this.party = party;
		weapon = null;
		armor = null;
		ring = null;
	}
	
	// setItem
	public void setItem(Item weapon, Item armor, Item ring) {
		this.weapon = weapon;
		this.armor = armor;
		this.ring = ring;
	}
	
	// status
	public void printStatus() {
		System.out.printf("[이름:%s]", name);
		System.out.printf("[레벨:%d]", level);
		
		// HP: hp + ring
		if(ring != null) {
			System.out.printf("[HP:%d+%d/%d+%d]", hp, ring, maxHp, ring);
		}
		else {
			System.out.printf("[HP:%d/%d]", hp, maxHp);
		}
		// power: power + weapon
		if(weapon != null) {
			System.out.printf("[공격력:%d+%d]", power, weapon);
		}
		else {
			System.out.printf("[공격력:%d]", power);
		}
		// defense: defense + armor
		if(armor != null) {
			System.out.printf("[방어력:%d+%d]", defense, armor);
		}
		else {
			System.out.printf("[방어력:%d]", defense);
		}
		System.out.printf("[파티중:%s]\n", party);
	}
	
	// getItem
	public void printGetItem() {
		if(weapon == null) {
			System.out.println("[무기:❌]");
		}
		else {
			System.out.printf("[무기:%s]\n", weapon);
		}
		if(armor == null) {
			System.out.println("[방어구:❌]");
		}
		else {
			System.out.printf("[방어구:%s]\n", armor);
		}
		if(ring == null) {
			System.out.println("[장신구:❌]");
		}
		else {
			System.out.printf("[장신구:%s]\n", ring);
		}
	}
	
	// attack
	public void attack(Monster target) {
		target.setHp(target.getHp() - power);
		System.out.printf("[%s](이)가 [%s]에게 %d의 데미지를 입힌다.\n", name, target.getName(), power);
		
		if(target.getHp() <= 0) {
			System.out.printf("[%s](를)을 처치했습니다.\n", target.getName());
			target.setHp(0);
		}
	}
}
