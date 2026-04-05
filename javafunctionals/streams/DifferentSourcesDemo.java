package javafunctionals.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
       From Collections: e.g .,collection.stream()
       From Arrays: e.g., Arrays.stream(array)
       From Specific Values: e.g., Stream.of("a","b","c")
       From Functions: e.g., Stream.iterate(0,n->n+2)
       From Files: e.g., Files.lines(path)
       Empty Stream: e.g., Stream.empty()
        */
public class DifferentSourcesDemo {
    static void main() throws IOException {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        //Collection
        Stream<Integer> stream = numbers.stream();
        stream.forEach(System.out::println);
        //Arrays
        int [] numArray ={1,2,3,4,5};
        IntStream stream2 = Arrays.stream(numArray);
        stream2.forEach(System.out::println);
        //Specific Values
        Stream<String>  stream3 = Stream.of("A","B","C");
        stream3.forEach(System.out::println);
        //Functions
        Stream<Integer> stream4 = Stream.iterate(0, i -> i + 1);
        stream4.forEach(System.out::println);
        //Files
        Stream<String> fileStream = Files.lines(Path.of("PATH"));
        //Empty Stream
        Stream<String> emptyStream = Stream.empty();
        emptyStream.forEach(System.out::println);
    }
}
