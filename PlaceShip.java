/*PlaceShip class: This class is used to set the battleship's coordinates on the game board.
 * @author: Peisong Yang
 */
public class PlaceShip {
	private int startXCoord;
	private int startYCoord;
	private String direction;
	
	//Default constructor and constructor.
	public PlaceShip() {
		
	}
	public PlaceShip(int x, int y, String direction) {
		this.startXCoord = x;
		this.startYCoord = y;
		this.direction = direction;
	}
	
	//Getter method for getting startXCoord, startYCoord and direction.
	public int getStartXCoord() {
		return this.startXCoord;
	}
	public int getStartYCoord() {
		return this.startYCoord;
	}
	public String getDirection() {
		return this.direction;
	}
	
	//Setter method for setting startXCoord, startYCoord and direction.
	public void setStartXCoord(int x) {
		this.startXCoord = x;
	}
	public void setStartYCoord(int y) {
		this.startYCoord = y;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
}
