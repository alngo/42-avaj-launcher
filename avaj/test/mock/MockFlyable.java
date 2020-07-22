package avaj.test.mock;

import avaj.main.aircraft.Flyable;
import avaj.main.aircraft.Aircraft;
import avaj.main.simulator.WeatherTower;
import avaj.main.aircraft.Coordinates;

public class MockFlyable extends Aircraft implements Flyable {
	MockFlyable(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateCondition() {
		return;
	};

	public void registerTower(WeatherTower weatherTower) {
		return;
	};
}
