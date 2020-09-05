package avaj.test.aircraft;

import junit.framework.TestCase;
import avaj.test.mock.MockCoordinates;
import avaj.test.mock.MockWeatherTower;
import avaj.main.aircraft.Flyable;
import avaj.main.aircraft.Aircraft;
import avaj.main.simulator.WeatherTower;

public class HelicopterTest extends TestCase {
    /**
     * Test SUN
     */
    public void shouldIncreaseLongitudeBy10AndHeightBy2() {
        Flyable helicopter = new Helicopter("Test", new MockCoordinates(0, 0, 0));
        WeatherTower weatherTower = new MockWeatherTower("SUN");
        helicopter.registerTower(weatherTower);
        weatherTower.changeWeather();
        Aircraft aircraft = (Aircraft) helicopter;
        assertTrue(aircraft.coordinates.getLongitude() == 10);
        assertTrue(aircraft.coordinates.getLatitude() == 0);
        assertTrue(aircraft.coordinates.getHeight() == 2);
    }

    /**
     * Test RAIN
     */
    public void shouldIncreaseLongitudeBy5() {
        Flyable helicopter = new Helicopter("Test", new MockCoordinates(0, 0, 0));
        WeatherTower weatherTower = new MockWeatherTower("RAIN");
        helicopter.registerTower(weatherTower);
        weatherTower.changeWeather();
        Aircraft aircraft = (Aircraft) helicopter;
        assertTrue(aircraft.coordinates.getLongitude() == 5);
        assertTrue(aircraft.coordinates.getLatitude() == 0);
        assertTrue(aircraft.coordinates.getHeight() == 0);
    }

    /**
     * Test FOG
     */
    public void shouldIncreaseLongitudeBy1() {
        Flyable helicopter = new Helicopter("Test", new MockCoordinates(0, 0, 0));
        WeatherTower weatherTower = new MockWeatherTower("FOG");
        helicopter.registerTower(weatherTower);
        weatherTower.changeWeather();
        Aircraft aircraft = (Aircraft) helicopter;
        assertTrue(aircraft.coordinates.getLongitude() == 1);
        assertTrue(aircraft.coordinates.getLatitude() == 0);
        assertTrue(aircraft.coordinates.getHeight() == 0);
    }

    /**
     * Test SNOW
     */
    public void shouldDecreaseLongitudeBy12() {
        Flyable helicopter = new Helicopter("Test", new MockCoordinates(12, 0, 0));
        WeatherTower weatherTower = new MockWeatherTower("FOG");
        helicopter.registerTower(weatherTower);
        weatherTower.changeWeather();
        Aircraft aircraft = (Aircraft) helicopter;
        assertTrue(aircraft.coordinates.getLongitude() == 0);
        assertTrue(aircraft.coordinates.getLatitude() == 0);
        assertTrue(aircraft.coordinates.getHeight() == 0);
    }
}
