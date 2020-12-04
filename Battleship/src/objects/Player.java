package objects;

import beans.Ship;

public class Player {

	private Ship[] ships = new Ship[7];
	private Board board;
	private Board enemyBoard;
	
	public Player() {
		super();
		this.ships[0] = new Ship(1, "Carrier", 5);
		this.ships[1] = new Ship(2, "Battleship", 4);
		this.ships[2] = new Ship(3, "Submarine", 3);
		this.ships[3] = new Ship(4, "Destroyer", 3);
		this.ships[4] = new Ship(5, "Destroyer", 3);
		this.ships[5] = new Ship(6, "PatrolBoat", 2);
		this.ships[6] = new Ship(7, "PatrolBoat", 2);
		this.board = new Board(this.ships);
	}
	
	public Board getBoard() {
		return this.board;
	}
	public void setEnemy(Player enemy) {
		this.enemyBoard = enemy.getBoard();
	}
	
	public void removeShips(Integer index) {
		this.ships[index] = null;
	}
	public Ship[] getShips() {
		return this.ships;
	}
	public Integer getNoOfShips() {
		Integer noOfShips = 0;
		for(Ship ship : ships)
			if(ship != null)
				noOfShips++;
		return noOfShips;
	}
	public String showShips() {
		String result = "";
		for(Ship ship : this.ships) {
			if(ship != null)
				result += ship.getName() + " ";
			else
				result += "null ";
		}
		return result;
	}
	public boolean placeShip(Integer shipID, boolean isHorizontal, Integer x, Integer y) {
		this.ships[shipID - 1].setIsHorizontal(isHorizontal);
		this.ships[shipID - 1].setxCoordinate(x);
		this.ships[shipID - 1].setyCoordinate(y);
		return this.board.placeShip(this.ships[shipID - 1]);
	}
	public boolean hitEnemyBox(Integer x, Integer y) {
		return this.enemyBoard.hitBox(x, y);
	}
}
