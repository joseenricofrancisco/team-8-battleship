package battleship.services;
/**
 * This class is used to parse the coordinates of ship's location for GUI.
 * @author Peisong Yang
 *
 */
public class ParseToCoords {

	public Integer[][] getCoords(Object[] shipLocation,int size){
		// Create a 2D array for storing ship's coordinates with direction.
		Integer[][] coords = new Integer[size][2];
		//Storing ship's coordinates.
		if(shipLocation[0] instanceof int[]) {
			int[] Xs = (int[])shipLocation[0];
			int Y = (int)shipLocation[1];
			for (int i = 0; i < Xs.length; i++) {
				coords[i][0] = Xs[i];
				coords[i][1] = Y;
			}
		}else if(shipLocation[0] instanceof Integer) {
			int X = (int)shipLocation[0];
			int[] Ys = (int[])shipLocation[1];
			for (int i = 0; i < Ys.length; i++) {
				coords[i][0] = X;
				coords[i][1] = Ys[i];
			}
		}	
		return coords;
	}
}
