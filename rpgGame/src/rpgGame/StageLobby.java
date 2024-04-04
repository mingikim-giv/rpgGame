package rpgGame;

public class StageLobby extends Stage {
	private final int BATTLE = 1;
	private final int SETTING = 2;
	private final int EXIT = 3;
	
	@Override
	public boolean update() {
		System.out.println("🏰스톰빌 성 로비🏰");
		System.out.println("① 전투⚔️");
		System.out.println("② 설정⚙️");
		System.out.println("③ 종료");
		int sel = inputNumber("메뉴 선택");
		
		while(!((sel == BATTLE) || (sel == SETTING) || (sel == EXIT))) {
			sel = inputNumber("메뉴 선택");
		}
		
		if(sel == BATTLE) {
			GameManager.nextStage = "🏰스톰빌 성🏰";
		}
		else if(sel == SETTING) {
			GameManager.nextStage = "🏰스톰빌 성 신수탑🏰";
		}
		else if(sel == EXIT) {
			GameManager.nextStage = "";
		}
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
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
