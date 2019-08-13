package battleship.gui;
/**This class is used to create the GUI, and run the game. It is the main class of this program.
 * Once we run this class, there will be a game board with 10 * 10 buttons. For testing, the ships' coordinates will be printed on the console.
 * If we or AI press the right button, the button will show an "X", this means we or AI have already hit the ship for once. If we or AI press the wrong button, the button will show an "O", 
 * this means we or AI did not hit the ship. Once we or AI have already damaged all ships, the game will be closed. There are two size 4 ships on the game board for testing, and the ship's
 * health is also 4. The console will tell us who wins this game.
 * @author: Peisong Yang
 */

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import battleship.config.Configuration;
import battleship.controllers.InteractController;
import battleship.ship.Ship;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class GUIStarter extends Application{
	
	//Main function
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("App Started");

		Class.forName("battleship.controllers.ToolsClassController");

		launch(args);
	}
	
	/**
	 * Add information about the ships on the side of the board, this will display information about
	 * the ship last ship that was hit on the board. It will display the ship name and the amount of 
	 * health it has left. It will erase the previous update by overlaying a rectangle with the same 
	 * color of the background over it.
	 * 
	 * @param grid A grid of type GridPane
	 * @param xCoord A x coordinate
	 * @param yCoord A y coordinate
	 * @param HittedShip A ship form created from the ship class
	 */
	public void shipInfo(GridPane grid, int xCoord, int yCoord, Ship HittedShip) {
		Text shipInformation = new Text(); // Will contain information about the ship
		Text update = new Text("     Ship Updates"); // A header for the ship updates
		Rectangle rectangle = new Rectangle(xCoord, yCoord, 150, 20); // this will be used to "erase" the last ship update
		
		update.setFont(Font.font("Impact" , 22));
		update.setFill(Color.CORNFLOWERBLUE);
		update.setStroke(Color.BLACK);
		
		rectangle.setFill(Color.rgb(86, 255, 255)); // set to the same as the background color
		shipInformation.setFont(Font.font("Arial", 13));
		shipInformation.setText("      " + HittedShip.getShipName() + " has been HIT!" +
								"\n      Ship health left: " + HittedShip.getShipHealth()); // Ship information
		
		//Add the all the elements onto the grid
		grid.add(update, xCoord, yCoord - 1); //add the header
		grid.add(rectangle, xCoord, yCoord); //This will cover the text of the last ship update
		grid.add(shipInformation, xCoord, yCoord); // add the new ship information
	}
	
	/**
	 * Add a numbered x and y axis to the a the GUI board
	 * @param grid A grid of type GridPane
	 * @param coord A number to specify where to put the x and y axis on the board
	 */
	public void setBorders(GridPane grid, int coord) {
		// creates the x axis boarder
		for (int i = 1; i < coord; i++) {
			   StringBuilder xBoarder = new StringBuilder();
			   xBoarder.append("   " + i); // add numbers (i) to the StringBuilder
			   Text text = new Text(xBoarder.toString());
			   text.setFont(Font.font ("Trebuchet MS", 22));
			   grid.add(text, i, coord); // add string (xBoarder) to the ith column, on the nth row set by BoarderCoordinate
		   }
		
		// creates the y axis boarder
		for (int j = 1; j < coord; j++) {
			StringBuilder yBoarder = new StringBuilder();
			yBoarder.append("  " + j); // add numbers (j) to the StringBuilder
			Text text = new Text(yBoarder.toString());
			text.setFont(Font.font ("Trebuchet MS", 22));
			grid.add(text, coord, j); // add string (yBoarder) to the nth column set by BoarderCoordinate, on the jth row
		}
	}
	
	/**
	 * The main function for the GUI. It creates a 10x10 grid of buttons for the GUI.
	 * Ships wil be added onto the game board, and create the actions for hitting ships.
	 * If we press the right buttons, the button will show an "X", this means we have already hit the ship.
	 * If we press the wrong buttons, the button will show an "O", this means we did not hit the ship.
	 * Once we have hit all ships, the game will end and the GUI window will close.
	 */
	@Override
	public void start(Stage stage) throws Exception {

		Integer width = Configuration.getMapWidth();
		Integer height = Configuration.getMapHeight();

		InteractController interact = InteractController.getInteractControllerInstance();
		
		Map<Integer[],Ship> ships = interact.getShips();

		Set<Entry<Integer[],Ship>> coordss = ships.entrySet();

		//------------------Empty Buttons---------------------
		GridPane grid = new GridPane();

		grid.setPadding(new Insets(10 , 10, 11, 12));
		grid.setAlignment(Pos.CENTER);
		grid.setStyle("-fx-background-color:#56FFFF"); // set backgrounf color

		// Add the buttons onto the grid
		for(int i = 1;i<=width;i++) {
			for(int j = 1;j<=height;j++) {
				Button button = new Button();
				button.setPrefSize(50, 50);
				
				grid.add(button, i, j);
			}
		}
		
	   /*Adding ships on the game board, and create the actions for hitting ships.
		* If we press the right buttons, the button will show an "X", this means we have already hit the ship.
		* If we press the wrong buttons, the button will show an "O", this means we did not hit the ship.
		* Once we have already hit all ships, the game will be closed.
		*/
		//-------------------Action adding--------------------
		int num = 0;
		ObservableList<Node> children = grid.getChildren();

		for(Node node : children) {

			Button button = (Button)node;
			
			//Y coord value of this button
			Integer coordY = GridPane.getRowIndex(node).intValue();
			
			//X coord value of this button
			Integer coordX = GridPane.getColumnIndex(node).intValue();
			
			for(Entry<Integer[], Ship> entry : coordss) {

				Integer[] coord = entry.getKey();
				System.out.println(Arrays.toString(coord));

				//loop counter(display how many loops it has executed)
				num=num+1;
				
				if(coordY==coord[1] && coordX==coord[0]) {
					//If the chosen coordinate had a ship, then set the buttion text to "X"
					button.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							Ship HittedShip = entry.getValue();
							shipInfo(grid, 12, 3, HittedShip);
							button.setText("X"); // Set buttion text to "Y"
							HittedShip.damageShip(); // Deduct 1 health when the ship has been hit
							
							int playerOrAI = interact.getAIController().getCount();
							interact.getGameoverController().judgeGameover(HittedShip,playerOrAI); // Check whether or not it is game over
							interact.getAIController().execute(coordX+","+coordY); //give the AI their turn
						}
					});
					break;
				}else {
					// If the chosen coordinate was an empty space, then set the button to "O"
					button.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							button.setText("O"); //set button text to "O" when missed
							interact.getAIController().execute(coordX+","+coordY); // Give the Ai their turn
						}

					});
				}
			}
		}
		
		System.out.println();
		System.out.println();
		
		for(Node node : children) {
			interact.getAIController().add(GridPane.getColumnIndex(node).intValue() +","+ GridPane.getRowIndex(node).intValue(),node);
		}
		
		setBorders(grid, 11); // add the boarders 
		
		//Show the GUI.
		Scene scene = new Scene(grid, 800, 600);
		stage.setTitle("BattleShip");
		stage.setScene(scene);

		stage.show();
	}
}
