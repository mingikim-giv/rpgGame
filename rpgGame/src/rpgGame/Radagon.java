package rpgGame;

public class Radagon extends Monster {
	public Radagon() {
		setName("라다곤");
	}
	
	public void skill(Player target) {
		System.out.println("황금률 망치🔨");
		target.setHp(target.getHp() - this.getPower()*3);
		System.out.printf("[%s](이)가 플레이어에게 %d의 데미지를 입힌다.\n", this.getName(), (this.getPower()*3));
		
		if(target.getHp() <= 0) {
			target.setHp(0);
			System.out.printf("[%s](을)를 처치했습니다.\n", target.getName());
		}
	}
}
