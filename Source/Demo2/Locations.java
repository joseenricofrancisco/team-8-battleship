/**
 * Locations class: This class is used to get ship's coordinates on the game board.
 * @author Peisong Yang
 *
 */
public class Locations {
	
	private static final int LEFT = 0;
	private static final int DOWN = 1;
	private static final int RIGHT = 2;
	private static final int UP = 3;

	public Object[] getLocation(Ship ship) {
		Object[] location = new Object[2];
		
		switch(ship.getDirection()){
		case LEFT :
			
			int leftStartOfX = ship.getStartXCoord();
			int leftFixedY= ship.getStartYCoord();
			
			int[] leftPointsOfX =  new int[ship.getShipSize()];
			for(int i = 0 ; i< leftPointsOfX.length ; i++) {
				leftPointsOfX[i]=leftStartOfX--;
			}
			
			location[0]=leftPointsOfX;
			location[1]=leftFixedY;
			
			break;
			
		case DOWN :
			
			int downFixedX = ship.getStartXCoord();
			int downStartOfY = ship.getStartYCoord();
			
			int[] downPointsOfY =  new int[ship.getShipSize()];
			for(int i = 0;i<downPointsOfY.length;i++) {
				downPointsOfY[i]=downStartOfY++;
			}
			
			location[0]=downFixedX;
			location[1]=downPointsOfY;
			
			break;
			
		case RIGHT :
			
			int rightStartOfX = ship.getStartXCoord();
			int rightFixedY= ship.getStartYCoord();
			
			int[] rightPointsOfX =  new int[ship.getShipSize()];
			for(int i = 0 ; i< rightPointsOfX.length ; i++) {
				rightPointsOfX[i]=rightStartOfX++;
			}
			
			location[0]=rightPointsOfX;
			location[1]=rightFixedY;
			
			break;
			
		case UP :
		
			int upFixedX = ship.getStartXCoord();
			int upStartOfY = ship.getStartYCoord();
			
			int[] upPointsOfY =  new int[ship.getShipSize()];
			for(int i = 0;i<upPointsOfY.length;i++) {
				upPointsOfY[i]=upStartOfY--;
			}
			
			location[0]=upFixedX;
			location[1]=upPointsOfY;
			
			break;
	}
		
		return location;
		
	}
}
