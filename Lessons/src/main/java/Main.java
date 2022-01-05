import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
//        Car car1 = new Car("BMW", 1);
//        Car car2 = new Car("BMW", 1);
//        System.out.println(car1.equals(car2));
//        System.out.println(car1.hashCode());
//        System.out.println(car2.hashCode());
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
//        list1.add(1);
//        list1.add(9);
//        list1.add(9);
//
//        list1.add(9);
//        list1.add(9);
//        list1.add(9);
//        list1.add(9);
//        list1.add(9);
//        list1.add(9);
//        list1.add(9);
//
//        list2.add(9);

        list1.add(9);
        list1.add(4);
        list1.add(2);

        list2.add(9);
        list2.add(4);
        list2.add(6);
        list2.add(5);

        ListNode l1 = pack(list1);
        ListNode l2 = pack(list2);
//        System.out.println(unpack(l1));
//        System.out.println(unpack(l2));

        System.out.println(unpack(addTwoNumbers(l1, l2)));

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return pack(addList(unpack(l1), unpack(l2)));
    }

    private static ArrayList<Integer> unpack(ListNode list) {
        ArrayList<Integer> newList = new ArrayList<>();
        while (list != null) {
            newList.add(list.val);
            list = list.next;
        }
        //Collections.reverse(newList);
        return newList;
    }

    private static ArrayList<Integer> addList(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        int length = Math.max(l1.size(), l2.size());
        ArrayList<Integer> res = new ArrayList<>();
        int over = 0, sum;
        for (int i = 0; i < length; i++) {
            sum = ((i >= l1.size()) ? 0 : l1.get(i)) + ((i >= l2.size()) ? 0 : l2.get(i)) + over;
            res.add(i, sum % 10);
            over = sum / 10;
        }
        if (over > 0) res.add(over);
        return res;
    }

    private static ListNode pack(ArrayList<Integer> list) {
       // Collections.reverse(list);
        ListNode first = new ListNode(list.get(0), null);
        ListNode prev = first;
        ListNode next;
        for (int i = 1; i < list.size(); i++) {
            next = new ListNode(list.get(i), null);
            prev.next = next;
            prev = next;
        }
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
