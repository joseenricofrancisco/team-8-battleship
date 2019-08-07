package battleship.services;

import battleship.config.Configuration;
import battleship.ship.Ship;

/**
 * This class is used to judge the direction of ship, and set the coordinates of ship's location.
 * @author Peisong Yang
 *
 */
public class Locations {
	
	private static final int LEFT = 0;
	private static final int DOWN = 1;
	private static final int RIGHT = 2;
	private static final int UP = 3;
	
	//Judge if ship has a direction.
	public void setDirectionAndLocationToThis(Ship ship) {
		if (ship.getDirection()==-1) {
			calculateDirection(ship, Configuration.getMapWidth(),Configuration.getMapHeight());
		}
		
		if (ship.getLocation()==null) {
			calculateLocation(ship);
		}
	}
	
	//Judge the ship's direction and set ship's direction.
	private void calculateDirection(Ship ship,Integer mapWidth,Integer mapHeight) {

		Integer finalDirection;

		boolean[] availableDirections = new boolean[4];

		if(ship.getStartXCoord()<ship.getShipSize()) {
			availableDirections[LEFT] = false;
		}else {
			availableDirections[LEFT] = true;
		}

		if((mapHeight-ship.getStartYCoord())<ship.getShipSize()) {
			availableDirections[DOWN] = false;
		}else {
			availableDirections[DOWN] = true;
		}

		if((mapWidth-ship.getStartXCoord())<ship.getShipSize()) {
			availableDirections[RIGHT] = false;
		}else {
			availableDirections[RIGHT] = true;
		}

		if(ship.getStartYCoord()<ship.getShipSize()) {
			availableDirections[UP] = false;
		}else {
			availableDirections[UP] = true;
		}

		while(true) {
			int index = (int)(Math.random()*4);
			if(availableDirections[index]==true) {
				finalDirection=index;
				break;
			}
		}
		
		ship.setDirection(finalDirection);
	}
	
	// Set ship's location depending on ship's direction.
	public void calculateLocation(Ship ship) {
		Object[] location = new Object[2];
		
		switch(ship.getDirection()){
		case LEFT :

			int leftStartOfX = ship.getStartXCoord();
			int leftFixedY= ship.getStartYCoord();

			int[] leftPointsOfX =  new int[ship.getShipSize()];
			for(int i = 0 ; i< leftPointsOfX.length ; i++) {
				leftPointsOfX[i]=leftStartOfX--;
			}

			location[0]=leftPointsOfX;
			location[1]=leftFixedY;

			break;

		case DOWN :

			int downFixedX = ship.getStartXCoord();
			int downStartOfY = ship.getStartYCoord();

			int[] downPointsOfY =  new int[ship.getShipSize()];
			for(int i = 0;i<downPointsOfY.length;i++) {
				downPointsOfY[i]=downStartOfY++;
			}

			location[0]=downFixedX;
			location[1]=downPointsOfY;

			break;

		case RIGHT :

			int rightStartOfX = ship.getStartXCoord();
			int rightFixedY= ship.getStartYCoord();

			int[] rightPointsOfX =  new int[ship.getShipSize()];
			for(int i = 0 ; i< rightPointsOfX.length ; i++) {
				rightPointsOfX[i]=rightStartOfX++;
			}

			location[0]=rightPointsOfX;
			location[1]=rightFixedY;

			break;

		case UP :

			int upFixedX = ship.getStartXCoord();
			int upStartOfY = ship.getStartYCoord();

			int[] upPointsOfY =  new int[ship.getShipSize()];
			for(int i = 0;i<upPointsOfY.length;i++) {
				upPointsOfY[i]=upStartOfY--;
			}

			location[0]=upFixedX;
			location[1]=upPointsOfY;

			break;
		}

		ship.setLocation(location);
	}
	
}
