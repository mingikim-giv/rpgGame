package rpgGame;

public class StageSetting extends Stage {
	private final int GUILDMENU = 1;
	private final int SHOP = 2;
	private final int INVENTORY = 3;
	private final int SAVE = 4;
	private final int LOAD = 5;
	private final int EXIT = 6;
	
	private UnitManager unitManager = null;
	private Shop shop;
	private FileData fileData;
	
	@Override
	public boolean update() {
		while(true) {
			System.out.println("[메인 메뉴]");
			System.out.println("① 길드 관리📝");
			System.out.println("② 상점🎪");
			System.out.println("③ 인벤토리👛");
			System.out.println("④ 파일 저장📁");
			System.out.println("⑤ 파일 로드📁");
			System.out.println("⑥ 뒤로 가기");
			int sel = inputNumber("메뉴 선택");
			
			while(!((sel == GUILDMENU) || (sel == SHOP) || (sel == INVENTORY) || (sel == SAVE) || (sel == LOAD) || (sel == EXIT))) {
				sel = inputNumber("메뉴 선택");
			}
			
			if(sel == GUILDMENU) {
				unitManager.player.guildMenu();
			}
			else if(sel == SHOP) {
				shop.store();
			}
			else if(sel == INVENTORY) {
				unitManager.player.inventoryMenu();
			}
			else if(sel == SAVE) {
				try {
					fileData.save();
					System.out.println("파일 저장 완료");
				} catch (Exception e) {
					System.err.println("파일 저장 실패");
					e.printStackTrace();
				}
			}
			else if(sel == LOAD) {
				try {
					fileData.load();
					System.out.println("파일 로드 완료");
				} catch (Exception e) {
					System.err.println("파일 로드 실패");
					e.printStackTrace();
				}
			}
			else if(sel == EXIT) {
				GameManager.nextStage = "🏰스톰빌 성 로비🏰";
				break;
			}
		}
		return false;
	}

	@Override
	public void init() {
		unitManager = UnitManager.getInstance();
		shop = new Shop();
		fileData = new FileData();
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
