package avaj.main.simulator;

import avaj.main.aircraft.Coordinates;
import avaj.main.weather.WeatherProvider;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates coordinates) {
		WeatherProvider provider;

		provider = WeatherProvider.getWeatherProvider();
		return provider.getCurrentWeather(coordinates);
	}

	protected void changeWeather() {
		this.conditionsChanged();
	}
}
