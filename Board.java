/**Board class: it is the class for the game board, a fundamental class of the game program.
 * @author: Peisong Yang
 */
public class Board {
	private int mapWidth;
	private int mapHeight;
	
	/*Constructor: Assume that the biggest size of game board is 10 * 10, if the board size is bigger than 10 * 10 or smaller than 0 * 0,
	 *then set it as a default size 10 * 10.
	 */
	public Board(int width, int height) {
		if ( width < 0 || width > 10) {
			width = 10;
		}
		if ( height < 0 || height > 10) {
			height = 10;
		}
		
		setMapWidth(width);
		setMapHeight(height);
	}
	
	//The getter and setter method for getting the values of board's width and height.
	public int getMapWidth() {
		return this.mapWidth;
	}
	public int getMapHeight() {
		return this.mapHeight;
	}
	public void setMapWidth(int width) {
		this.mapWidth = width;
	}
	public void setMapHeight(int height) {
		this.mapHeight = height;
	}
}
