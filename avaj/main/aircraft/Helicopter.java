package avaj.main.aircraft;

import avaj.main.simulator.WeatherTower;
import avaj.main.aircraft.Coordinates;

// ◦ SUN - Longitude increases with 10, Height increases with 2
// ◦ RAIN - Longitude increases with 5
// ◦ FOG - Longitude increases with 1
// ◦ SNOW - Height decreases with 12
public class Helicopter extends Aircraft implements Flyable {
    WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateCondition() {
        weatherTower.getWeather(super.coordinates);
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}

