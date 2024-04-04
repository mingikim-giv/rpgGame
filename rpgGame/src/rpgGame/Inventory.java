package rpgGame;

import java.util.ArrayList;

public class Inventory {
	private final int WEAR = 1;
	private final int SALE = 2;
	private final int EXIT = 3;
	
	public ArrayList<Item> itemList;
	
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
			
			int wear = inputNumber("착용할 아이템 번호 [0.뒤로가기]");
			if(wear == 0) {
				break;
			}
			wear --;
			Item item = itemList.get(wear);
			Player play = Player.getGuildUnit(wear);
			// 입력한 아이템이 무기면
			if(item.getKind() == Item.WEAPON) {
				// 길드원에게 무기가 없으면 아이템 리스트 추가 후 무기 착용
				if(play.getWeapon() != null) {
					itemList.add(play.getWeapon());
				}
				play.setWeapon(itemList.get(wear));
			}
			// 입력한 아이템이 방어구면
			else if(item.getKind() == Item.ARMOR) {
				// 길드원에게 방어구가 없으면 아이템 리스트 추가 후 방어구 착용
				if(play.getArmor() != null) {
					itemList.add(play.getArmor());
				}
				play.setArmor(itemList.get(wear));
			}
			// 입력한 아이템이 장신구면
			else if(item.getKind() == Item.RING) {
				// 길드원에게 장신구가 없으면 아이템 리스트 추가 후 장신구 착용
				if(play.getRing() != null) {
					itemList.add(play.getRing());
				}
				play.setRing(itemList.get(wear));
			}
			itemList.remove(wear);
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
