import java.util.Arrays;
import java.util.Iterator;

public class CarArrayList<T> implements CarList<T> {
    private Object[] array = new Object[10];
    private int size = 0;

    @Override
    public T get(int index) {
        checkIndexOutOfBounds(index);
        return (T) array[index];
    }

    @Override
    public boolean add(T car) {
        increaseArrayIfOutOff();
        array[size] = car;
        size++;
        return true;
    }

    @Override
    public boolean remove(T car) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(car))
                return removeAt(i);
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndexOutOfBounds(index);
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Object[10];
        size = 0;
    }

    @Override
    public boolean add(T car, int index) {
        increaseArrayIfOutOff();
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        size++;
        array[index] = car;
        return true;
    }

    @Override
    public boolean contains(T car) {
        for (int i = 0; i < size; i++) {
            if (car.equals(array[i])) return true;
        }
        return false;
    }


    public void checkIndexOutOfBounds(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void increaseArrayIfOutOff() {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T) array[index++];
            }
        };
    }
}
