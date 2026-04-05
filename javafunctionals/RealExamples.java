package javafunctionals.inbuilt;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class RealExamples {
    static void main() {
        BiFunction<String,Double,String>formatter = (title,price)->title+" costs $" +price;
        System.out.println(formatter.apply("Java Basics",19.49));
        BiConsumer<String,Double> formatter2 = (title,price)->System.out.println(title+" costs $" +price);
        formatter2.accept(" Python Basics",9.45);
        formatter2.accept("C++ Basics",20.29);
        formatter2.accept("Javascript Basics",10.24);
        //isExpensive
        Predicate<Double> isExpensive = price -> price>10;
        System.out.println(isExpensive.test(9.45));
        System.out.println(isExpensive.test(10.24));
    }
}
