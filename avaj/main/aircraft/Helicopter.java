package avaj.main.aircraft;

import avaj.main.simulator.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateCondition() {
	}

	public void registerTower(WeatherTower weatherTower) {
	}
}
