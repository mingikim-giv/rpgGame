package rpgGame;

public class Player extends Unit {
	public static int money;	// 소지금
	public static Guild guild;
	public static Inventory inven;
	
	public Player() {
		guild = new Guild();
		inven = new Inventory();
	}
	
	public void init() {
		money = 100000;		// 소지금
		guild.setGuild();	// 길드 설정
	}
	
	public Player(String name, int lv, int maxHp, int pw, int df) {
		super(name, lv, maxHp, pw, df);
	}
	public Player(String name, int lv, int maxHp, int pw, int df, boolean party) {
		super(name, lv, maxHp, pw, df, false);
	}
	
	public void skill() {
		
	}
	
	public void guildMenu() {
		guild.guildMenu();
	}
}
