import java.util.Iterator;

public class CarLinkedList<T> implements CarList<T>, CarQueue<T> {

    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public T get(int index) {
        return (T) getNode(index).value;
    }

    @Override
    public boolean add(T car) {
        if (size == 0) {
            first = new Node(null, car, null);
            last = first;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, car, null);
            secondLast.next = last;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(T car, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(car);
            return true;
        }
        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodePrevious, car, nodeNext);
        nodeNext.previous = newNode;
        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        } else first = newNode;
        size++;
        return true;
    }

    @Override
    public boolean remove(T car) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(car)) {
                removeAt(i);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        Node node = getNode(index);
        Node next = node.next;
        Node previous = node.previous;
        if (previous != null) previous.next = next;
        else first = next;
        if (next != null) next.previous = previous;
        else last = previous;
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;

    }

    @Override
    public T peek() {
        return size > 0 ? get(0) : null;
    }

    @Override
    public T poll() {
        if (size <= 0) return null;
        T car = get(0);
        removeAt(0);
        return car;
    }

    @Override
    public boolean contains(T car) {
        Node node = first;
        while (node != null) {
            if (node.value.equals(car)) return true;
            node = node.next;
        }
        return false;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node node = first;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                T car = node.value;
                node = node.next;
                return car;
            }
        };
    }

    private class Node {
        private Node previous;
        private T value;
        private Node next;

        public Node(Node previous, T value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
