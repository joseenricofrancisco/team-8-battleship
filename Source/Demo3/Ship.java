package battleship.ship;

import battleship.config.Configuration;
import battleship.controllers.ToolsClassController;
/**
 * This class is used to set ship's health, size and name. Also we use this class to set ship's start coordinates and direction.
 * We also use this class to set ship's health in the game, and to judge if ship has been damaged.
 * @author Peisong Yang
 *
 */
public class Ship {
	private int shipHealth;
	private int shipSize;
	private String shipName;
	
	private int startXCoord;
	private int startYCoord;
	
	private Integer direction=-1;
	private Object[] location;
	
	/**
	 * Constructor for the Ship class
	 * @param shipSize the size of the ship(spaces it will occupy on the board), any positive integer value
	 * @param aShipName the ship name, a string value
	 */
	Ship (int shipSize, String aShipName) {
		setShipHealth(shipSize);
		setShipSize(shipSize);
		setShipName(aShipName);
		
		setStartXCoord(((int)(Math.random()*Configuration.getMapWidth()))+1);
		setStartYCoord(((int)(Math.random()*Configuration.getMapHeight()))+1);
		
		ToolsClassController.LOCATIONINSTANCE.setDirectionAndLocationToThis(this);	
	}
	
	//Getter and setter method for ship's health, size and name.
	/**
	 * Getter method for ships health
	 * @return shipHealth integer value
	 */
	public int getShipHealth () {
		return shipHealth;
	}
	
	/**
	 * Getter methid for ships size
	 * @return shipSize integer value
	 */
	public int getShipSize () {
		return shipSize;
	}
	
	/**
	 * Getter method for the ships name
	 * @return shipName string value for the ship name
	 */
	public String getShipName() {
		return shipName;
	}

	/**
	 * Setter method to set the ship name
	 * @param shipName the desired name for the ship 
	 */
	private void setShipName(String shipName) {
		this.shipName = shipName;
	}

	private void setShipHealth(int shipHealth) {
		this.shipHealth = shipHealth;
	}

	/**
	 * Setter method to set the ship size
	 * @param shipSize integer value, desired size for the ship
	 */
	private void setShipSize(int shipSize) {
		this.shipSize = shipSize;
	}

	/**
	 * For damaging the ship in GUI, also judging if ship has been damaged.
	 * When a ship is hit, 1 deduction will be made to the ships health
	 */
	public void damageShip() {
		if (getShipHealth()>0) {
			setShipHealth(getShipHealth() - 1);
			System.out.println("The " + getShipName() + " is hitted!");
			if(getShipHealth()==0) {
				System.out.println("The " + getShipName() + " has been damaged!!!");
			}
		}
	}

	//Getter and setter method for ship's start coordinates.
	/*
	 * Get the y coordinate for where the ship's head will start
	 * @return startYCoord integer value for where the ship will be placed
	 */
	public int getStartYCoord() {
		return startYCoord;
	}

	/**
	 * Set the y coordinate for where the ship's head will start
	 * @param startYCoord integer value for where the ship will be placed
	 */
	public void setStartYCoord(int startYCoord) {
		this.startYCoord = startYCoord;
	}

	/**
	 * Get the x coordinate for where the ship's head will start
	 * @param startXCoord integer value for where the ship will be placed
	 */
	public int getStartXCoord() {
		return startXCoord;
	}
	
	/**
	 * Set the x coordinate for where the ship's head will start
	 * @param startXCoord integer value for where the ship will be placed
	 */
	public void setStartXCoord(int startXCoord) {
		this.startXCoord = startXCoord;
	}
	
	//Getter and setter method for ship's direction and location.
	/**
	 * Get the direction of the ship
	 * @return direction the direction of a ship
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * Set the direction of the ship
	 * @param direction an integer value
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	/**
	 * Get the location of the ship
	 * @return location
	 */
	public Object[] getLocation() {
		return location;
	}

	/**
	 * Get the location of the ship
	 * @param location
	 */
	public void setLocation(Object[] location) {
		this.location = location;
	}
}

