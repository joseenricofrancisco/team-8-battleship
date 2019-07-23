/**This is the Ship class. This class is for determining the ship's health, size and ship's name.
 * If we hit the ship, the ship will lose one health.
 * @author Peisong Yang, Nico.
 *
 */


public class Ship {
	private int shipHealth;
	private int shipSize;
	private String shipName;
	
	public Ship (int shipHealth, int shipSize, String aShipName) {
		setShipHealth(shipHealth);
		setShipSize(shipSize);
		setShipName(aShipName);
		
/*		** We can use this block to automate the naming process. 
*		** The downside is that it cannot differentiate between the Submarine and the Cruiser due to having the same size and health.
*		** To use this, please remove the aShipName argument and it's corresponding block from the constructor.
*		
*		if (amount == 5) {
*			shipName = "Aircraft Carrier";
*		} else if (amount == 4) {
*			shipName = "Battleship";
*		} else if (amount == 3) {
*			shipName = "Submarine/Cruiser";
*		} else if (amount == 2) {
*			shipName = "Destroyer";
*		}
*/
	}
	
	public int getShipHealth () {
		return shipHealth;
	}
	
	public int getShipSize () {
		return shipSize;
	}
	
	public String getShipName() {
		return shipName;
	}

	private void setShipName(String shipName) {
		this.shipName = shipName;
	}

	private void setShipHealth(int shipHealth) {
		this.shipHealth = shipHealth;
	}

	private void setShipSize(int shipSize) {
		this.shipSize = shipSize;
	}

	public void damageShip () {
		setShipHealth(getShipHealth()-1);
	}
}
