package rpgGame;

import java.util.ArrayList;

public class StageBattle extends Stage {
	private final int ATTACK = 1;
	private final int SKILL = 2;
	
	private UnitManager unitManager;
	private ArrayList<Monster> monList;
	
	private int monDead;
	private int playerDead;
	
	private boolean isRun = true;
	private boolean isTurn = true;
	
	public StageBattle() {
		unitManager = UnitManager.getInstance();
		monDead = 0;
		playerDead = 0;
		monList = null;
	}
	
	@Override
	public boolean update() {
		int playerIdx = 0;
		int monIdx = 0;
		
		while(isRun) {
			if(isTurn) {
				printUnit();
				if(playerIdx < Player.getGuildSize()) {
					playerAttack(playerIdx);
					playerIdx ++;
				}
				else {
					isTurn = !isTurn;
					playerIdx = 0;
				}
			}
			else if(!isTurn) {
				if(monIdx < monList.size()) {
					monAttack(monIdx);
					monIdx ++;
				}
				else {
					isTurn = !isTurn;
					monIdx = 0;
				}
			}
			
			checkLive();
			if(playerDead <= 0) {
				System.out.println("😞STAGE FAIL😞");
				break;
			}
			
			if(monDead <= 0) {
				System.out.println("🎉STAGE CLEAR🎉");
				break;
			}
		}
		GameManager.nextStage = "🏰스톰빌 성 로비🏰";
		return false;
	}

	@Override
	public void init() {
		unitManager.monsterList.clear();
		unitManager.ranMonster(4);
		
		unitManager.player = null;
		unitManager.player = new Player();
		
		monList = null;
		monList = unitManager.monsterList;
		
		monDead = monList.size();
		playerDead = Player.getGuildSize();
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
			while(true) {
				int index = GameManager.ran.nextInt(monList.size());
				if(monList.get(index).getHp() > 0) {
					play.skill(monList.get(index));
					break;
				}
			}
		}
	}
	
	// monAttack
	private void monAttack(int idx) {
		Monster mon = monList.get(idx);
		
		if(mon.getHp() <= 0) {
			return;
		}
		
		while(true) {
			int index = GameManager.ran.nextInt(Player.getGuildSize());
			if(Player.getGuildUnit(index).getHp() > 0) {
				mon.attack(Player.getGuildUnit(index));
				break;
			}
		}
	}
	
	// checkLive
	private void checkLive() {
		int num = 0;
		for(int i = 0; i < Player.getGuildSize(); i ++) {
			if(Player.getGuildUnit(i).getHp() <= 0) {
				num ++;
			}
		}
		playerDead = Player.getGuildSize() - num;
		
		num = 0;
		for(int i = 0; i < monList.size(); i ++) {
			if(monList.get(i).getHp() <= 0) {
				num ++;
			}
		}
		monDead = monList.size() - num;
	}
}
