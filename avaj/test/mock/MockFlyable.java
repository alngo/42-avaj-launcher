package avaj.test.mock;

import avaj.main.aircraft.Flyable;
import avaj.main.simulator.WeatherTower;

public class MockFlyable implements Flyable {
	public void updateCondition() {
		return;
	};

	public void registerTower(WeatherTower weatherTower) {
		return;
	};
}
