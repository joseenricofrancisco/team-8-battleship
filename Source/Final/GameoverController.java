package battleship.controllers;

import java.util.ArrayList;
import java.util.List;

import battleship.ship.Ship;

/**
 * This class is used to judge how many ships are still on the game board. When all ships have been damaged, the game will be closed.
 * Also to judge who wins this game.
 * @author Peisong Yang
 */
public class GameoverController extends Controller{
	// Create a list to store the remaining ships on the game board.
	List<Ship> shipsRemaining = new ArrayList<>();
	// Create a list to store the damage by player.
	List<Ship> damagedByPlayer = new ArrayList<>();
	// Create a list to store the damage by AI.
	List<Ship> damagedByAI = new ArrayList<>();
	
	/**
	 * Get the list of ships that remain on the board
	 * @return shipsRemaining
	 */
	List<Ship> getShipsRemaining() {
		return shipsRemaining;
	}
	
	/**
	 * To judge how many ships are still on the game board. When all ships have been damaged 
	 * and the shipsRemaining list is empty (all ships have 0 health), the game will terminate.
	 * Judge who wins the game.
	 * @param ship
	 * @param playerOrAI
	 */
	public void judgeGameover(Ship ship,int playerOrAI) {
		if(ship.getShipHealth()==0) {
			//player:count%2==0 / AI:count%2!=0
			if(playerOrAI%2==0) {
				damagedByAI.add(ship);
			}else if(playerOrAI%2!=0){
				damagedByPlayer.add(ship);
			}
			shipsRemaining.remove(ship);
		}
		
		if(shipsRemaining.isEmpty()) {
			System.out.println("All the ships has been damaged");
			if(damagedByAI.size() > damagedByPlayer.size()) {
				System.out.println("AI WIN!!!");
			}else if(damagedByAI.size() < damagedByPlayer.size()) {
				System.out.println("Player WIN!!!");
			}else if(damagedByAI.size() == damagedByPlayer.size()) {
				System.out.println("DRAW...");
			}
			System.exit(0);
		}
	}
	
	/**
	 * Default constructor.
	 */
	GameoverController() {}
}
