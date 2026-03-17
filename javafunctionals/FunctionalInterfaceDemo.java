package javafunctionals;

//To make the developer explicitly know about the functional interface we write it like this
@FunctionalInterface
interface BookAction{
    void perform();
}
interface Runnable{
    void run();
}
// parameter -> expression body
//() -> {}
interface Operation{
    int add(int a, int b);
}

public class FunctionalInterfaceDemo {
    static void main() {
        //Creation of an anonymous class and using to create object for the interface
        BookAction bookAction = new BookAction() {
            @Override
            public void perform() {
                System.out.println("Action performed");
            }
        };
        //Now defining the method using lambda expression without any creation of object
        BookAction bookAction1 = () -> System.out.println("Action performed");
        bookAction1.perform();

        //Functional Interface with parameters
        Operation op2 = new Operation() {
            @Override
            public int add(int a, int b) {
                return a+b;
            }
        };
        op2.add(3,5);
        Operation op = (a,b)-> a+b;
        System.out.println(op.add(2,3));

        //Thread Interface
        new Thread(()-> System.out.println("New thread created")).start();

    }
}
