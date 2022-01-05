import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarCollectionTest {
    private CarCollection carCollection;

    @BeforeEach
    void setUp() {
        carCollection = new CarHashSet();
//        carList = new CarLinkedList();
        for (int i = 0; i < 100; i++) {
            carCollection.add(new Car("Brand" + i, i));
        }
    }

    @Test
    void contains() {
        Car car = new Car("Brand2", 2);
        assertTrue(carCollection.contains(car), "object present in array");
        Car car2 = new Car("BMW", 10);
        assertFalse(carCollection.contains(car2), "object absent in array");
    }

    @Test
    void testForeach(){
        int index = 0;
        for(Car car : carCollection){
            index ++;
        }
        assertEquals(100, index,"");
    }
}
