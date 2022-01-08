import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarQueueTest {

    private CarQueue<Car> queue;

    @BeforeEach
    void setUp() {
        queue = new CarLinkedList<>();
        for (int i = 0; i < 10; i++) {
            queue.add(new Car("brand" + i, i));
        }
    }

    @Test
    void add() {
        assertEquals(10, queue.size(),"test after add");
    }

    @Test
    void peek() {
        Car car = queue.peek();
        assertEquals("brand0", car.getBrand(), "test peek");
        assertEquals(10,queue.size(), "after peek");
    }

    @Test
    void poll() {
        Car car = queue.poll();
        assertEquals("brand0", car.getBrand(), "test poll");
        assertEquals(9,queue.size(), "after poll");
    }
}