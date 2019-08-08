package battleship.services;
/**
 * This is the interface which get Target coordinate(x,y). Implementing this interface. This can let back server program get target(x,y).
 * @author Peisong Yang
 *
 */
@FunctionalInterface
public interface ITarget {
	/**
	 * Get the target of the player
	 * @return Integer[]
	 */
	Integer[] getTarget();
}
