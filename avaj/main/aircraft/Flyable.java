package avaj.main.aircraft;

import avaj.main.simulator.WeatherTower;

public interface Flyable {
	public void updateCondition();

	public void registerTower(WeatherTower weatherTower);
}
