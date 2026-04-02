package javafunctionals.inbuilt;
import java.util.function.BiFunction;
import java.util.function.Function;
public class BiFunctionDemo {
    //BiFunction<T,U,R>
    public static BiFunction<Integer,Integer,Integer> addFunction = (a,b)->a+b;
    public static BiFunction<Integer,Integer,Integer> subFunction =(a,b)->a-b;
    static void main() {
        System.out.println(addFunction.apply(1, 2));
        System.out.println(subFunction.apply(5,3));

        Function<Integer,Integer> multiplyBy2 = x->x*2;
        BiFunction<Integer,Integer,Integer> combineFunction = addFunction.andThen(multiplyBy2);
        System.out.println(combineFunction.apply(1,2));

    }
}
