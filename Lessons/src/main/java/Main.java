import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Car> cars = new TreeSet<>(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
//                return o1.getBrand().compareTo(o2.getBrand());
                return o2.getNumber() - o1.getNumber();
            }
        });
        for (int i = 0; i < 100; i++) {
            int index = (int) (Math.random() * 21);
            cars.add(new Car("Model" + index, index));
        }
        for (Car car : cars) {
            System.out.println(car);
        }

    }
}
