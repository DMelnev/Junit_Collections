public class CarLinkedList2 implements CarList {
    private Node first = null;
    private Node last = null;
    private int size = 0;

    @Override
    public Car get(int index) {
        return getNode(index).value;
    }

    @Override
    public void add(Car car) {
        if (size == 0) {
            first = new Node(null, car, null);
            last = first;
        } else {
            Node oldLast = last;
            last = new Node(oldLast, car, null);
            oldLast.next = last;
        }
        size++;
    }

    @Override
    public void add(Car car, int index) {
        if (index == size) {
            add(car);
            return;
        }
        Node nodeNext = getNode(index);
        Node nodePrev = nodeNext.previous;
        Node node = new Node(nodePrev, car, nodeNext);
        if (nodePrev == null) {
            first = node;
        } else nodePrev.next = node;
        nodeNext.previous = node;
        size++;
    }

    @Override
    public boolean remove(Car car) {
        Node node = first;
        for (int i = 0; i < size; i++){
            if (node.value.equals(car)){
                return removeAt(i);
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        Node node = getNode(index);
        Node nodePrev = node.previous;
        Node nodeNext = node.next;
        if (nodeNext != null) {
            nodeNext.previous = nodePrev;
        } else {
            last = nodePrev;
            last.next = null;
        }
        if (nodePrev != null) {
            nodePrev.next = nodeNext;
        } else {
            first = nodeNext;
            first.previous = null;
        }
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

    static class Node {
        Node previous;
        Car value;
        Node next;

        public Node(Node previous, Car value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
