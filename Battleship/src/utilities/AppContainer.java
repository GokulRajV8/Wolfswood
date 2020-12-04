package utilities;

import objects.AI;
import objects.Player;
import services.Refree;

public class AppContainer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		Player player1 = new Player();
		Player player2 = new Player();
		Refree refree = new Refree();
		refree.setPlayers(player1, player2);
		AI ai1 = new AI(player1);
		AI ai2 = new AI(player2);
		
		ai1.placeShips();
		player1.getBoard().display();
		System.out.println("");
		ai2.placeShips();
		player2.getBoard().display();
		System.out.println("");
		for(; i <= 100; i++) {
			ai1.hitEnemyBox();
			if(player2.getNoOfShips() == 0)
				break;
			ai2.hitEnemyBox();
			if(player1.getNoOfShips() == 0)
				break;
		}
		player1.getBoard().display();
		System.out.println("");
		player2.getBoard().display();
		System.out.println("No of Moves..." + i);
		System.out.println(refree.whoIsInLead());
	}
}
