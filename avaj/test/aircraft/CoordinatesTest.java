package avaj.test.aircraft;

import junit.framework.TestCase;
import avaj.main.aircraft.Coordinates;
import avaj.test.mock.MockCoordinates;

public class CoordinatesTest extends TestCase {
	public void testGetter() {
		Coordinates coords = new MockCoordinates(1,2,3);
		assertTrue(1 == coords.getLongitude());
		assertTrue(2 == coords.getLatitude());
		assertTrue(3 == coords.getHeight());
	}
}

