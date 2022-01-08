import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarHashMap<K, V> implements CarMap<K, V> {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private int size = 0;
    private Object[] array = new Object[INITIAL_CAPACITY];

    @Override
    public void put(K key, V value) {
        if (size >= (array.length * LOAD_FACTOR)) {
            increaseArray();
        }
        boolean added = put(key, value, array);
        if (added) size++;
    }

    private boolean put(K key, V value, Object[] dst) {
        int position = getElementPosition(key, dst.length);
        if (dst[position] == null) {
            dst[position] = new Entry(key, value, null);
            return true;
        }
        Entry existedElement = (Entry) dst[position];
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
    public V get(K key) {
        int position = getElementPosition(key, array.length);
        Entry existedElement = (Entry) array[position];
        while (existedElement != null) {
            if (existedElement.key.equals(key)) {
                return existedElement.value;
            }
            existedElement = existedElement.next;
        }
        return null;
    }

    @Override
    public Set<K> keySet() {
        Set<K> result = new HashSet<>();
        for (Object sector : array) {
            Entry existed = (Entry) sector;
            while (existed != null) {
                result.add(existed.key);
                existed = existed.next;
            }
        }
        return result;
    }

    @Override
    public List<V> values() {
        List<V> list = new ArrayList<>();
        for (Object sector : array) {
            Entry existed = (Entry)sector;
            while (existed != null) {
                list.add(existed.value);
                existed = existed.next;
            }
        }
        return list;
    }

    @Override
    public boolean remove(K key) {
        int position = getElementPosition(key, array.length);
        Entry prev = (Entry) array[position];
        if (prev == null) return false;
        if (prev.key.equals(key)) {
            array[position] = prev.next;
            size--;
            return true;
        }

        Entry existed = (Entry) prev.next;
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
        array = new Object[INITIAL_CAPACITY];
    }

    private void increaseArray() {
        Object[] newArray = new Object[array.length * 2];
        for (Object entry : array) {
            Entry existedElement = (Entry)entry;
            while (existedElement != null) {
                put(existedElement.key, existedElement.value, newArray);
                existedElement = existedElement.next;
            }
        }
        array = newArray;
    }

    private int getElementPosition(K key, int arrayLength) {
        return Math.abs(key.hashCode() % arrayLength);
    }

    private  class Entry {
        private V value;
        private K key;
        private CarHashMap.Entry next;

        public Entry(K key, V value, Entry next) {
            this.value = value;
            this.key = key;
            this.next = next;
        }
    }
}
