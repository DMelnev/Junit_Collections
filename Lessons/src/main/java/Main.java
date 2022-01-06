import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>();
        for (int i = 0; i < 100; i++) {
            numbers.add((int) (Math.random() * 10));
        }
        for (int dig : numbers) {
            System.out.println(dig);
        }
    }
}
