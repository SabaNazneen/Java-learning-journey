package three.classdemo.interfaces;

public class SportsCar implements CarControls {
    @Override
    public void turnRight() {
        System.out.println("Sports car turn right");
    }

    @Override
    public void turnLeft() {
        System.out.println("Sports car turn left");
    }

    @Override
    public void applyBrakes() {
        System.out.println("Sports car apply brakes");
    }
}
