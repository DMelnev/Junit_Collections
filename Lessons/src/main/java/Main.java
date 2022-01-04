import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Car car1 = new Car("BMW", 1);
//        Car car2 = new Car("BMW", 1);
//        System.out.println(car1.equals(car2));
//        System.out.println(car1.hashCode());
//        System.out.println(car2.hashCode());
//        ListNode l1 = pack(9L);
//        ListNode l2 = pack(9999999991L);
//        ListNode l1 = pack(9999999L);
//        ListNode l2 = pack(9999L);

        System.out.println(unpack(addTwoNumbers(l1, l2)));

}

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return new ListNode();
    }

    private static ArrayList unpack(ListNode list) {
        ArrayList<Integer> newList = new ArrayList<>();
        while (list != null) {
            newList.add(list.val);
            list = list.next;
        }
        return newList;
    }

    private static long unpack2(ListNode list) {
        int index = 1, sum = 0;

        while (list != null) {
            sum += list.val * index;
            index *= 10;
            list = list.next;
        }
        return sum;
    }

    private static ListNode pack2(long digit) {
        System.out.println((int) digit % 10);
        ListNode first = new ListNode((int) digit % 10, null);
        ListNode prev = first;
        ListNode next;
        digit /= 10;
        while (digit > 0) {
            System.out.println((int) digit % 10);
            next = new ListNode(((int) digit % 10), null);
            prev.next = next;
            prev = next;
            digit /= 10;
        }
        System.out.println();
        return first;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
