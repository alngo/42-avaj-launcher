package avaj.main.simulator;

import java.util.List;
import java.util.ArrayList;
import avaj.main.aircraft.Flyable;

public abstract class Tower {
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
