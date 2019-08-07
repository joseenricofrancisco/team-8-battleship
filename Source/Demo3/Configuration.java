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
	
	
	// Get board's width and height.
	public static Integer getMapWidth() {
		return MAPWIDTH;
	}

	public static Integer getMapHeight() {
		return MAPHEIGHT;
	}
	
	// Get the number of ships.
	public static Integer getNumberOfships() {
		return NUMBEROFSHIPS;
	}

}
