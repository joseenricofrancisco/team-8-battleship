/*PlaceShip class: This class is used to set the battleship's coordinates on the game board.
 * @author: Peisong Yang
 */
public class PlaceShip {
	private int startXCoord;
	private int startYCoord;
	private String direction;
	private Ship ship;
	private Board board;
	
	/*Constructor: The direction includes: "V" and "H". "V" means the direction is vertical, "H" means the direction is horizontal.
	 * The battleship's coordinates must be on the game board.
	 */
	public PlaceShip(int x, int y, String direction) {
		if (direction.equals("H")) {
			if (0 < (x + ship.getShipSize()) && (x + ship.getShipSize()) < board.getMapWidth() ) {
				this.startXCoord = x;
				if ( 0 < y && y < board.getMapHeight()) {
					this.startYCoord = y;
				}
			}
		}
		if (direction.equals("V")) {
			if (0 < (y + ship.getShipSize()) && (y + ship.getShipSize()) < board.getMapHeight()) {
				this.startYCoord = y;
				if (0 < x && x < board.getMapWidth()) {
					this.startXCoord = x;
				}
			}
		}
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
		if (direction.equals("H")) {
			if (0 < (x + ship.getShipSize()) && (x + ship.getShipSize()) < board.getMapWidth() ) {
				this.startXCoord = x;
			}
		}
		else if (0 < x && x < board.getMapWidth()) {
			this.startXCoord = x;
		}
	}
	public void setStartYCoord(int y) {
		if (direction.equals("V")) {
			if (0 < (y + ship.getShipSize()) && (y + ship.getShipSize()) < board.getMapHeight()) {
				this.startYCoord = y;
			}
		}
		else if ( 0 < y && y < board.getMapHeight()) {
			this.startYCoord = y;
		}
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
}
