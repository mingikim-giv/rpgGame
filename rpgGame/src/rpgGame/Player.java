package rpgGame;

import java.util.ArrayList;

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
	
	// guildMenu
	public void guildMenu() {
		guild.guildMenu();
	}
	
	// inventoryMenu
	public void inventoryMenu() {
		inven.inventoryMenu();
	}
	
	// 길드 리스트 반환
	public static ArrayList<Player> getGuildList() {
		return guild.guildList;
	}
	
	// 아이템 리스트 반환
	public static ArrayList<Item> getItemList() {
		return inven.itemList;
	}
	
	// 길드원 반환
	public static Player getGuildUnit(int num) {
		return guild.getGuild(num);
	}
	
	// 길드 크기 반환
	public static int getGuildSize() {
		return guild.guildList.size();
	}
	
	// 아이템 크기 반환
	public static int getItemSize() {
		return inven.itemList.size();
	}
}
