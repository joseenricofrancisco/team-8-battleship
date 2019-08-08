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
	
	/**
	 * Default constructor.
	 */
	GameoverController() {}
	
	//Getter and setter methods for this list.
	
	/**
	 * Get the list of ships that remain on the board
	 * @return shipsRemaining
	 */
	List<Ship> getShipsRemaining() {
		return shipsRemaining;
	}
	
	/**
	 * Set the remaining ships on the board into a list
	 * @param remaining 
	 */
	void setShipsRemaining(List<Ship> remaining) {
		shipsRemaining = remaining;
	}
	

	/**
	 * To judge how many ships are still on the game board. When all ships have been damaged 
	 * and the shipsRemaining list is empty (all ships have 0 health), the game will terminate.
	 * @param ship 
	 */
	public void judgeGameover(Ship ship) {
		if(ship.getShipHealth()==0) {
				shipsRemaining.remove(ship);
		}
		
		if(shipsRemaining.isEmpty()) {
			System.out.println("All the ships has been damaged");
			System.exit(0);
		}
	}
}
