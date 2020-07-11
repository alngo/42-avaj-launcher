package avaj.main;

public class Simulator {
	public static void main(String[] args) {
		if (!isArgumentValid(args)) {
			printUsage();
			return;
		}
		System.out.println("Hello!");
	}

	private static boolean isArgumentValid(String[] args) {
		if (args.length != 1)
			return false;
		return true;
	}

	private static void printUsage() {
		System.out.println("Usage: java avaj.main.app.Simulator <simulation_file>");
	}
}
