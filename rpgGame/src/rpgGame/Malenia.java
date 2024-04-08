package rpgGame;

public class Malenia extends Monster {
	public Malenia() {
		setName("말레니아");
	}
	
	public void skill(Player target) {
		System.out.println("물새 난격🗡️");
		target.setHp(target.getHp() - this.getPower()*2);
		System.out.printf("[%s](이)가 플레이어에게 %d의 데미지를 입힌다.\n", this.getName(), (this.getPower()*2));
		
		if(target.getHp() <= 0) {
			target.setHp(0);
			System.out.printf("[%s](을)를 처치했습니다.\n", target.getName());
		}
	}
}
