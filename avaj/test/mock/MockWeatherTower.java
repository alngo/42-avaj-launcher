package avaj.test.mock;

import avaj.main.simulator.WeatherTower;
import avaj.main.aircraft.Coordinates;

public class MockWeatherTower extends WeatherTower {
    private String weather;

    public MockWeatherTower(String weather) {
        this.weather = weather;
    }

    @Override
    public String getWeather(Coordinates coordinates) {
        return this.weather;
    }
}
