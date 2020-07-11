package avaj.main.simulator;

import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Simulator {
	public String filename;
	public List<String> logs;
	private Document document;
	private WeatherTower tower;

	public Simulator(String arg) {
		filename = arg;
		document = new Document(filename);
		tower = new WeatherTower();
	}

	public Integer run() {
		Integer cycle;
		List<String[]> aircrafts;

		cycle = document.getCycle();
		aircrafts = document.getAircrafts();
		logs = new ArrayList<String>();
		if (cycle < 0 || aircrafts.size() == 0)
			return 1;
		while (cycle > 0) {
			tower.changeWeather();
			cycle--;
		}
		return 0;
	}

	public Integer saveLogs(String filename) {
		try {
			FileWriter file = new FileWriter(filename);
			for (String log : logs) {
				file.write(log);
			}
			file.close();
			return 0;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return 1;
	}

	public void printLogs() {
		for (String log : logs) {
			System.out.println(log);
		}
	}
}
