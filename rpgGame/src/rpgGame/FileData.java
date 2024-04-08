package rpgGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileData {
	private UnitManager unitManager;
	private FileWriter fw;
	private ArrayList<Player> temp;
	private File file;
	private FileReader fr;
	private BufferedReader br;
	
	// save
	public void save() throws IOException {
		unitManager = UnitManager.getInstance();
		String data = "ELDEN.txt";
		fw = new FileWriter(data);
		temp = unitManager.player.getGuildList();
		String gameData = "";
		gameData += Player.money;
		gameData += "\n";
		gameData += temp.size();
		gameData += "\n";
		
		// 길드원 저장
		for(int i = 0; i < temp.size(); i ++) {
			gameData += temp.get(i).getName();
			gameData += "/";
			gameData += temp.get(i).getLevel();
			gameData += "/";
			gameData += temp.get(i).getMaxHp();
			gameData += "/";
			gameData += temp.get(i).getPower();
			gameData += "/";
			gameData += temp.get(i).getDefense();
			gameData += "/";
			gameData += temp.get(i).getParty();
			gameData += "\n";
			
			if(temp.get(i).getWeapon() == null) {
				gameData += temp.get(i).getWeapon();
			}
			else {
				Item item = temp.get(i).getWeapon();
				String weaponData = "";
				weaponData += item.getKind();
				weaponData += ",";
				weaponData += item.getName();
				weaponData += ",";
				weaponData += item.getPower();
				weaponData += ",";
				weaponData += item.getPrice();
				gameData += weaponData;
			}
			gameData += "\n";
			
			if(temp.get(i).getArmor() == null) {
				gameData += temp.get(i).getArmor();
			}
			else {
				Item item = temp.get(i).getArmor();
				String armorData = "";
				armorData += item.getKind();
				armorData += ",";
				armorData += item.getName();
				armorData += ",";
				armorData += item.getPower();
				armorData += ",";
				armorData += item.getPrice();
				gameData += armorData;
			}
			gameData += "\n";
			
			if(temp.get(i).getRing() == null) {
				gameData += temp.get(i).getRing();
			}
			else {
				Item item = temp.get(i).getRing();
				String ringData = "";
				ringData += item.getKind();
				ringData += ",";
				ringData += item.getName();
				ringData += ",";
				ringData += item.getPower();
				ringData += ",";
				ringData += item.getPrice();
				gameData += ringData;
			}
			gameData += "\n";
		}
		// 소지한 아이템 개수
		gameData += Player.getItemSize();
		gameData += "\n";
		// 아이템 저장
		for(int i = 0; i < Player.getItemSize(); i ++) {
			Item item = Player.getItemList().get(i);
			gameData += item.getKind();
			gameData += ",";
			gameData += item.getName();
			gameData += ",";
			gameData += item.getPower();
			gameData += ",";
			gameData += item.getPrice();
			gameData += "\n";
		}
		System.out.println(gameData);
		fw.write(gameData, 0, gameData.length());
		fw.close();
	}
	
	// load
	public void load() throws IOException {
		String data = "ELDEN.txt";
		file = new File(data);
		if(file.exists()) {
			fr = new FileReader(data);
			br = new BufferedReader(fr);
			
			// 플레이어 소지금
			String money = br.readLine();
			Player.money = Integer.parseInt(money);
			System.out.println(Player.money);
			
			// 길드원 수
			String guildSize = br.readLine();
			int size = Integer.parseInt(guildSize);
			Player.guild.guildList.clear();	// 길드원 리스트 초기화
			System.out.println(size);
			
			for(int i = 0; i < size; i ++) {
				// 이름/레벨/최대체력/공격력/방어력/파티유무
				String play = br.readLine();
				String[] playArr = play.split("/");
				
				String name = playArr[0];
				int lv = Integer.parseInt(playArr[1]);
				int maxHp = Integer.parseInt(playArr[2]);
				int pw = Integer.parseInt(playArr[3]);
				int def = Integer.parseInt(playArr[4]);
				boolean party = Boolean.parseBoolean(playArr[5]);
				// 길드원 길드리스트 저장
				Player temp = new Player(name, lv, maxHp, pw, def, party);
				Player.guild.guildList.add(temp);
				
				String itemData = br.readLine();
				String[] itemArr = itemData.split("/");
				// 무기 저장
				if(itemArr[0].equals("null")) {
					Player.getGuildList().get(i).setWeapon(null);
				}
				else {
					// 종류,이름,능력,가격
					String[] weapon = itemArr[0].split(",");
					int kind = Integer.parseInt(weapon[0]);
					String itemName = weapon[1];
					int itemPower = Integer.parseInt(weapon[2]);
					int itemPrice = Integer.parseInt(weapon[3]);
					
					Item item = new Item();
					item.setItem(kind, itemName, itemPower, itemPrice);
					Player.getGuildList().get(i).setWeapon(item);
				}
			}
		}
	}
}
