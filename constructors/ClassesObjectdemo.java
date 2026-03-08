package three.classdemo.constructors;

public class ClassesObjectdemo {
    static void main() {
        Car car1 = new Car();
        car1.brand = "Audi";
        car1.speed = 100;
        car1.color = "Red";
        car1.drive();

        Car car2 = new Car();
        car2.brand = "BMW";
        car2.color = "Blue";
        car2.speed = 200;
        car2.drive();

        Car car3 = new Car("Mercedes","Black",150);
        car3.drive();
    }
}

