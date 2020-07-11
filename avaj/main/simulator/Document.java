package avaj.main.simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

public class Document {
	private List<String> lines;

	public Document(String filename) {
		String line;
		BufferedReader buffer;
		FileReader reader;
		lines = new ArrayList<String>();
		try {
			reader = new FileReader(filename);
			buffer = new BufferedReader(reader);
			while ((line = buffer.readLine()) != null) {
				lines.add(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Method that return a number based on the first document's line
	 *
	 * @return Integer
	 */
	public Integer getCycle() {
		String firstline;
		Integer numberIteration;
		try {
			firstline = lines.get(0);
			numberIteration = Integer.parseInt(firstline);
		} catch (Exception e) {
			return (-1);
		}
		return numberIteration;
	}

	/**
	 * Method that return a List of valid String[5] following the pattern: [TYPE]
	 * [NAME] [LONGITUDE] [LATITUDE] [HEIGHT]
	 *
	 * @return List<String[]>
	 */
	public List<String[]> getAircrafts() {
		List<String[]> aircrafts;
		String[] aircraft;
		List<String> sublines;
		try {
			aircrafts = new ArrayList<String[]>();
			sublines = lines.subList(1, lines.size());
			for (String line : sublines) {
				if ((aircraft = Document.parseAircraft(line)) != null)
					aircrafts.add(aircraft);
			}
		} catch (Exception e) {
			return null;
		}
		return aircrafts;
	}

	/**
	 * Method that return an array[5] or null
	 *
	 * @param line is a string following this pattern
	 * @return an Aircraft or null;
	 */
	public static String[] parseAircraft(String line) {
		String[] splitted;
		splitted = line.split(" ");
		try {
			if (splitted.length != 5)
				throw new IllegalArgumentException("Not a valid aircraft definition");
			Integer.parseInt(splitted[2]);
			Integer.parseInt(splitted[3]);
			Integer.parseInt(splitted[4]);
			return splitted;
		} catch (Exception e) {
			return null;
		}
	}
}
