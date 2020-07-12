package avaj.test.simulator;

import junit.framework.TestCase;
import avaj.main.aircraft.Flyable;
import avaj.test.mock.MockFlyable;
import avaj.test.mock.MockTower;

public class TowerTest extends TestCase {
	public void testRegister() {
		MockTower tower = new MockTower();
		Flyable aircraft1 = new MockFlyable();
		Flyable aircraft2 = new MockFlyable();
		Flyable aircraft3 = new MockFlyable();
		tower.register(aircraft1);
		assertTrue(1 == tower.observers.size());
		tower.register(aircraft2);
		assertTrue(2 == tower.observers.size());
		tower.register(aircraft3);
		assertTrue(3 == tower.observers.size());
	}

	public void testUnregister() {
		MockTower tower = new MockTower();
		Flyable aircraft1 = new MockFlyable();
		Flyable aircraft2 = new MockFlyable();
		tower.register(aircraft1);
		assertTrue(1 == tower.observers.size());
		tower.register(aircraft2);
		assertTrue(2 == tower.observers.size());
		tower.unregister(aircraft2);
		assertTrue(1 == tower.observers.size());
	}
}
