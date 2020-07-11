package avaj.main.weather;

import avaj.main.aircraft.Coordinates;

public class WeatherProvider {
	private static WeatherProvider weatherProvider;
	private static String[] weather;

	private WeatherProvider() {
		weather = new String[4];
		weather[0] = "RAIN";
		weather[1] = "FOG";
		weather[2] = "SUN";
		weather[3] = "SNOW";
	}

	public static synchronized WeatherProvider getWeatherProvider() {
		if (weatherProvider == null) {
			weatherProvider = new WeatherProvider();
		}
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		Integer seed;

		seed = 0;
		seed += coordinates.getLongitude();
		seed += coordinates.getLatitude();
		seed += coordinates.getHeight();
		return (weather[seed % 4]);
	}
}
