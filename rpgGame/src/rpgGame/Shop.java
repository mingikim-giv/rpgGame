package rpgGame;

import java.util.ArrayList;

public class Shop {
	private ArrayList<Item> itemList;
	private Item temp;
	
	public Shop() {
		itemList = new ArrayList<>();
		temp = new Item();
		temp.setKind(Item.WEAPON);
		temp.setName("명도 월은");
		temp.setPower(5);
		temp.setPrice(4000);
		itemList.add(temp);
		
		temp = new Item();
		temp.setKind(Item.WEAPON);
		temp.setName("카리아의 왕홀");
		temp.setPower(3);
		temp.setPrice(2500);
		itemList.add(temp);
		
		temp = new Item();
		temp.setKind(Item.WEAPON);
		temp.setName("그레이트 소드");
		temp.setPower(10);
		temp.setPrice(6000);
		itemList.add(temp);
		
		temp = new Item();
		temp.setKind(Item.ARMOR);
		temp.setName("말레니아 세트");
		temp.setPower(7);
		temp.setPrice(5000);
		itemList.add(temp);
		
		temp = new Item();
		temp.setKind(Item.ARMOR);
		temp.setName("라단 세트");
		temp.setPower(4);
		temp.setPrice(3000);
		itemList.add(temp);
		
		temp = new Item();
		temp.setKind(Item.ARMOR);
		temp.setName("눈 마녀 세트");
		temp.setPower(2);
		temp.setPrice(2000);
		itemList.add(temp);
		
		temp = new Item();
		temp.setKind(Item.RING);
		temp.setName("단검의 탈리스만");
		temp.setPower(7);
		temp.setPrice(10000);
		itemList.add(temp);
		
		temp = new Item();
		temp.setKind(Item.RING);
		temp.setName("라다곤의 각인");
		temp.setPower(20);
		temp.setPrice(30000);
		itemList.add(temp);
		
		temp = new Item();
		temp.setKind(Item.RING);
		temp.setName("녹스텔라의 달");
		temp.setPower(13);
		temp.setPrice(18000);
		itemList.add(temp);
	}
	
	// shop
	public void shop() {
		System.out.println("───────[상점🎪]───────");
		System.out.println("① 무기⚔️");
		System.out.println("② 방어구🛡️");
		System.out.println("③ 장신구💍");
		System.out.println("④ 뒤로 가기");
	}
	
	// inputNumber
	private int inputNumber(String message) {
		int number = -1;
		
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
