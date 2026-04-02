package javafunctionals.inbuilt;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.BiFunction;
// Input --> T
// Output --> U
//x-> Logic
//Function<T, R> name = input -> output;
// Call --> name.apply(value);
class Demo{
    public static Integer add(Integer a, Integer b){
        return a+b;
    }
}
public class ConsumerDemo {
    static void main() {
                                    //This one takes    //This one
                                    //the input         //prints or performs something
        Consumer<String>consumer1 = (str)-> System.out.println(str);

        consumer1.accept("Hello");
        Consumer<String> consumer2 =System.out::println;
        consumer2.accept("Hi");


        BiFunction<Integer,Integer,Integer> biFunction = (a,b)->a+b;
        //Calls the function
        System.out.println(biFunction.apply(1,2));
        Consumer<String> consumer3 = System.out::println;
        consumer3.accept("Saba");
        Function<String,Integer> fun = (str)-> Integer.parseInt(str);
        System.out.println(fun.apply("45"));

        BiFunction<Integer,Integer,Integer> sumCall = Demo::add;
        System.out.println(sumCall.apply(9,10));

    }
}
