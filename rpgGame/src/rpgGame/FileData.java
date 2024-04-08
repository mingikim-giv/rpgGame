package rpgGame;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileData {
	private UnitManager unitManager;
	private FileWriter fw = null;
	private ArrayList<Player> temp;
	
	public void save() throws IOException {
		unitManager = UnitManager.getInstance();
		String data = "ELDEN.txt";
		fw = new FileWriter(data);
		temp = unitManager.player.getGuildList();
		String gameData = "";
	}
}
