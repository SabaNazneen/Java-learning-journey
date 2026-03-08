package three.classdemo.inheritance;

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

    @Override
    public void run() {
        super.run();
        System.out.println("Brand: "+getBrand()+ "Speed: "+getSpeed()+" hasCarrier: "+hasCarrier);
    }
}
