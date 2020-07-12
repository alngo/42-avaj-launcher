package avaj.test.simulator;

import junit.framework.TestCase;
import avaj.main.simulator.WeatherTower;
import avaj.main.aircraft.Coordinates;
import avaj.test.mock.MockCoordinates;

public class WeatherTowerTest extends TestCase {
	public void testCurrentWeather() {
		WeatherTower tower = new WeatherTower();
		Coordinates coords = new MockCoordinates(1, 2, 3);
		String weather = tower.getWeather(coords);
		assertTrue("SUN".equals(weather));
	}
}
