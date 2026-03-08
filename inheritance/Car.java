package three.classdemo.inheritance;

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
    public void run() {
        super.run();
        System.out.println("Brand: "+getBrand()+" Speed: "+getSpeed()+" km/hr"+" color: "+color);
    }
}
