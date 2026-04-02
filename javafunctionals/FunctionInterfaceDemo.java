package javafunctionals.inbuilt;

import java.util.function.Function;

public class FunctionInterfaceDemo {
    //This one takes only one argument
    public static Function<Integer, Integer> addFunction=(a)->a+3;
    public static Function<Integer, Integer> subtractFunction=(a)->a-3;
    static void main() {
        System.out.println(addFunction.apply(1));
        System.out.println(subtractFunction.apply(2));
    }
}
