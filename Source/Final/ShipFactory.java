package battleship.ship;

import battleship.config.Configuration;

/**
 * This class is used to store ship's data from Ship class, for creating GUI in GUIStarter class.
 * @author Peisong Yang
 *
 */
public class ShipFactory {
	private static ShipFactory factory = new ShipFactory();
	
	/**
	 * Default constructor for the ShipFactory class.
	 */
	private ShipFactory(){}
	
	/**
	 * Get the factory instance in the shipFactory class.
	 * @return factory
	 */
	public static ShipFactory getFactory() {
		return factory;
	}
	
	/**
	 * Stores ship data from the Ship Class and returns a list of type Ship[]
	 * @param numberOfShips
	 * @return ships
	 */
	public Ship[] getShipsByNumber(Integer numberOfShips){
		Ship[] ships = new Ship[numberOfShips];
		for(int i = 0;i<=ships.length-1;i++) {
			Ship ship = new Ship(Configuration.SHIPSIZE,"ship"+(i+1));

			ships[i]=ship;
		}
		return ships;
	}
}
