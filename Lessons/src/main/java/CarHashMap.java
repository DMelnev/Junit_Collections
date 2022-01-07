import java.util.List;
import java.util.Set;

public class CarHashMap implements CarMap {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private int size = 0;
    private Entry[] array = new CarHashMap.Entry[INITIAL_CAPACITY];

    @Override
    public void put(CarOwner key, Car value) {
        if (size >= (array.length * LOAD_FACTOR)) {
            increaseArray();
        }
        boolean added = put(key, value, array);
        if (added) size++;
    }

    public boolean put(CarOwner key, Car value, Entry[] dst) {
        int position = getElementPosition(key, dst.length);
        if (dst[position] == null) {
            dst[position] = new Entry(value, key, null);
            return true;
        }
        Entry extendElement = dst[position];
        while (true) {
            if (extendElement.value.equals(value) && extendElement.key.equals(key)) {
                dst[position] = new Entry(value, key, null);
                return false;
            }
            if (extendElement == null) {
                dst[position] = new Entry(value, key, null);
                return true;
            } else extendElement = extendElement.next;
        }
    }


    @Override
    public Car get(CarOwner key) {
        return null;
    }

    @Override
    public Set<CarOwner> keySet() {
        return null;
    }

    @Override
    public List<Car> values() {
        return null;
    }

    @Override
    public boolean remove(CarOwner key) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    private void increaseArray() {
        CarHashMap.Entry[] newArray = new CarHashMap.Entry[array.length * 2];
        for (CarHashMap.Entry entry : array) {
            CarHashMap.Entry existedElement = entry;
            while (existedElement != null) {
//               put(existedElement.value, newArray);
                existedElement = existedElement.next;
            }
        }
        array = newArray;
    }

    private int getElementPosition(CarOwner key, int arrayLength) {
        return Math.abs(key.hashCode() % arrayLength);
    }

    private static class Entry {
        private Car value;
        private CarOwner key;
        private CarHashMap.Entry next;

        public Entry(Car value, CarOwner key, Entry next) {
            this.value = value;
            this.key = key;
            this.next = next;
        }
    }
}
