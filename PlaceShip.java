/**
 * PlaceShip class: This class is used to set the ship's coordinates and directions on the game board.
 * @author: Peisong Yang
 */
public class PlaceShip {
	private static final int LEFT = 0;
	private static final int UP = 1;
	private static final int RIGHT = 2;
	private static final int DOWN = 3;
	
	private int startXCoord;
	private int startYCoord;
//	private boolean hasLeft = true;
//	private boolean hasUp = true;
//	private boolean hasRight = true;
//	private boolean hasDown = true;
	
	//Default constructor and constructor.
//	public PlaceShip() {
//		setStartXCoord((int)(Math.random()));
//		
//	}
	
	public PlaceShip(int boardX, int boardY,int shipSize) {
		setStartXCoord((int)(Math.random()*boardX));
		setStartYCoord((int)(Math.random()*boardY));
	}
	
//	public PlaceShip(int x, int y) {
//		this.startXCoord = x;
//		this.startYCoord = y;
//	}
	
	
	public boolean[] getAvailableDirection(int boardX, int boardY, int shipSize) {
		boolean[] availableDirections = new boolean[4];
		if(startXCoord<shipSize) {
			availableDirections[LEFT] = false;
		}else {
			availableDirections[LEFT] = true;
		}
		
		if((boardY-startYCoord)<shipSize) {
			availableDirections[UP] = false;
		}else {
			availableDirections[UP] = true;
		}
		
		if((boardX-startXCoord)<shipSize) {
			availableDirections[RIGHT] = false;
		}else {
			availableDirections[RIGHT] = true;
		}
		
		if(startYCoord<shipSize) {
			availableDirections[DOWN] = false;
		}else {
			availableDirections[DOWN] = true;
		}
		
		return availableDirections;
	}
	
	
	//Getter method for getting startXCoord, startYCoord and direction.
	public int getStartXCoord() {
		return this.startXCoord;
	}
	public int getStartYCoord() {
		return this.startYCoord;
	}
	
	
	//Setter method for setting startXCoord, startYCoord and direction.
	public void setStartXCoord(int x) {
		this.startXCoord = x;
	}
	public void setStartYCoord(int y) {
		this.startYCoord = y;
	}
	
	
}
