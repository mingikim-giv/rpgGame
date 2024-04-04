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
}
