package Collections;
import java.util.*;
class Car{
    String brand;
    Car(String brand) {
        this.brand = brand;
    }
}
public class ListDemo {
    static void main() {
        List<String> users = new ArrayList<>();
        users.add("John");
        users.add("Sarah");
        users.add("Jane");
        users.add("John");
        System.out.println("All Users");
        for(Object user : users) {
            System.out.println(user);
        }
        System.out.println("Element using index: "+users.getFirst());
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        System.out.println("All Cars");
        for(Car car:cars)
        {
            System.out.println(car.brand);
        }
    }
}
