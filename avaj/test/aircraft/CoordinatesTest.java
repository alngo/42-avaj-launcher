package avaj.test.aircraft;

import junit.framework.TestCase;
import avaj.main.aircraft.Coordinates;
import avaj.test.mock.MockCoordinates;

public class CoordinatesTest extends TestCase {
    public void testGetLongitude() {
        Coordinates coords = new MockCoordinates(1, 2, 3);
        assertTrue(1 == coords.getLongitude());
    }

    public void testGetLatitude() {
        Coordinates coords = new MockCoordinates(1, 2, 3);
        assertTrue(2 == coords.getLatitude());
    }

    public void testGetHeight() {
        Coordinates coords = new MockCoordinates(1, 2, 3);
        assertTrue(3 == coords.getHeight());
    }
}
