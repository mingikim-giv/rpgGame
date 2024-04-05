package rpgGame;

import java.util.ArrayList;

public class StageBattle extends Stage {
	private UnitManager unitManager;
	private ArrayList<Monster> monList = null;
	
	private int monDead;
	private int playerDead;
	
	private boolean isRun = true;
	private boolean isTurn = true;
	
	public StageBattle() {
		unitManager = UnitManager.getInstance();
		monDead = 0;
		playerDead = 0;
	}
	
	@Override
	public boolean update() {
		int playerIdx = 0;
		int monIdx = 0;
		
		while(isRun) {
			if(isTurn) {
				
			}
		}
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	// printUnit
	private void printUnit() {
		System.out.println("────────[⚔️전투⚔️]────────");
		System.out.printf("%s : %s\n", playerDead, monDead);
		System.out.println("───────[🕹️플레이어🕹️]───────");
		for(int i = 0; i < Player.getGuildSize(); i ++) {
			Player.getGuildUnit(i).printData();
		}
		System.out.println("───────[👾몬스터👾]───────");
		for(int i = 0; i < monList.size(); i ++) {
			monList.get(i).printData();
		}
	}
}
