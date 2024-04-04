package rpgGame;

import java.util.ArrayList;

public class Inventory {
	private final int WEAR = 1;
	private final int SALE = 2;
	private final int EXIT = 3;
	
	private ArrayList<Item> itemList;
	
	public Inventory() {
		itemList = new ArrayList<>();
	}
	
	// inventoryMenu
	public void inventoryMenu() {
		while(true) {
			System.out.println("─────[인벤토리 메뉴]─────");
			System.out.println("① 아이템 착용");
			System.out.println("② 아이템 판매");
			System.out.println("③ 뒤로 가기");
			int sel = inputNumber("메뉴 선택");
			
			if(sel == WEAR) {
				wear();
			}
			else if(sel == SALE) {
				
			}
			else if(sel == EXIT) {
				break;
			}
		}
	}
	// printItemList
	private void printItemList() {
		System.out.println("─────[아이템 리스트]─────");
		for(int i = 0; i < itemList.size(); i ++) {
			System.out.printf("[%d번]", i+1);
			System.out.printf("[이름:%s]", itemList.get(i).getName());
			System.out.printf("[능력:%d]", itemList.get(i).getPower());
			System.out.printf("[가격:%d]", itemList.get(i).getPrice());
			System.out.println();
		}
	}
	// wear
	private void wear() {
		Player.guild.printAllStatus();
		System.out.println("아이템 착용할 길드원을 선택하세요.");
		int sel = inputNumber("번호 선택")-1;
		while(true) {
			Player.guild.unitStatus(sel);
			Player.guild.unitItem(sel);
			printItemList();
		}
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
