import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarSetTest {
    private CarSet<Car> carSet;

    @BeforeEach
    void setUp() {
        carSet = new CarHashSet<>();
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
        Car car = new Car("Brand3", 2);
        assertTrue(carSet.add(car), "add new object");
        assertEquals(101, carSet.size(), "after add new object");
        assertTrue(carSet.remove(car), "object was deleted");
        assertEquals(100, carSet.size(), "after delete object");
        Car car2 = new Car("BMW", 10);
        assertFalse(carSet.remove(car2), "not presented object was deleted");
        assertEquals(100, carSet.size(), "after delete no present object");
    }
    @Test
    void contains(){
        Car car = new Car("Brand2", 2);
        assertTrue(carSet.contains(car), "object present in array");
        Car car2 = new Car("BMW", 10);
        assertFalse(carSet.contains(car2), "object absent in array");
    }
}