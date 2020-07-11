package avaj.main;

import avaj.main.simulator.Simulator;

public class App {
	public static void main(String[] args) {
		Simulator simulator;
		String filename;

		if (!isArgumentValid(args)) {
			printUsage();
			return;
		}

		try {
			filename = args[0];
			simulator = new Simulator(filename);
			simulator.run();
			// simulator.saveLogs();
			simulator.printLogs();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static boolean isArgumentValid(String[] args) {
		return (args.length == 1);
	}

	private static void printUsage() {
		System.out.println("Usage: java avaj.main.app.Simulator <simulation_file>");
	}
}
