package services;

import beans.Ship;
import objects.Player;

public class Refree {

	private Player player1;
	private Player player2;
	
	public void setPlayers(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.player2.setEnemy(player1);
		this.player1.setEnemy(player2);
	}	
	public String whoIsInLead() {
		int player1Score = 0;
		int player2Score = 0;
		Ship[] player1Ships = this.player1.getShips();
		Ship[] player2Ships = this.player2.getShips();
		for(int i = 0; i < 7; i++) {
			if(player1Ships[i] != null)
				player1Score++;
			if(player2Ships[i] != null)
				player2Score++;
		}
		if(player1Score > player2Score)
			return "Player 1";
		else if (player2Score > player1Score)
			return "Player 2";
		else
			return "Tie";
	}
}
