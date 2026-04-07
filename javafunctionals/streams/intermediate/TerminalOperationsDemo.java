package javafunctionals.streams.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperationsDemo {
    static void main() {
        //reduce()
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = list.stream();
        int sum = stream.reduce(0,(acc,num)->acc+num);
        //int sum = stream.reduce(0,Integer::sum);
        System.out.println(sum);
        //collect()
        List<Integer> evenNum = (List<Integer>) list.stream()
                .filter(n->n%2==0)
                .collect(Collectors.toList());
        System.out.println("Even Num: "+evenNum);
        //find & match()
        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());
        boolean has40=list.stream()
                .anyMatch(n->n==40);
        System.out.println(has40);
        //iteration
        list.stream()
                .forEach(System.out::println);
    }
}
