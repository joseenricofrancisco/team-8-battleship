package battleship.controllers;
import java.util.HashMap;
import java.util.Map;
import battleship.config.Configuration;
import battleship.ship.Ship;
import battleship.ship.ShipFactory;

/**
 * This class is used to place ships on the game board.
 * @author Peisong Yang
 *
 */
public class InteractController extends Controller{
	private static InteractController instance = new InteractController();
	public Integer numberOfShips;
	private ShipFactory shipFactory = ShipFactory.getFactory();
	private Map<Integer[],Ship> ships = new HashMap<>();
	private GameoverController gameoverController = new GameoverController();
	
	/**
	 * Constructor for the class. Puts the ships on the game board based on the ship's location
	 * and size.
	 */
	private InteractController(){
		Integer numberOfShips = Configuration.NUMBEROFSHIPS;
		for(Ship ship : shipFactory.getShipsByNumber(numberOfShips)) {
			gameoverController.getShipsRemaining().add(ship);
			Integer[][] coordsOfThisShip = ToolsClassController.PARSETOCOORDS.getCoords(ship.getLocation(),ship.getShipSize());
			for(int n = 0;n<coordsOfThisShip.length;n++) {
				ships.put(coordsOfThisShip[n], ship);
			}
		}
	}
	
	/**
	 * Used to get the instance in the interactControllerInstance Class
	 * @return instance
	 */
	public static InteractController getInteractControllerInstance() {
		return instance;
	}
		/**
	 * This method is used to put ships on the GUI buttons.
	 * @return ships
	 */
	public Map<Integer[], Ship> getShips() {
		return ships;
	}

	/**
	 * Get the gameoverController
	 * @return gameoverController
	 */
	public GameoverController getGameoverController() {
		return gameoverController;
	}
}
