/**
 * Main class: This class is used to create a GUI for the game. It is the main class for this program. We start to play the game by running this class.
 * For the Main class, we set a ship for 4 size and 4 health, the ship's name is test1. Once the game begins, the console will print out the ship's locating coordinates (This is for 
 * testing), and there will be a GUI game board which is covered with 10 * 10 buttons.
 * The ship's location on the game board is random, it is the same as we play the game with computer. The computer locates the ship on the game board randomly, and we guess
 * the ship's location. Once we press the button which is included in the ship's locating buttons, the console will print out "HIT!!!", else the console will print out "MISS!!!".
 * Once we have already pressed the ship's locating buttons for four times, the console will print out "The ship XXX has been damaged!", and the GUI will be closed. Then, the whole game
 * is finished.
 * @author Peisong Yang
 */


import java.util.Arrays;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		System.out.println("App Started");
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub

		ClassFactory.getBoardInstance().setMapWidth(10);
		ClassFactory.getBoardInstance().setMapHeight(10);

		int X = ClassFactory.getBoardInstance().getMapWidth(); 
		int Y = ClassFactory.getBoardInstance().getMapHeight();
		//System.out.println("X" + X + "Y" + Y);

		Ship ship1 = new Ship(4,"test1");
		Object[] location = ship1.getLocation();

		int[][] ij = getCoords(location,ship1.getShipSize());

		for(int i = 0;i<ij.length;i++) {
			System.out.println(Arrays.toString(ij[i]));
		}
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setAlignment(Pos.CENTER);
		grid.setStyle("-fx-background-color:#56FFFF");

		for(int i = 1;i<=X;i++) {
			for(int j = 1;j<=Y;j++) {
				Button button = new Button();
				button.setPrefSize(50, 50);
				
				//System.out.println("Button now : " + i + " , " + j);
				
				for(int coord=0;coord<ij.length;coord++) {
					
					//System.out.println(ij[coord][0] + " , " + ij[coord][1]);
					//System.out.println("i: " + (i==ij[coord][0]) + " j: " + (j==ij[coord][1]));
					
					if(i==ij[coord][0] && j==ij[coord][1]) {
						button.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								System.out.println("HIT!!!");
								ship1.damageShip();
								if(ship1.getShipHealth()<=0) {
									System.out.println("The "+ ship1.getShipName() + " has been damaged!");
									System.exit(0);
								}
							}
						});
						
						break;
						
					}else {
						button.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								// TODO Auto-generated method stub
								System.out.println("Miss!!!");
							}
						});
					}
				}
				grid.add(button, i, j);
			}
		}

		//		grid.get

		Scene scene = new Scene(grid, 500, 500); 
		stage.setTitle("BattleShip");
		stage.setScene(scene);

		stage.show();


	}

	private int[][] getCoords(Object[] shipLocation,int size){
		int[][] coords = new int[size][2];
		if(shipLocation[0] instanceof int[]) {
			//			if(targetY==(int)shipLocation[1]) {
			//				int[] xOptions = (int[])shipLocation[0];
			//				for (int i = 0; i < xOptions.length; i++) {
			//					if(targetX==xOptions[i]) {
			//						System.out.println("HIT!!!");
			//						ship.damageShip();
			//						break;
			//					}else if(i>=xOptions.length-1){
			//						System.out.println("Miss!!!");
			//					}
			//				}
			//			}else {
			//				System.out.println("Miss!!!");
			//			}
			int[] Xs = (int[])shipLocation[0];
			int Y = (int)shipLocation[1];
			for (int i = 0; i < Xs.length; i++) {
				coords[i][0] = Xs[i];
				coords[i][1] = Y;
			}

		}else if(shipLocation[0] instanceof Integer) {

			//			if(targetX==(int)shipLocation[0]) {
			//				int[] yOptions = (int[])shipLocation[1];
			//				for (int i = 0; i < yOptions.length; i++) {
			//					if(targetY==yOptions[i]) {
			//						System.out.println("HIT!!!");
			//						ship.damageShip();
			//						break;
			//					}else if(i>=yOptions.length-1){
			//						System.out.println("Miss!!!");
			//					}
			//				}
			//			}else {
			//				System.out.println("Miss!!!");
			//			}

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
