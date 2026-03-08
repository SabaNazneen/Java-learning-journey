package three.classdemo.interfaces;

public class ElectricCar implements CarControls {

    @Override
    public void turnRight() {

        System.out.println("Turning right");
    }

    @Override
    public void turnLeft() {

        System.out.println("Turning left");
    }

    @Override
    public void applyBrakes() {

        System.out.println("Applying brakes");
    }
}
