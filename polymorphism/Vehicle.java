package three.classdemo.polymorphism;

public class Vehicle {
    public String brand;
    public int speed;
    public Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }
    public void start()
    {
        System.out.println("Starting Vehicle...");
    }
    public Vehicle() {
        System.out.println("Vehicle constructor");
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void run(){

        System.out.println("Brand: "+getBrand()+" Speed: "+getSpeed()+" km/hr");
    }

}
