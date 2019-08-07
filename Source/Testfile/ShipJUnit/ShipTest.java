package battleship.ship;

import static org.junit.Assert.*;

import org.junit.Test;

import battleship.services.Locations;

public class ShipTest {

	@Test
	public void testConstructorShip1() {
		Ship testShip = new Ship(3, "Ship1");
		assertNotNull(testShip);
		assertEquals("Since the argument passed was integer of 3, ship health must be 3.", 3, testShip.getShipHealth());
		assertEquals("Since the argument passed was integer of 3, ship size must be 3.", 3, testShip.getShipSize());
		assertEquals("Since the argument passed was String of 'Ship1', ship name must be 'Ship1'", "Ship1", testShip.getShipName());
		
		int xCoord = testShip.getStartXCoord();
		int yCoord = testShip.getStartYCoord();
		int direction = testShip.getDirection();
		assertNotNull("The ship must have a starting X coordinate.", xCoord);
		assertNotNull("The ship must have a starting Y coordinate.", yCoord);
		assertNotNull("The ship must have a direction set.", direction);
	}
	
	@Test
	public void testConstructorShip2() {
		Ship testShip = new Ship(8, "Ship2");
		assertNotNull(testShip);
		assertEquals("Since the argument passed was integer of 8, ship health must be 8.", 8, testShip.getShipHealth());
		assertEquals("Since the argument passed was integer of 8, ship size must be 8.", 8, testShip.getShipSize());
		assertEquals("Since the argument passed was String of 'Ship2', ship name must be 'Ship2'", "Ship2", testShip.getShipName());
		
		int xCoord = testShip.getStartXCoord();
		int yCoord = testShip.getStartYCoord();
		int direction = testShip.getDirection();
		assertNotNull("The ship must have a starting X coordinate.", xCoord);
		assertNotNull("The ship must have a starting Y coordinate.", yCoord);
		assertNotNull("The ship must have a direction set.", direction);
	}

	@Test
	public void testGetterHealth() {
		Ship testShip = new Ship(3, "Ship1");
		assertEquals(3, testShip.getShipHealth());
	}
	
	@Test
	public void testGetterSize() {
		Ship testShip = new Ship(3, "Ship1");
		assertEquals(3, testShip.getShipSize());
	}
	
	@Test
	public void testGetterName() {
		Ship testShip = new Ship(3, "Ship1");
		assertEquals("Ship1", testShip.getShipName());
	}
	
	@Test
	public void testDamageShip() {
		Ship testShip = new Ship(3, "Ship1");
		assertEquals(3, testShip.getShipHealth());
		testShip.damageShip();
		assertEquals("After damaging the ship, health must have gone down by 1 point.", 2, testShip.getShipHealth());
		assertEquals("After damaging the ship, size should not be affected.", 3, testShip.getShipSize());
	}
	
	@Test
	public void testSetterAndGetterDirection() {
		Ship testShip = new Ship(3, "Ship1");
		int direction = testShip.getDirection();
		assertNotNull("The ship must have a direction set.", direction);
		
		testShip.setDirection(3);
		assertEquals("After the setter method, the ship's location must now be 3.", 3, testShip.getDirection());
	}
	
	@Test
	public void testSetterAndGetterLocation() {
		Ship testShip = new Ship(3, "Ship1");
		assertNotNull("The ship must have a location set.", testShip.getLocation());
		
		Object[] oldLocation = testShip.getLocation();
		int direction = testShip.getDirection();
		
		//Changes the ship's direction to something other than the one it is currently facing.
		if (direction == 3) {
			direction = 0;
		} else {
			direction += 1;
		}
		
		testShip.setDirection(direction);
		
		//Calculates a new location for the ship based on the new direction.
		Locations testLocations = new Locations();
		testLocations.calculateLocation(testShip);
		
		assertNotSame("The old location and the new location must be different after calculating the new location.", oldLocation, testShip.getLocation());
	}
	
}
