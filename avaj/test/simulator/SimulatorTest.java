package avaj.test.simulator;

import junit.framework.TestCase;
import avaj.main.simulator.Simulator;

public class SimulatorTest extends TestCase {
	private String directory = System.getProperty("user.dir") + "/public/scenarios";

	public void testRunInvalidFile() {
		Simulator simulator = new Simulator(directory + "/invalid.txt");
		Integer result = simulator.run();
		assertTrue(1 == result);
	}

	public void testRunValidFile() {
		Simulator simulator = new Simulator(directory + "/test.txt");
		Integer result = simulator.run();
		assertTrue(0 == result);
	}
}
