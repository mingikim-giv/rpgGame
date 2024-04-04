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
	
}
