package avaj.test.simulator;

import junit.framework.TestCase;
import java.util.List;
import avaj.main.simulator.Document;

public class DocumentTest extends TestCase {
	private String directory = System.getProperty("user.dir") + "/public/scenarios";

	public void testCounterFileNotFound() {
		Document document = new Document("filenotfound");
		Integer cycle = document.getCycle();
		assertTrue(-1 == cycle);
	}

	public void testCounterEmptyFile() {
		Document document = new Document(directory + "/empty.txt");
		Integer cycle = document.getCycle();
		assertTrue(-1 == cycle);
	}

	public void testCounterErrorFile() {
		Document document = new Document(directory + "/error.txt");
		Integer cycle = document.getCycle();
		assertTrue(-1 == cycle);
	}

	public void testCounterInvalidFile() {
		Document document = new Document(directory + "/invalid.txt");
		Integer cycle = document.getCycle();
		assertTrue(-42 == cycle);
	}

	public void testCounterValidFile() {
		Document document = new Document(directory + "/test.txt");
		Integer cycle = document.getCycle();
		assertTrue(42 == cycle);
	}

	public void testAircraftFileNotFound() {
		Document document = new Document("filenotfound");
		List<String[]> aircrafts = document.getAircrafts();
		assertTrue(null == aircrafts);
	}

	public void testAircraftEmptyFile() {
		Document document = new Document(directory + "/empty.txt");
		List<String[]> aircrafts = document.getAircrafts();
		assertTrue(null == aircrafts);
	}

	public void testAircraftErrorFile() {
		Document document = new Document(directory + "/error.txt");
		List<String[]> aircrafts = document.getAircrafts();
		assertTrue(aircrafts.size() == 0);
	}

	public void testAircraftInvalidFile() {
		Document document = new Document(directory + "/invalid.txt");
		List<String[]> aircrafts = document.getAircrafts();
		assertTrue(aircrafts.size() == 0);
	}

	public void testAircraftValidFile() {
		Document document = new Document(directory + "/test.txt");
		List<String[]> aircrafts = document.getAircrafts();
		assertTrue(aircrafts.size() == 1);
	}
}
