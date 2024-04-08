package rpgGame;

import java.util.ArrayList;

public class Guild {
	private final int LIST = 1;
	private final int ADD = 2;
	private final int DELETE = 3;
	private final int CHANGE = 4;
	private final int LINE_UP = 5;
	private final int EXIT = 6;
	
	private final int PARTY_SIZE = 3;
	public ArrayList<Player> guildList;
	public Unit[] partyList;
	
	public Guild() {
		guildList = new ArrayList<>();
	}
	
	// setGuild
	public void setGuild() {
		if(guildList.size() > 0)
			return;
		
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
		System.out.println("┌──────────────────────────────┐");
		System.out.printf("[골드: %d원]\n", Player.money);
		System.out.println("─────────────[길드원]─────────────");
		for(int i = 0; i < guildList.size(); i ++) {
			Player player = guildList.get(i);
			System.out.printf("[%d번]", i+1);
			System.out.printf("[이름:%s]", player.getName());
			System.out.printf("[레벨:%d]", player.getLevel());
			System.out.printf("[HP:%d/%d]\n", player.getHp(), player.getMaxHp());
			System.out.printf("[공격력:%d]", player.getPower());
			System.out.printf("[방어력:%d]", player.getDefense());
			System.out.printf("[파티중:%s]\n", player.getParty());
			System.out.println();
		}
		System.out.println("└──────────────────────────────┘");
	}
	
	// unitStatus
	public void unitStatus(int unit) {
		guildList.get(unit).printStatus();
	}
	
	// unitItem
	public void unitItem(int unit) {
		guildList.get(unit).printGetItem();
	}
	
	// guildMenu
	public void guildMenu() {
		while(true) {
			System.out.println("────────────[길드 관리]────────────");
			System.out.println("① 길드 목록");
			System.out.println("② 길드원 추가");
			System.out.println("③ 길드원 삭제");
			System.out.println("④ 파티원 교체");
			System.out.println("⑤ 정렬");
			System.out.println("⑥ 뒤로 가기");
			int sel = inputNumber("메뉴 선택");
			
			if(sel == LIST) {
				printAllStatus();
			}
			else if(sel == ADD) {
				buyUnit();
			}
			else if(sel == DELETE) {
				removeUnit();
			}
			else if(sel == CHANGE) {
				partyChange();
			}
			else if(sel == LINE_UP) {
				unitSort();
			}
			else if(sel == EXIT) {
				break;
			}
		}
	}
	
	// buyUnit
	private void buyUnit() {
		if(Player.money < 5000) {
			System.err.println("금액이 부족합니다.");
			return;
		}
		String[] num1 = {"예", "용", "귀", "주"};
		String[] num2 = {"언", "기", "검", "술"};
		String[] num3 = {"자", "사", "사", "사"};
		
		// ranName
		String name = num1[GameManager.ran.nextInt(num1.length)];
		name += num2[GameManager.ran.nextInt(num2.length)];
		name += num3[GameManager.ran.nextInt(num3.length)];
		
		// ranStatus
		int r = GameManager.ran.nextInt(50);
		int hp = r * 20;
		int power = r + 5;
		int defense = r / 2;
		
		// playAdd
		Player temp = new Player(name, 3, hp, power, defense);
		System.out.println("┌──────────────────────────────┐");
		System.out.printf("[이름:%s]", name);
		System.out.printf("[레벨:%d]", 3);
		System.out.printf("[HP:%d/%d]\n", hp, hp);
		System.out.printf("[공격력:%d]", power);
		System.out.printf("[방어력:%d]\n", defense);
		System.out.println("길드원을 추가합니다.");
		System.out.println("└──────────────────────────────┘");
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		guildList.add(temp);
		Player.money -= 5000;
	}
	
	// removeUnit
	private void removeUnit() {
		printAllStatus();
		int num = inputNumber("삭제할 번호")-1;
		
		if(guildList.get(num).getParty()) {
			System.err.println("파티 중인 멤버는 삭제할 수 없습니다.");
		}
		else {
			System.out.println("┌──────────────────────────────┐");
			System.out.printf("[이름:%s]\n", guildList.get(num).getName());
			System.out.println("길드원을 삭제합니다.");
			System.out.println("└──────────────────────────────┘");
			guildList.remove(num);
		}
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// printParty
	private void printParty() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("─────────────[파티원]─────────────");
		for(int i = 0; i < PARTY_SIZE; i ++) {
			System.out.printf("[%d번]", i+1);
			System.out.printf("[이름:%s]", partyList[i].getName());
			System.out.printf("[레벨:%d]", partyList[i].getLevel());
			System.out.printf("[HP:%d/%d]\n", partyList[i].getHp(), partyList[i].getMaxHp());
			System.out.printf("[공격력:%d]", partyList[i].getPower());
			System.out.printf("[방어력:%d]", partyList[i].getDefense());
			System.out.printf("[파티중:%s]\n", guildList.get(i).getParty());
			System.out.println();
		}
		System.out.println("└──────────────────────────────┘");
	}
	
 	// partyChange
	private void partyChange() {
		printParty();
		int partyNum = inputNumber("교체할 번호")-1;
		
		printAllStatus();
		int guildNum = inputNumber("참가할 번호")-1;
		
		partyList[partyNum].setParty(false);
		guildList.get(guildNum).setParty(true);
		
		System.out.println("┌──────────────────────────────┐");
		System.out.printf("[이름:%s] ➡️ [이름:%s]\n", partyList[partyNum].getName(), guildList.get(guildNum).getName());
		System.out.println("└──────────────────────────────┘");
		// 파티 재정의
		int n = 0;
		for(int i = 0; i < guildList.size(); i ++) {
			if(guildList.get(i).getParty()) {
				partyList[n] = guildList.get(i);
				n ++;
			}	
		}
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// unitSort
	private void unitSort() {
		for(int i = 0; i < guildList.size(); i ++) {
			Player temp = guildList.get(i);
			int idx = i;
			for(int j = i; j < guildList.size(); j ++) {
				if(temp.getLevel() < guildList.get(j).getLevel()) {
					temp = guildList.get(j);
					idx = j;
				}
			}
			Player temp2 = guildList.get(idx);
			guildList.set(idx, guildList.get(i));
			guildList.set(i, temp2);
		}
		printAllStatus();
	}
	
	// inputNumber
	private int inputNumber(String message) {
		int number = - 1;
		
		try {
			System.out.println(message + ":");
			String input = GameManager.scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("숫자를 입력하세요.");
		}
		return number;
	}
	
}
