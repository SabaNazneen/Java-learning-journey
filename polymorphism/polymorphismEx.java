package three.classdemo.polymorphism;

public class polymorphismEx {
    static void main() {
        Car c1 = new Car("Audi",200,"Blue");
        c1.run();
        Bike b1 = new Bike("BMW",120,true);
        b1.run();
        c1.start();
        b1.start();
        Vehicle v1 = new Car("Mercedes",300,"Red");
        v1.run();
        Car c2 = new Car("Ferrari",160,"Yellow");
        c2.run();
        Car c = new Car("Lambo",250,"Black");
        Vehicle v = c;
        v.run();
        Vehicle v3 = new Bike("Yamaha",250,true);
        b1.start("Hello");
    }
}
