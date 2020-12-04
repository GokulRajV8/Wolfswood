package objects;

public class AI {

	private Player player;
	
	public AI(Player player) {
		this.player = player;
	}
	
	public Integer random() {
		return (int) (10 * Math.random());
	}
	public void placeShips() {
		boolean state = true;
		boolean isHorizontal = true;
		Integer x = 0;
		Integer y = 0;
		for(int i = 1; i < 8; i++) {
			isHorizontal = (random() % 2) == 0;
			x = random();
			y = random();
			state = player.placeShip(i, isHorizontal, x, y);
			if(!state)
				i--;
		}
	}
	public void hitEnemyBox() {
		boolean state = false;
		while(!state)
			state  = player.hitEnemyBox(random(), random());
	}
}
