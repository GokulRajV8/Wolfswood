package objects;

import beans.Box;
import beans.Ship;

public class Board {

	private Ship[] ships;
	private Box[][] boxes = new Box[10][10];
	
	public Board(Ship[] ships) {
		super();
		this.ships = ships;
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++)
				this.boxes[i][j] = new Box();
	}

	public boolean placeShip(Ship ship) {
		if(ship.getIsHorizontal()) {
			if((ship.getSize() + ship.getxCoordinate()) > 9)
				return false;
		}
		else {
			if((ship.getSize() + ship.getyCoordinate()) > 9)
				return false;
		}
		if(ship.getIsHorizontal())
			for(int i = 0; i < ship.getSize(); i++) {
				if(this.boxes[ship.getxCoordinate() + i][ship.getyCoordinate()].shipID != 0)
					return false;
			}
		else
			for(int i = 0; i < ship.getSize(); i++) {
				if(this.boxes[ship.getxCoordinate()][ship.getyCoordinate() + i].shipID != 0)
					return false;
			}
		if(ship.getIsHorizontal())
			for(int i = 0; i < ship.getSize(); i++)
				this.boxes[ship.getxCoordinate() + i][ship.getyCoordinate()].shipID = ship.getID();
		else
			for(int i = 0; i < ship.getSize(); i++)
				this.boxes[ship.getxCoordinate()][ship.getyCoordinate() + i].shipID = ship.getID();
		return true;
	}
	public void removeShip(Ship ship) {
		if(ship.getIsHorizontal())
			for(int i = 0; i < ship.getSize(); i++)
				this.boxes[ship.getxCoordinate() + i][ship.getyCoordinate()].shipID = 0;
		else
			for(int i = 0; i < ship.getSize(); i++)
				this.boxes[ship.getxCoordinate()][ship.getyCoordinate() + i].shipID = 0;
	}
	public boolean hitBox(Integer x, Integer y) {
		if(!this.boxes[x][y].hit) {
			for(Ship ship : this.ships) {
				if(ship != null) {
					if(ship.getID().equals(boxes[x][y].shipID)) {
						ship.setHealth(ship.getHealth() - 1);
						if(ship.getHealth() == 0)
							this.ships[ship.getID() - 1] = null;
					}
				}
			}
			this.boxes[x][y].hit = true;
			this.boxes[x][y].shipID = 0;
			return true;
		}
		return false;
	}
	public void display() {
		for(int i = 0; i < 10; i++) {
			for(int j =0; j < 10; j++)
				System.out.print(this.boxes[j][i].shipID + " ");
			System.out.print("\n");
		}	
	}
}
