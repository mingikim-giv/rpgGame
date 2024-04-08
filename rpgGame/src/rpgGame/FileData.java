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
			gameData += "/";
			
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
			gameData += "/";
			
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
			gameData += "/";
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
}
