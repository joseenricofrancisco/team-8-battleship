/**
 * Ship class: This class is used to set the ship's size, health and name.
 * @author Peisong Yang, Nico.
 *
 */
public class Ship {
	private int shipHealth;
	private int shipSize;
	private String shipName;
	
	private int startXCoord;
	private int startYCoord;
	
	private int direction;
	private Object[] location;
	
	public Ship (int shipSize, String aShipName) {
		setShipHealth(shipSize);
		setShipSize(shipSize);
		setShipName(aShipName);
		
		Board board = ClassFactory.getBoardInstance();
		
		setStartXCoord(((int)(Math.random()*board.getMapWidth()))+1);
		setStartYCoord(((int)(Math.random()*board.getMapHeight()))+1);
		
		direction = ClassFactory.getConfirmDirectionInstance().getFinalDirection(startXCoord, startXCoord, shipSize);
		
		location = ClassFactory.getLocationInstance().getLocation(this);
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

	//----------------------------
	
	public int getStartYCoord() {
		return startYCoord;
	}

	public void setStartYCoord(int startYCoord) {
		this.startYCoord = startYCoord;
	}

	public int getStartXCoord() {
		return startXCoord;
	}

	public void setStartXCoord(int startXCoord) {
		this.startXCoord = startXCoord;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public Object[] getLocation() {
		return location;
	}

	public void setLocation(Object[] location) {
		this.location = location;
	}
	
	
}
