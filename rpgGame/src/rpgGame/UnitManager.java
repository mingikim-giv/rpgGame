package rpgGame;

import java.util.ArrayList;

public class UnitManager {
	private static UnitManager instance = new UnitManager();
	
	public ArrayList<Player> playList;
	public ArrayList<Monster> monsterList;
	
	private String path = "rpgGame.";
	private String monster[] = {"Radahn", "Malenia", "Radagon"};
	
	public Player player;
	
	public UnitManager() {
		playList = new ArrayList<>();
		monsterList = new ArrayList<>();
		player = new Player();
	}
	
	public static UnitManager getInstance() {
		return instance;
	}
	
	public void init() {
		player.init();
	}
	
	// ranMonster
	public void ranMonster(int size) {
		for(int i = 0; i < size; i ++) {
			int num = GameManager.ran.nextInt(monster.length);
			try {
				Class<?> clazz = Class.forName(path + monster[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				
				Monster temp = (Monster) obj;
				int hp = GameManager.ran.nextInt(100) + 200;
		        int pw = GameManager.ran.nextInt(10) + 20;
		        
		        temp.init(hp, pw);
		        monsterList.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
