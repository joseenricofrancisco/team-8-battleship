
/**
 * ConfirmDirection class: This class is used to decide which direction that the ship can be located.
 * @author: Peisong Yang
 */
public class ConfirmDirection {
	
	private static final int LEFT = 0;
	private static final int DOWN = 1;
	private static final int RIGHT = 2;
	private static final int UP = 3;
	
	public ConfirmDirection() {}
	
	private boolean[] getAvailableDirection(int startXCoord,int startYCoord,Board board,int shipSize) {
		
//		System.out.println("startLocation : " + startXCoord + " , " + startYCoord);
		
		boolean[] availableDirections = new boolean[4];
		
		if(startXCoord<shipSize) {
			availableDirections[LEFT] = false;
		}else {
			availableDirections[LEFT] = true;
		}
		
		if((board.getMapHeight()-startYCoord)<shipSize) {
			availableDirections[DOWN] = false;
		}else {
			availableDirections[DOWN] = true;
		}
		
		if((board.getMapWidth()-startXCoord)<shipSize) {
			availableDirections[RIGHT] = false;
		}else {
			availableDirections[RIGHT] = true;
		}
		
		if(startYCoord<shipSize) {
			availableDirections[UP] = false;
		}else {
			availableDirections[UP] = true;
		}
//		System.out.println("-------availableDirections:true or false-----------");
//		System.out.println(Arrays.toString(availableDirections));
//		System.out.println("---------------------------------------------------\n");
		
		return availableDirections;
	}
	
	
	public int getFinalDirection(int startXCoord,int startYCoord,int shipSize) {
		int finalDirection;
		
		Board board = ClassFactory.getBoardInstance();
		
		boolean[] availableDirections = getAvailableDirection(startXCoord,startYCoord,board,shipSize);
		
		while(true) {
			int index = (int)(Math.random()*4);
			//System.out.println("oriIndex : " + index);
			if(availableDirections[index]==true) {
				finalDirection=index;
				break;
			}
		}
		
//		System.out.println("-------FinalDirections:1,2,3 and 4 for left,down,right,up----------");
//		System.out.println("FinalDirection : "+ finalDirection);
//		System.out.println("-------------------------------------------------------------------");
		
		return finalDirection;
	}
	
}
