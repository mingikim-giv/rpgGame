package rpgGame;

public class StageTitle extends Stage {

	@Override
	public boolean update() {
		System.out.println("🏰스톰빌 성🏰");
		System.out.println("[시작]을 입력하세요.");
		String start = GameManager.scan.next();
		
		while(!start.equals("시작")) {
			System.out.println("[시작]을 입력하세요.");
			start = GameManager.scan.next();
		}
		GameManager.nextStage = "🏰스톰빌 성 로비🏰";
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
}
