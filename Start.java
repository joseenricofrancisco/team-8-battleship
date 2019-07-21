import java.util.ArrayList;
import java.util.Scanner;

/**This is the start class for Demo1.
 * @author Peisong Yang
 *
 */
public class Start {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Board board = new Board(10, 10);
		System.out.println("Board size : "+ board.getMapWidth() + "x" + board.getMapHeight());
		
		int lengthOfShip = 4;
		
		PlaceShip placeShip = new PlaceShip(board.getMapWidth(),board.getMapHeight(),lengthOfShip);
		ArrayList<Boolean> availableDirections = placeShip.getAvailableDirection(board.getMapWidth(), board.getMapHeight(), lengthOfShip);
		int[] freeCoord = new int[lengthOfShip];
		int finalDirection;
		
		while(true) {
			int index = (int)Math.random()*4+1;
			if(availableDirections.get(index)==true) {
				finalDirection=index;
				break;
			}
		}
		
		int startXCoord = 0;
		int startYCoord = 0;
		switch(finalDirection){
			case 1 :
				startXCoord = placeShip.getStartXCoord();
				startYCoord = placeShip.getStartYCoord();
				for(int i = 0;i<freeCoord.length;i++) {
					freeCoord[i]=startXCoord--;
				}
				break;
			case 2 :
				startXCoord = placeShip.getStartXCoord();
				startYCoord = placeShip.getStartYCoord();
				for(int i = 0;i<freeCoord.length;i++) {
					freeCoord[i]=startYCoord++;
				}
				break;
			case 3 :
				startXCoord = placeShip.getStartXCoord();
				startYCoord = placeShip.getStartYCoord();
				for(int i = 0;i<freeCoord.length;i++) {
					freeCoord[i]=startXCoord++;
				}
				break;
			case 4 :
				startXCoord = placeShip.getStartXCoord();
				startYCoord = placeShip.getStartYCoord();
				for(int i = 0;i<freeCoord.length;i++) {
					freeCoord[i]=startYCoord--;
				}
				break;
		}
		
		if(finalDirection==1||finalDirection==3) {
			for (int i = 0; i < freeCoord.length; i++) {
				System.out.println("Marking Coord: x = " + freeCoord[i] + " y = " + startYCoord);
			}
		}else if(finalDirection==2||finalDirection==4) {
			for (int i = 0; i < freeCoord.length; i++) {
				System.out.println("Marking Coord: x = " + startXCoord + " y = " + freeCoord[i]);
			}
		}
		
//		while(true) {
//			System.out.print("Please enter the x coordinate <'Q' to quit> :");
//			int x = Integer.parseInt(scan.nextLine());
//			System.out.print("Please enter the y coordinate <'Q' to quit> :");
//			int y = Integer.parseInt(scan.nextLine());
//			if()
//		}
	}

}
