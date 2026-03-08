package three.classdemo.polymorphism;

public class Car extends Vehicle {
    private String color;
    public Car(){
        System.out.println("Car constructor");
    }
    public Car(String brand, int speed, String color)
    {
        super(brand, speed);
        this.color = color;
    }

    @Override
    public void start() {
        System.out.println("Car start");
    }

    @Override
    public void run() {
       // super.run();
        System.out.println("Brand: "+getBrand()+" Speed: "+getSpeed()+" km/hr"+" color: "+color);
        System.out.println("Car method");
    }
}
