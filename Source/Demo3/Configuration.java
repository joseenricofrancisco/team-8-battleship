package battleship.config;
/**
 * Configuration class is used to create the game board and set the ships on the game board.
 * @author Peisong Yang
 *
 */
public class Configuration {
	// Set game board to 10 * 10. Set two ships on the board, and set ship's size to 4.
	public final static Integer MAPWIDTH = 10;
	public final static Integer MAPHEIGHT = 10;
	public final static Integer NUMBEROFSHIPS = 2;
	public final static Integer SHIPSIZE = 4;
	
	
	/**
	 * Gets the the width of the board.
	 * @return MAPWIDTH the width of the board.
	 */
	public static Integer getMapWidth() {
		return MAPWIDTH;
	}
	
	/**
	 * Gets the height of the board.
	 * @return MAPHEIGHT the height of the board.
	 */
	public static Integer getMapHeight() {
		return MAPHEIGHT;
	}
	
	/**
	 * Gets the number ships on the board.
	 * @return NUMBEROFSHIPS the number of ships.
	 */
	public static Integer getNumberOfships() {
		return NUMBEROFSHIPS;
	}

}
