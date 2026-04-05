package javafunctionals.inbuilt;
import java.util.function.BiConsumer;
//Once a String enters the expression, everything after becomes “string mode”
//Then "Action performed " + result → String concatenation
public class BiConsumerDemo {
    static void main() {
        BiConsumer<Integer,Integer> bi = (a,b)->{
            System.out.println("Action performed "+(a+b));
        };
        bi.accept(5,6);
    }
}
