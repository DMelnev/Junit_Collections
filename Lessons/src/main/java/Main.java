import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Car> cars= new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            cars.add(new Car("Brand" + i, i));
        }
        for(Car car : cars){
            System.out.println(car);
        }
    }
}
