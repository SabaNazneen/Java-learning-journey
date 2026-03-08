package three.classdemo.encapsulation;

 class Car {
    private String brand;
    private String color;
    private int speed;

     public Car() {
         System.out.println("Car Constructor called");
     }

     public Car(String brand, String color, int speed) {
         this.brand = brand;
         this.color = color;
         setSpeed(speed);
         System.out.println("Parameterized Constructor called");
     }

     public void drive() {
         System.out.println(brand + " Driving at " + speed);
     }
     public int getSpeed(){
         return speed;
     }
     public void setSpeed(int speed){
         if(speed<0){
             speed = 0;
         }
         this.speed = speed;
        // return speed;
     }
     public String getBrand(){
         return brand;
     }
     public String setBrand(String brand){
         this.brand = brand;
         return brand;
     }
     public String getColor(){
         return color;
     }
     public String setColor(String color)
     {
         this.color = color;
         return color;
     }
 }
public class EncapsulationDemo {
    static void main() {
        Car car1 = new Car();
        car1.setBrand("Mercedes");
        car1.setColor("Blue");
        car1.setSpeed(200);
        car1.drive();

        Car car2 = new Car("Audi","Black",-200);
        car2.drive();
    }
}
