package javafunctionals.streams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamFirstDemo {
    static void main() {
        List<String> items = Arrays.asList("Mango","Banana","Plum");
        Stream<String>stream = items.stream();
        stream.forEach(System.out::println);

        List<Integer> num = Arrays.asList(1,2,3,4,5);
        //ITERATION 1: LIST: EVEN NUMBERS FROM THE LIST
        List<Integer> evenNum = new ArrayList<>();
        for(int n: num)
        {
            if(n%2==0)
                evenNum.add(n);
        }
        System.out.println("Even num without streams: " +evenNum);

        //ITERATION 2
        Stream<Integer> integerStream1 = num.stream();
         Predicate<Integer> p = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                int remainder = integer%2;
                if(remainder==0) return true;
                return false;
            }
        };
        Stream<Integer> integerStream2 = integerStream1.filter(p);
        List<Integer> evenNum2 = integerStream2.toList();
        System.out.println("Even num with streams: " +evenNum2);

        Predicate<Integer> p2 = (i)->i%2==0;

        //ITERATION 3
        List<Integer> evenList = num.stream()
                .filter(p2)
                .toList();
        System.out.println("Even num iteration 3: " + evenList);

    }
}
