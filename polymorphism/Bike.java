package three.classdemo.polymorphism;

public class Bike extends Vehicle {
    private boolean hasCarrier;

    public Bike(String brand, int speed, boolean hasCarrier) {
        super(brand, speed);
        this.hasCarrier = hasCarrier;
    }

    public Boolean getHasCarrier() {
        return hasCarrier;
    }

    public void setHasCarrier(Boolean hasCarrier) {
        this.hasCarrier = hasCarrier;
    }
    public void start() {
        System.out.println("Bike start..");
    }
    public void start(String greet) {
        System.out.println("Bike start.."+greet);
    }
    @Override
    public void run() {
       // super.run();
        System.out.println("Brand: " + getBrand() + "Speed: " + getSpeed() + " hasCarrier: " + hasCarrier);
    }
}
