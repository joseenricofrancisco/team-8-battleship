package battleship.ship;

import java.util.HashMap;
import java.util.Map;

import battleship.config.Configuration;
import battleship.controllers.ToolsClassController;

/**
 * This class is used to store ship's data from Ship class, for creating GUI in GUIStarter class.
 * @author Peisong Yang
 *
 */
public class ShipFactory {
	private static ShipFactory factory = new ShipFactory();
	
	private ShipFactory(){}
	
	public static ShipFactory getFactory() {
		return factory;
	}
	
	public Ship[] getShipsByNumber(Integer numberOfShips){
		Ship[] ships = new Ship[numberOfShips];
		for(int i = 0;i<=ships.length-1;i++) {
			Ship ship = new Ship(Configuration.SHIPSIZE,"ship"+(i+1));
			ships[i]=ship;
		}
		return ships;
	}
}
