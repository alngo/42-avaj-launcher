package avaj.test.weather;

import junit.framework.TestCase;
import avaj.main.weather.WeatherProvider;
import avaj.main.aircraft.Coordinates;
import avaj.test.mock.MockCoordinates;


public class WeatherProviderTest extends TestCase {
	public void testContructor() {
		WeatherProvider provider = WeatherProvider.getWeatherProvider();
		assertTrue(provider != null);
	}

	public void testCurrentWeather() {
		WeatherProvider provider = WeatherProvider.getWeatherProvider();
		Coordinates coords = new MockCoordinates(1,2,3);
		String weather = provider.getCurrentWeather(coords);
		assertTrue("SUN" == weather);
	}
}
