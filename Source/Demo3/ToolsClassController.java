package battleship.controllers;
import battleship.services.Locations;
import battleship.services.ParseToCoords;

/**
 * This class is used to judge the actions that player does on the GUI game board.
 * @author Peisong Yang
 *
 */
public class ToolsClassController extends Controller{
	
	private static final ToolsClassController TOOLSCONTROLLER = new ToolsClassController();
	
//	public static final GUIStarter BOARD;
	public static final Locations LOCATIONINSTANCE;
	public static final ParseToCoords PARSETOCOORDS;
	
	// Get the locations and coordinates of ships.
	static {
//		BOARD = GUIStarter.getBoardInstance();
		LOCATIONINSTANCE = new Locations();
		PARSETOCOORDS = new ParseToCoords();
	}
	
	
	private ToolsClassController() {};

	public static ToolsClassController getFactory() {
		return TOOLSCONTROLLER;
	}
}
