import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarListTest {
    private CarList<Car> carList;

    @BeforeEach
    void setUp() {
        carList = new CarArrayList<>();
//        carList = new CarLinkedList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void testSize() {
        assertEquals(100, carList.size(), "testing method .size ");
    }

    @Test
    public void removeByIndex() {
        assertTrue(carList.removeAt(5), "removeAt had to returned true ");
        assertEquals(99, carList.size(), "expected 99 after removing by object");
    }

    @Test
    public void removeByObject() {
        Car car = new Car("T", 10);
        carList.add(car);
        assertEquals(101, carList.size(), "increased after .add(car)");
        assertTrue(carList.remove(car), ".remove(car)");
        assertEquals(100, carList.size(), "after .remove(car)");
    }

    @Test
    public void addObject() {
        carList.add(new Car("Toyota", 10));
        assertEquals(101, carList.size(), "expected 101 after add new object1");
    }

    @Test
    public void testClear() {
        assertEquals(100, carList.size(), "expected 100 before start testing cLear");
        carList.clear();
        assertEquals(0, carList.size(), "expected 0 after clear");
    }

    @Test
    public void testIndexOutOfBound() {
        Exception exception = assertThrows(Exception.class, () -> carList.get(100));
    }

    @Test
    public void getRightValue() {
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand(), "expected \"Brand0\" after .get");
    }

    @Test
    public void addObjectInto() {
        Car car = new Car("Audi", 25);
        carList.add(car, 50);
        Car carFrom = carList.get(50);
        assertEquals("Audi", carFrom.getBrand(), "equal objects after add to index 50");
        carList.add(car, 101);
        carFrom = carList.get(101);
        assertEquals("Audi", carFrom.getBrand(), "equal objects after add to index 101");
    }

    @Test
    void contains() {
        Car car = new Car("Brand2", 2);
        assertTrue(carList.contains(car), "object present in array");
        Car car2 = new Car("BMW", 10);
        assertFalse(carList.contains(car2), "object absent in array");
    }

}