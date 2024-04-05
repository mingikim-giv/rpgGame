package rpgGame;

import java.util.ArrayList;

public class StageBattle extends Stage {
	private final int ATTACK = 1;
	private final int SKILL = 2;
	
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
				printUnit();
				if(playerIdx < Player.getGuildSize()) {
					
				}
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
	
	// playerAttack
	private void playerAttack(int idx) {
		Player play = Player.getGuildUnit(idx);
		
		if(play.getHp() <= 0) {
			return;
		}
		
		System.out.println("───────[메뉴 선택]───────");
		System.out.printf("[%s]|①공격|②스킬\n", play.getName());
		int sel = GameManager.scan.nextInt();
		if(sel == ATTACK) {
			while(true) {
				int index = GameManager.ran.nextInt(monList.size());
				if(monList.get(index).getHp() > 0) {
					play.attack(monList.get(index));
					break;
				}
			}
		}
		else if(sel == SKILL) {
			
		}
	}
}
