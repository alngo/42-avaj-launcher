package avaj.test.simulator;

import java.lang.reflect.Field;
import junit.framework.TestCase;
import java.util.List;
import java.util.ArrayList;
import avaj.main.aircraft.Flyable;
import avaj.test.mock.MockFlyable;
import avaj.test.mock.MockTower;
import avaj.test.mock.MockCoordinates;

public class TowerTest extends TestCase {
    public void testRegister() {
        List<Flyable> lst;
        MockTower tower = new MockTower();
        Flyable aircraft1 = new MockFlyable("Test", new MockCoordinates(1, 2, 3));
        tower.register(aircraft1);
        lst = reflectObservers(tower);
        assertTrue(1 == lst.size());
    }

    public void testUnregister() {
        List<Flyable> lst;
        MockTower tower = new MockTower();
        Flyable aircraft1 = new MockFlyable("Test", new MockCoordinates(1, 2, 3));
        tower.register(aircraft1);
        lst = reflectObservers(tower);
        assertTrue(1 == lst.size());
        tower.unregister(aircraft1);
        lst = reflectObservers(tower);
        assertTrue(0 == lst.size());
    }

    private List<Flyable> reflectObservers(MockTower tower) {
        List<Flyable> value;
        value = null;
        try {
            Field field = tower.getClass().getDeclaredField("observers");
            field.setAccessible(true);
            value = (List<Flyable>) field.get(tower);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
