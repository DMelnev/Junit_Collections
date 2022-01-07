import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarMapTest {
    private CarMap map;
    private int count = 1000000;

    @BeforeEach
    void setUp() {
        map = new CarHashMap();
        for (int i = 0; i < count; i++) {
            map.put(new CarOwner(i, "Brand" + i, "lastname"), new Car("Brand" + i, i));
        }
    }

    @Test
    void putSizeRemove() {
        assertEquals(count, map.size(), "after putting 100 objects");
        assertEquals(count, map.keySet().size(), "numbers of values");
        assertEquals(count, map.values().size(), "numbers of keys");
        Car car = new Car("BMW", 12);
        CarOwner owner = new CarOwner(12, "SS" + 12, "lastname");
        map.put(owner, car);
        assertEquals(count + 1, map.size(), "after putting new objects");
        assertEquals(car, map.get(owner), "check present early added article");
        map.remove(owner);
        assertEquals(count, map.size(), "after remove object");
        assertFalse(map.remove(owner), "after remove the same object");
        map.clear();
        assertEquals(0, map.size(), "after clear all objects");
    }

    @Test
    void keySet() {
    }

    @Test
    void values() {
    }

}