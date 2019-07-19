
public class BattleshipBoard {
	private int mapWidth;
	private int mapHeight;
	private int [] [] mapBoard;
	private int shipSize;
	private int numOfHits;
	public static final int BLANK = 0;
	
	
	/* Creates the board and initializes all coordinates to "BLANK".
	 * Assume that the biggest size of game board is 40 * 40, it is much bigger than
	 * 10 * 10, this is because I just want to be sure that all ships can be located on
	 * the board, even if some ships are too big.
	 */
	public BattleshipBoard(int width, int height) {
		if (width < 0 || width > 40) {
			width = 40;
		}
		if (height < 0 || height > 40) {
			height = 40;
		}
		this.mapWidth = width;
		this.mapHeight = height;
		mapBoard = new int [mapHeight] [mapWidth];
		
		for (int i = 0; i < mapHeight ; i++) {
			for (int j = 0 ; j < mapWidth ; j++) {
				mapBoard [i][j] = BLANK;
			}
		}
		shipSize = 0;
		numOfHits = 0;
		// For testing the size of board.
		System.out.println("Board size (Height * Width) " + height + ", " + width); 
		
	}
	
	// PlaceShip: places the ship at specified coordinate.
}
