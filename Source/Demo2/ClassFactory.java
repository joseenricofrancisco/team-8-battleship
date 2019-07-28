
/**ClassFactory class: This is the class for storing the instances from other classes except the Main class for GUI. In the Main class, we can get any instances from any other classes
 * in this program from this class.
 * @author Peisong Yang
 *
 */
public class ClassFactory {
	
	private static final ClassFactory FACTORY = new ClassFactory();
	
	private static Board boardInstance;
	private static ConfirmDirection confirmDirectionInstance;
	private static Locations locationInstance;
	
	static {
		boardInstance = Board.getBoardInstance();
		confirmDirectionInstance = new ConfirmDirection();
		locationInstance = new Locations();
	}
	
	
	private ClassFactory() {};

	public static ClassFactory getFactory() {
		return FACTORY;
	}

	
	public static Board getBoardInstance() {
		return boardInstance;
	}

	public static ConfirmDirection getConfirmDirectionInstance() {
		return confirmDirectionInstance;
	}

	public static Locations getLocationInstance() {
		return locationInstance;
	}
}
