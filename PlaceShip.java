import java.util.ArrayList;

/**
 * PlaceShip class: This class is used to set the battleship's coordinates on the game board.
 * @author: Peisong Yang
 */
public class PlaceShip {
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
	
	public PlaceShip(int boardX, int boardY,int lengthOfShip) {
		setStartXCoord((int)(Math.random()*boardX));
		setStartYCoord((int)(Math.random()*boardY));
	}
	
//	public PlaceShip(int x, int y) {
//		this.startXCoord = x;
//		this.startYCoord = y;
//	}
	
	
	public ArrayList<Boolean> getAvailableDirection(int boardX, int boardY, int lengthOfShip) {
		ArrayList<Boolean> availableDirections = new ArrayList<>();
		if(startXCoord<lengthOfShip) {
			availableDirections.add(0, false);
		}else {
			availableDirections.add(0, true);
		}
		
		if((boardY-startYCoord)<lengthOfShip) {
			availableDirections.add(1, false);
		}else {
			availableDirections.add(1, true);
		}
		
		if((boardX-startXCoord)<lengthOfShip) {
			availableDirections.add(2, false);
		}else {
			availableDirections.add(2, true);
		}
		
		if(startYCoord<lengthOfShip) {
			availableDirections.add(3, false);
		}else {
			availableDirections.add(3, true);
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
