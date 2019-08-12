package battleship.controllers;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 * AIController class is used to set the AI's actions on the game board. It will control AI to randomly choose a button on the game board for each turn.
 * @author Peisong Yang
 */
public class AIController extends Controller{
	
	//Get all buttons in a hash map.
	Map<String, Button> buttons = new HashMap<>();
	
	/**
	 * The variable count is used to count how many times that AI presses the buttons.
	 */
	// Initialize the count to 1.
	int count = 1;
	
	/**
	 * Add AI's pressing actions on the buttons.
	 * @param coord
	 * @param node
	 */
	public void add(String coord,Node node) {
		buttons.put(coord, (Button)node);
	}
	
	/**
	 * Execute AI's actions.
	 * @param overlapCoord
	 */
	public void execute(String overlapCoord) {
		count++;
		
		while ((count%2)==0) {
			String coord = (int) (Math.random() * 10 + 1) + "," + (int) (Math.random() * 10 + 1);
			if (coord.equals(overlapCoord)) {
				continue;
			}
			System.out.println(coord);
			Button button = buttons.get(coord);
			button.fire();
		}
	}
	
	/**
	 * Get the variable count.
	 * @return count
	 */
	public int getCount() {
		return count;
	}
	
}
