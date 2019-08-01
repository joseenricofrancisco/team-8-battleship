import java.util.Arrays;
import java.util.Scanner;

/**This is the test class, this class is for testing the programs for demo1. The game board's size is 10 * 10. There will be a ship which its size is 4 and its health is 2. The
 * ship's location on the board is random, for the testing, its location will be printed out on the console. Then, we need to input the coordinates, the code will judge if we input
 * the right coordinates. If we input the right coordinates, the ship will lose its health, and the console will print out "HIT!!!". However, if we can't input the right coordinates, the
 * console will print out "Miss!!!". 
 * @author Peisong Yang
 *
 */
public class Start {
	private static final int LEFT = 0;
	private static final int UP = 1;
	private static final int RIGHT = 2;
	private static final int DOWN = 3;
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		Board board = new Board(10, 10);
		System.out.println("Board size : "+ board.getMapWidth() + " x " + board.getMapHeight());
		
		Ship ship = new Ship(2,4,"Test");
		
		int shipSize = ship.getShipSize();
		
		PlaceShip placeShip = new PlaceShip(board.getMapWidth(),board.getMapHeight(),shipSize);
		
		boolean[] availableDirections = placeShip.getAvailableDirection(board.getMapWidth(), board.getMapHeight(), shipSize);
		
		System.out.println(Arrays.toString(availableDirections));
		
		int finalDirection;
		
		while(true) {
			int index = (int)(Math.random()*4);
			System.out.println("oriIndex : " + index);
			if(availableDirections[index]==true) {
				finalDirection=index;
				break;
			}
		}
		
		int startXCoord = placeShip.getStartXCoord();
		int startYCoord = placeShip.getStartYCoord();
		
		System.out.println("Start Point : " + startXCoord + "," + startYCoord);
		
		Object[] location = new Object[2];
		
		switch(finalDirection){
			case LEFT :
				
				int leftStartOfX = startXCoord;
				int leftFixedY= startYCoord;
				
				int[] leftPointsOfX =  new int[shipSize];
				for(int i = 0 ; i< leftPointsOfX.length ; i++) {
					leftPointsOfX[i]=leftStartOfX--;
				}
				
				location[0]=leftPointsOfX;
				location[1]=leftFixedY;
				
				break;
				
			case UP :
				int upFixedX = startXCoord;
				int upStartOfY = startYCoord;
				
				int[] upPointsOfY =  new int[shipSize];
				for(int i = 0;i<upPointsOfY.length;i++) {
					upPointsOfY[i]=upStartOfY++;
				}
				
				location[0]=upFixedX;
				location[1]=upPointsOfY;
				
				break;
				
			case RIGHT :
				
				int rightStartOfX = startXCoord;
				int rightFixedY= startYCoord;
				
				int[] rightPointsOfX =  new int[shipSize];
				for(int i = 0 ; i< rightPointsOfX.length ; i++) {
					rightPointsOfX[i]=rightStartOfX++;
				}
				
				location[0]=rightPointsOfX;
				location[1]=rightFixedY;
				
				break;
				
			case DOWN :
				
				int downFixedX = startXCoord;
				int downStartOfY = startYCoord;
				
				int[] downPointsOfY =  new int[shipSize];
				for(int i = 0;i<downPointsOfY.length;i++) {
					downPointsOfY[i]=downStartOfY--;
				}
				
				location[0]=downFixedX;
				location[1]=downPointsOfY;
				
				break;
		}
		
		System.out.println("finalDirection : " + finalDirection);
		
		if(location[0] == null || location[1] == null) {
			
			throw new RuntimeException("AssigningLocationException");
			
		}
		
		if(location[0] instanceof int[]) {
			
			int[] XPoints = (int[])location[0];
			for (int i = 0; i < XPoints.length; i++) {
				System.out.println("Marking Coord: x = " + XPoints[i] + " y = " + location[1]);
			}
			
		}else if(location[0] instanceof Integer) {
			
			int fixedX =(int)location[0];
			int[] YPoints = (int[])location[1];
			for (int i = 0; i < YPoints.length; i++) {
				System.out.println("Marking Coord: x = " + fixedX + " y = " + YPoints[i]);
			}
			
		}
		
		
		while(true) {
			int targetX = 0;
			int targetY = 0;
			
			while(true) {
				System.out.print("Please enter the x coordinate <'Q' to quit> : ");
				
				String lineX = scan.nextLine();
				
				if(lineX.equals("Q"))
					return;
				
				if(lineX.matches("\\D*")) {
					continue;
				}
				
				int x = Integer.parseInt(lineX);
				
				if(x>board.getMapWidth()||x<0) {
					System.err.println("x = " + x);
					System.err.println("Value out of range, please enter in a number again");
					continue;
				}else {
					targetX = x;
					break;
				}
			}
			
			while(true) {
				System.out.print("Please enter the y coordinate <'Q' to quit> : ");
				
				String lineY = scan.nextLine();
				
				if(lineY.equals("Q"))
					return;
				
				if(lineY.matches("\\D*")) {
					continue;
				}
				
				int y = Integer.parseInt(lineY);
				
				if(y>board.getMapWidth()||y<0) {
					System.err.println("y = " + y);
					System.err.println("Value out of range, please enter in a number again");
					continue;
				}else {
					targetY = y;
					break;
				}
			}
			
			System.out.println("Target : x : " + targetX + " y : " + targetY);
			
			if(location[0] instanceof int[]) {
				if(targetY==(int)location[1]) {
					int[] xOptions = (int[])location[0];
					for (int i = 0; i < xOptions.length; i++) {
						if(targetX==xOptions[i]) {
							System.out.println("HIT!!!");
							ship.damageShip();
							break;
						}else if(i>=xOptions.length-1){
							System.out.println("Miss!!!");
						}
					}
				}else {
					System.out.println("Miss!!!");
				}
				
			}else if(location[0] instanceof Integer) {
				
				if(targetX==(int)location[0]) {
					int[] yOptions = (int[])location[1];
					for (int i = 0; i < yOptions.length; i++) {
						if(targetY==yOptions[i]) {
							System.out.println("HIT!!!");
							ship.damageShip();
							break;
						}else if(i>=yOptions.length-1){
							System.out.println("Miss!!!");
						}
					}
				}else {
					System.out.println("Miss!!!");
				}
				
			}
			
			if(ship.getShipHealth()<=0) {
				System.out.println("The ship "+ ship.getShipName() +" is damaged");
				return;
			}
		}
	}

}
