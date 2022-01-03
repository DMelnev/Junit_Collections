public class CarArrayList implements CarList {
    private Car[] array = new Car[10];
    private int size = 0;

    @Override
    public Car get(int index) {
        checkIndexOutOfBounds(index);
        return array[index];
    }

    @Override
    public void add(Car car) {
        if (size >= array.length) {
            Car[] newArray = new Car[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
        }
        array[size] = car;
        size++;

    }

    @Override
    public boolean remove(Car car) {
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndexOutOfBounds(index);
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

    public void checkIndexOutOfBounds(int index) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }
}
