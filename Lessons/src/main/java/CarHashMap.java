import java.util.ArrayList;
import java.util.HashSet;
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

    private boolean put(CarOwner key, Car value, Entry[] dst) {
        int position = getElementPosition(key, dst.length);
        if (dst[position] == null) {
            dst[position] = new Entry(key, value, null);
            return true;
        }
        Entry existedElement = dst[position];
        while (true) {
            if (existedElement.key.equals(key)) {
                existedElement.value = value;
                return false;
            }
            if (existedElement.next == null) {
                existedElement.next = new Entry(key, value, null);
                return true;
            }
            existedElement = existedElement.next;
        }
    }

    @Override
    public Car get(CarOwner key) {
        int position = getElementPosition(key, array.length);
        Entry existedElement = array[position];
        while (existedElement != null) {
            if (existedElement.key.equals(key)) {
                return existedElement.value;
            }
            existedElement = existedElement.next;
        }
        return null;
    }

    @Override
    public Set<CarOwner> keySet() {
        Set<CarOwner> result = new HashSet<>();
        for (Entry sector : array) {
            Entry existed = sector;
            while (existed != null) {
                result.add(existed.key);
                existed = existed.next;
            }
        }
        return result;
    }

    @Override
    public List<Car> values() {
        List<Car> list = new ArrayList<>();
        for (Entry sector : array) {
            Entry existed = sector;
            while (existed != null) {
                list.add(existed.value);
                existed = existed.next;
            }
        }
        return list;
    }

    @Override
    public boolean remove(CarOwner key) {
        int position = getElementPosition(key, array.length);
        if (array[position] == null) return false;
        if (array[position].key.equals(key)) {
            array[position] = array[position].next;
            size--;
            return true;
        }
        Entry prev = array[position];
        Entry existed = array[position].next;
        while (existed != null) {
            if (existed.key.equals(key)) {
                prev.next = existed.next;
                size--;
                return true;
            }
            prev = existed;
            existed = existed.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        array = new CarHashMap.Entry[INITIAL_CAPACITY];
    }

    private void increaseArray() {
        CarHashMap.Entry[] newArray = new CarHashMap.Entry[array.length * 2];
        for (CarHashMap.Entry entry : array) {
            CarHashMap.Entry existedElement = entry;
            while (existedElement != null) {
                put(existedElement.key, existedElement.value, newArray);
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

        public Entry(CarOwner key, Car value, Entry next) {
            this.value = value;
            this.key = key;
            this.next = next;
        }
    }
}
