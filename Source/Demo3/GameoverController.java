package battleship.controllers;
/**
 * This class is used to judge how many ships are still on the game board. When all ships have been damaged, the game will be closed.
 * @author Peisong Yang
 */
import java.util.ArrayList;
import java.util.List;

import battleship.ship.Ship;

public class GameoverController{
	// Create a list to store the remaining ships on the game board.
	List<Ship> shipsRemaining = new ArrayList<>();
	
	//Getter and setter methods for this list.
	List<Ship> getShipsRemaining() {
		return shipsRemaining;
	}

	void setShipsRemaining(List<Ship> remaining) {
		shipsRemaining = remaining;
	}
	

	//To judge how many ships are still on the game board. When all ships have been damaged, the game will be closed.
	public void judgeGameover(Ship ship) {
		if(ship.getShipHealth()==0) {
				shipsRemaining.remove(ship);
		}
		
		if(shipsRemaining.isEmpty()) {
			System.out.println("All the ships has been damaged");
			System.exit(0);
		}
	}
	
	// Default constructor.
	GameoverController() {}
}
