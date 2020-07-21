package avaj.test.mock;

import avaj.main.simulator.Tower;
import avaj.main.aircraft.Flyable;
import java.util.List;
import java.util.ArrayList;

public class MockTower extends Tower {
	private List<Flyable> observers;

	public void register(Flyable flyable) {
		if (observers == null) {
			observers = new ArrayList<Flyable>();
		}
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		if (observers != null) {
			observers.remove(flyable);
		}
	}

	protected void conditionsChanged() {
		if (observers != null) {
			for (Flyable flyable : observers) {
				flyable.updateCondition();
			}
		}
	}
}
