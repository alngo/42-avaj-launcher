package avaj.test.aircraft;

import junit.framework.TestCase;
import avaj.test.mock.MockCoordinates;
import avaj.test.mock.MockWeatherTower;
import avaj.main.aircraft.Flyable;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

import avaj.main.aircraft.Aircraft;
import avaj.main.aircraft.Helicopter;
import avaj.main.simulator.WeatherTower;

public class HelicopterTest extends TestCase {

    public Class<?> reflectCoordinate(Aircraft aircraft) {
        try {
            Class<?> reflectAircraft = aircraft.getClass();
            Field fieldCoordinates = reflectAircraft.getField("coordinates");
            fieldCoordinates.setAccessible(true);
            Class<?> reflectCoordinate = fieldCoordinates.getClass();
            for (Method method : reflectCoordinate.getDeclaredMethods()) {
                method.setAccessible(true);
            }
            for (Field field : reflectCoordinate.getDeclaredFields()) {
                field.setAccessible(true);
            }
            return reflectCoordinate;
        } catch (NoSuchFieldException exception) {
            return null;
        }
    }

    public Integer getValueFromReflect(Class<?> reflect, String methodName) {
        try {
            Method method = reflect.getMethod(methodName);
            return Integer.valueOf((method.invoke(reflect) + ""));
        } catch (NoSuchMethodException exception) {
            System.out.println(exception.getMessage());
            return null;
        } catch (IllegalAccessException exception) {
            System.out.println(exception.getMessage());
            return null;
        } catch (InvocationTargetException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    /**
     * Test SUN
     */
    public void testIncreaseLongitudeBy10AndHeightBy2() {
        Flyable helicopter = new Helicopter("Test", new MockCoordinates(0, 0, 0));
        MockWeatherTower weatherTower = new MockWeatherTower("SUN");
        helicopter.registerTower(weatherTower);
        weatherTower.changeWeather();
        MockCoordinates coords;

        Class<?> reflect = reflectCoordinate((Aircraft) helicopter);
        Integer longitude = getValueFromReflect(reflect, "getLongitude");
        assertTrue(longitude == 10);
        // assertTrue(coordinates.latitude == 0);
        // assertTrue(coordinates.height == 2);
    }

    // /**
    // * Test RAIN
    // */
    // public void shouldIncreaseLongitudeBy5() {
    // Flyable helicopter = new Helicopter("Test", new MockCoordinates(0, 0, 0));
    // MockWeatherTower weatherTower = new MockWeatherTower("RAIN");
    // helicopter.registerTower(weatherTower);
    // weatherTower.changeWeather();
    // Aircraft aircraft = (Aircraft) helicopter;
    // assertTrue(aircraft.coordinates.getLongitude() == 5);
    // assertTrue(aircraft.coordinates.getLatitude() == 0);
    // assertTrue(aircraft.coordinates.getHeight() == 0);
    // }

    // /**
    // * Test FOG
    // */
    // public void shouldIncreaseLongitudeBy1() {
    // Flyable helicopter = new Helicopter("Test", new MockCoordinates(0, 0, 0));
    // MockWeatherTower weatherTower = new MockWeatherTower("FOG");
    // helicopter.registerTower(weatherTower);
    // weatherTower.changeWeather();
    // Aircraft aircraft = (Aircraft) helicopter;
    // assertTrue(aircraft.coordinates.getLongitude() == 1);
    // assertTrue(aircraft.coordinates.getLatitude() == 0);
    // assertTrue(aircraft.coordinates.getHeight() == 0);
    // }

    // /**
    // * Test SNOW
    // */
    // public void shouldDecreaseLongitudeBy12() {
    // Flyable helicopter = new Helicopter("Test", new MockCoordinates(12, 0, 0));
    // MockWeatherTower weatherTower = new MockWeatherTower("FOG");
    // helicopter.registerTower(weatherTower);
    // weatherTower.changeWeather();
    // Aircraft aircraft = (Aircraft) helicopter;
    // assertTrue(aircraft.coordinates.getLongitude() == 0);
    // assertTrue(aircraft.coordinates.getLatitude() == 0);
    // assertTrue(aircraft.coordinates.getHeight() == 0);
    // }
}
