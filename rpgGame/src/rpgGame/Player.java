package rpgGame;

import java.util.ArrayList;

public class Player extends Unit {
	public static int money;	// 소지금
	public static Guild guild = new Guild();
	public static Inventory inven = new Inventory();
	
	public Player() {init();}
	
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
	
	public void skill(Monster target) {
		if(this.getName().equals("기사")) {
			warriorSkill(target);
		}
		else if(this.getName().equals("마법사")) {
			wizardSkill(target);
		}
		else if(this.getName().equals("밀사")) {
			confessorSkill(target);
		}
	}
	
	// warriorSkill
	private void warriorSkill(Monster target) {
		System.out.println("사자 베기🔪🩸");
		target.setHp(target.getHp() - this.getPower() * 2);
		System.out.printf("[%s](이)가 [%s]에게 %d의 데미지를 입힌다.\n", this.getName(), target.getName(), (this.getPower() * 2));
		
		if(target.getHp() <= 0) {
			target.setHp(0);
			System.out.printf("[%s](을)를 처치했습니다.\n", target.getName());
		}
	} 
	
	// wizardSkill
	private void wizardSkill(Monster target) {
		System.out.println("냉기 안개🧊");
		ArrayList<Monster> mon = UnitManager.getInstance().getMonster();
		System.out.printf("[%s](이)가 몬스터 전체에게 %d의 데미지를 입힌다.\n", this.getName(), (this.getPower() / 2));
		for(int i = 0; i < mon.size(); i ++) {
			Monster monster = mon.get(i);
			monster.setHp(monster.getHp() - this.getPower() / 2);
			
			if(monster.getHp() <= 0) {
				monster.setHp(0);
				System.out.printf("[%s](을)를 처치했습니다.\n", monster.getName());
			}
		}
	}
	
	// confessorSkill
	private void confessorSkill(Monster target) {
		System.out.println("황금 나무의 은총✝️");
		target.setHp(target.getHp() - this.getPower());
		System.out.printf("[%s](이)가 [%s]에게 %d의 데미지를 입힌다.\n", this.getName(), target.getName(), this.getPower());
		
		if(target.getHp() <= 0) {
			target.setHp(0);
			System.out.printf("[%s](을)를 처치했습니다.\n", target.getName());
		}
		
		int stun = GameManager.ran.nextInt(10)+1;
		if(stun > 5) {
			System.out.printf("%s님의 스턴명중! %s💤\n", this.getName(), target.getName());
			target.setStun(true);
		}
		else {
			System.out.println("스킬 빗나감😞");
		}
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
