package rpgGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	public static Scanner scan = new Scanner(System.in);
	public static Random ran = new Random();
	
	private Map<String, Stage> stageList = new HashMap<String, Stage>();
	private boolean isRun = true;
	
	public static String nextStage = "";
	private String curStage = "";
	
	public GameManager() {}
	
	// init
	private void init() {
		stageList.put("🏰스톰빌 성 정문🏰", new StageTitle());
		stageList.put("🏰스톰빌 성🏰", new StageBattle());
		stageList.put("🏰스톰빌 성 로비🏰", new StageLobby());
		stageList.put("🏰스톰빌 성 신수탑🏰", new StageSetting());
		nextStage = "🏰스톰빌 성 정문🏰";
	}
	
	// changeStage
	private boolean changeStage() {
		System.out.println("현재 스테이지:" + curStage);
		System.out.println("다음 스테이지:" + nextStage);
		
		if(curStage.equals(nextStage)) {
			return true;
		}
		
		curStage = nextStage;
		Stage stage = stageList.get(curStage);
		stage.init();	// 스테이지 초기화
		
		while(true) {
			isRun = stage.update();
			if(isRun == false) {
				break;
			}
		}
		
		if(nextStage.equals("")) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	public void run() {
		init();
		while(isRun) {
			isRun = changeStage();
			if(isRun == false) {
				break;
			}
		}
		System.out.println("게임 종료");
	}
}
