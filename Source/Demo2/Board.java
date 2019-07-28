
/**Board class: it is the class for the game board, a fundamental class of the game program.
 * @author: Peisong Yang
 */
public class Board {
	private int mapWidth;
	private int mapHeight;
	
	private static Board instance = new Board();
	
	/*Constructor: Assume that the biggest size of game board is 10 * 10, if the board size is bigger than 10 * 10 or smaller than 0 * 0,
	 *then set it as a default size 10 * 10.
	 */
	private Board() {}
	
//	private Board() {
//		
//	}
	
	public static Board getBoardInstance() {
		return instance;
	}
	
	//The getter and setter method for getting the values of board's width and height.
	public int getMapWidth() {
		return mapWidth;
	}
	public int getMapHeight() {
		return mapHeight;
	}
	public void setMapWidth(int width) {
		if ( width < 0 || width > 10) {
			width = 10;
		}
		this.mapWidth = width;
	}
	public void setMapHeight(int height) {
		if ( height < 0 || height > 10) {
			height = 10;
		}
		this.mapHeight = height;
	}
}
