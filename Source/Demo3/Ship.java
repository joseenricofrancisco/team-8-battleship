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
	
	Ship (int shipSize, String aShipName) {
		setShipHealth(shipSize);
		setShipSize(shipSize);
		setShipName(aShipName);
		
		setStartXCoord(((int)(Math.random()*Configuration.getMapWidth()))+1);
		setStartYCoord(((int)(Math.random()*Configuration.getMapHeight()))+1);
		
		ToolsClassController.LOCATIONINSTANCE.setDirectionAndLocationToThis(this);	
	}
	
	//Getter and setter method for ship's health, size and name.
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

	//For damaging the ship in GUI, also judging if ship has been damaged.
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
	
	//Getter and setter method for ship's direction and location.
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
