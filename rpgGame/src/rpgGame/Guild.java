package rpgGame;

import java.util.ArrayList;

public class Guild {
	private final int PARTY_SIZE = 3;
	private ArrayList<Player> guildList;
	private Unit[] partyList;
	
	public Guild() {
		guildList = new ArrayList<>();
	}
	
	// setGuild
	public void setGuild() {
		guildList.add(new Player("기사", 7, 500, 30, 50));
		guildList.add(new Player("마법사", 4, 200, 50, 30));
		guildList.add(new Player("밀사", 10, 300, 20, 30));
		// 파티 참여 여부
		for(int i = 0; i < PARTY_SIZE; i ++) {
			guildList.get(i).setParty(true);
		}
		
		partyList = new Unit[PARTY_SIZE];
		// 파티 참가 유무
		int n = 0;
		for(int i = 0; i < guildList.size(); i ++) {
			Player player = guildList.get(i);
			if(player.getParty() == true) {
				partyList[n] = player;
				n ++;
			}
		}
	}
	
	// getGuild
	public Player getGuild(int num) {
		return guildList.get(num);
	}
	
	// printAllStatus
	public void printAllStatus() { 
		System.out.println("┌──────────────┐");
		System.out.printf("[골드: %d원]\n", Player.money);
		System.out.println("─────[길드원]─────");
		for(int i = 0; i < guildList.size(); i ++) {
			Player player = guildList.get(i);
			System.out.printf("[%d번]\n", i+1);
			System.out.printf("[이름:%s]\n", player.getName());
			System.out.printf("[레벨:%d]\n", player.getLevel());
			System.out.printf("[HP:%d/%d]\n", player.getHp(), player.getMaxHp());
			System.out.printf("[공격력:%d]\n", player.getPower());
			System.out.printf("[방어력:%d]\n", player.getDefense());
			System.out.printf("[파티중:%s]\n", player.getParty());
			System.out.println();
		}
		System.out.println("└──────────────┘");
	}
	
	// unitStatus
	public void unitStatus(int unit) {
		guildList.get(unit).printStatus();
	}
	
	// unitItem
	public void unitItem(int unit) {
		guildList.get(unit).printGetItem();
	}
}
