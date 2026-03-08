package three.classdemo.interfaces;

public class InterfacesDemo {
    static void main() {
        ElectricCar e1 = new  ElectricCar();
        e1.applyBrakes();
        e1.turnRight();
        e1.turnLeft();

        CarControls myCar = new ElectricCar();
        myCar.turnRight();
        myCar.turnLeft();

        CarControls myCar2 = new SportsCar();
        myCar2.turnRight();
        myCar2.turnLeft();

    }
}
