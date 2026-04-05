package javafunctionals.inbuilt;
import java.util.function.Predicate;
import java.util.function.BiPredicate;
//Inside class no print statement can work
public class PredicateDemo {
    static void main() {
        Predicate<Integer> isEven = i->i%2==0;
        System.out.println(isEven.test(10));
        System.out.println(isEven.test(30));

        BiPredicate<Integer,Integer> isSumEven = (a,b)->(a+b)%2==0;
        System.out.println(isSumEven.test(1,2));
    }
}
