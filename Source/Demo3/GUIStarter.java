package battleship.gui;
/**This class is used to create the GUI, and run the game. It is the main class of this program.
 * Once we run this class, there will be a game board with 10 * 10 buttons. For testing, the ships' coordinates will be printed on the console.
 * If we press the right button, the button will show an "X", this means we have already hit the ship. If we press the wrong button, the button will show an "O", 
 * this means we did not hit the ship. Once we have already hit all ships, the game will be closed. There are two size 4 ships on the game board for testing, and the ship's
 * health is also 4.
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
import javafx.stage.Stage;

public class GUIStarter extends Application{
	/**
	 * Create the GUI with buttons.
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

		grid.setPadding(new Insets(10,10,10,10));
		grid.setAlignment(Pos.CENTER);
		grid.setStyle("-fx-background-color:#56FFFF");

		for(int i = 1;i<=width;i++) {
			for(int j = 1;j<=height;j++) {
				Button button = new Button();
				button.setPrefSize(50, 50);
				grid.add(button, i, j);
			}
		}
		//Adding ships on the game board, and create the actions for hitting ships.
		//If we press the right buttons, the button will show an "X", this means we have already hit the ship.
		//If we press the wrong buttons, the button will show an "O", this means we did not hit the ship.
		//Once we have already hit all ships, the game will be closed.
		//-------------------Action adding--------------------
		ObservableList<Node> children = grid.getChildren();

		for(Node node : children) {

			for(Entry<Integer[], Ship> entry : coordss) {

				Integer[] coord = entry.getKey();
				System.out.println(Arrays.toString(coord));

				if(GridPane.getRowIndex(node).intValue()==coord[1] && GridPane.getColumnIndex(node).intValue()==coord[0]) {

					Button button = (Button)node;

					button.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							button.setText("X");
							entry.getValue().damageShip();
							interact.getGameoverController().judgeGameover(entry.getValue());
						}

					});
					break;
				}else {
					Button button = (Button)node;

					button.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							button.setText("O");
						}

					});
				}
			}
		}
		
		//Show the GUI.
		Scene scene = new Scene(grid,500,500);
		stage.setTitle("BattleShip");
		stage.setScene(scene);
		stage.show();
	}
	
	//Main function
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("App Started");

		Class.forName("battleship.controllers.ToolsClassController");

		launch(args);
	}
}
