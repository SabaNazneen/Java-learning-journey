package javafunctionals.streams;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamsDemo {
    //Streams --> Assembly line/pipeline
    static void main() {
        List<String> items = Arrays.asList("A","B","C");
        List<String> item2 = Arrays.asList("Apple", "Banana", "Orange");
        for(String item:items) {
            System.out.println(item);
        }
        //Using Streams
        Stream<String> stream = items.stream();
        stream.forEach(System.out::println);
        Stream<String> stream2 = item2.stream();
      //  stream2.forEach(System.out::println);
        // ==Filtered Fruits==
        System.out.println("==Filtered Fruits==");
       Stream<String>filteredStream = item2.stream()
                        .filter(name-> name.startsWith("B"));
       filteredStream.forEach(System.out::println);

    }
}
