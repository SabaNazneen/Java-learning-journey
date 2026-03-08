package three.classdemo.constructors;

public class Car {
    String brand;
    String color;
    int speed;
    public Car(){
        System.out.println("Car Constructor called");
    }
    public Car(String brand, String color, int speed){
        this.brand = brand;
        this.color = color;
        this.speed = speed;
        System.out.println("Parameterized Constructor called");
    }
    public void drive(){
        System.out.println(brand + " Driving at " + speed);
    }
}
