/*This is the class for the game board, it is a fundamental class for the whole game.
 * @author Peisong Yang
*/
public class BattleshipBoard {
	private int mapWidth;
	private int mapHeight;
	private int [] [] mapBoard;
	private int shipSize;
	private int numOfHits;
	
	public static final int BLANK = 0; // a status of 
	public static final int SHIPCOORD = 1;//a status of Ship's location.
	public static final int MISSCOORD = 2;//a status of shoot missing.
	public static final int HITCOORD = 3;// a status of hit.
	
	
	
	public static final int DIRECTION_HORZ = 0;// The ship's direction is horizon.
	public static final int DIRECTION_VERT = 1;// The ship's direction is vertical.
	
	
	
	/* Creates the board and initializes all coordinates to "BLANK".
	 * Assume that the biggest size of game board is 40 * 40, it is much bigger than
	 * 10 * 10, this is because I just want to be sure that all ships can be located on
	 * the board, even if some ships are too big.
	 */
	public BattleshipBoard(int width, int height) {
	// Restrict the ranges of height and width both between 0 and 40.
	// If height or width is out of this range, return them to a default value 40.
		if (width < 0 || width > 40) {
			width = 40;
		}
		if (height < 0 || height > 40) {
			height = 40;
		}
		this.mapWidth = width;
		this.mapHeight = height;
		mapBoard = new int [mapWidth] [mapHeight];
		
		for (int i = 0; i < mapWidth ; i++) {
			for (int j = 0 ; j < mapHeight ; j++) {
				mapBoard [i][j] = BLANK; // a static status of map's size.
			}
		}
		shipSize = 0; // initialize the shipSize.
		numOfHits = 0;// initialize the numOfHits.
		
/*For testing the size of board. There will be a print on the command that tells us
 *  what the values of height and width are.
 */
		System.out.println("Board size (Width * Height) " + width + ", " + height); 
		
	}
	// The getters of board's width and height.
	public int getWidth() {
		return mapWidth;
	}
	public int getHeight() {
		return mapHeight;
	}
	
	// PlaceShip: places the ship at specified coordinate.
	public boolean placeShip(int x, int y, int direction,int size) {
		
	/*For testing the code. There will be a print on the command that tells us
	 * where the ship's location is, also what the direction is.
     */
		System.out.println("Specified location: x = " + x + ", y = " + y);
		System.out.println("Direction: " + (direction == DIRECTION_HORZ ? "Horz" : "Vert"));
		
		if( x >= mapWidth || y >= mapHeight) return false; // The ship's location must be on the board.
		if ( direction == DIRECTION_HORZ) {
      // The ship must be totally on the board. There cannot be a part of the ship on the board.
			if ( x + size > mapWidth)
				return false;
		}
		else {
			if ( y + size > mapHeight)
				return false;
		}
		shipSize = size;
		
		for (int i = 0; i < size; i++) {
			mapBoard[x] [y] = SHIPCOORD;
			System.out.println("Ship's coordinates: " + x + ", y = " + y); //For testing.
			if ( direction == DIRECTION_HORZ) {
				x++;
			}
			else 
				y++;
		}
		return true;
	}
	
	//ShootAtShip: Take a shoot to the ship on the board after we have already place a ship on the board.
	//There is a status indicating if we have shot at the ship, if we have shot, then "numOfHits + 1".
	public int shootAtShip(int x, int y) {
		if ( x >= mapWidth || y >= mapHeight)
			return -1; //return false, because we cannot shot outside the board.
		if (mapBoard[x][y] == HITCOORD || mapBoard[x][y]  == MISSCOORD) {
			return -2;
		}
		if ( mapBoard [x][y] == SHIPCOORD) {
			mapBoard[x][y] = HITCOORD;
			numOfHits++;
		}
		else {
			mapBoard[x][y] = MISSCOORD;
		}
		return mapBoard[x][y];
	}
	
}
