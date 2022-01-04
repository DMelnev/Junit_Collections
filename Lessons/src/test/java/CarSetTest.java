import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarSetTest {
    private CarSet carSet;

    @BeforeEach
    void setUp() {
        carSet = new CarHashSet();
        for (int i = 0; i < 100; i++) {
            carSet.add(new Car("Brand" + i, i));
        }
    }

    @Test
    void clear() {
        assertEquals(100, carSet.size(), "test size");
        carSet.clear();
        assertEquals(0, carSet.size(), "test clear");
    }

    @Test
    void add() {
        Car car = new Car("Toyota", 12);
        assertTrue(carSet.add(car), "add new object");
        assertEquals(101, carSet.size(), "after add new object");
        assertFalse(carSet.add(car), "add same object");
        assertEquals(101, carSet.size(), "after add the same object");
    }

    @Test
    void remove() {
        Car car = new Car("Toyota", 12);
        assertTrue(carSet.add(car), "add new object");
        assertEquals(101, carSet.size(), "after add new object");
        assertTrue(carSet.remove(car), "object was deleted");
        assertEquals(100, carSet.size(), "after delete object");
        Car car2 = new Car("BMW", 10);
        assertFalse(carSet.remove(car2), "not presented object was deleted");
        assertEquals(100, carSet.size(), "after delete no present object");
    }
}