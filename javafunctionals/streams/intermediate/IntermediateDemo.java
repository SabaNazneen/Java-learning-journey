package javafunctionals.streams.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateDemo {
    static void main() {
        List<Book> books = Arrays.asList(
                new Book("Clean Code", 2008, "Programming", 450.0),
                new Book("Effective Java", 2018, "Programming", 550.0),
                new Book("The Alchemist", 1988, "Fiction", 300.0),
                new Book("Atomic Habits", 2018, "Self-help", 400.0),
                new Book("Rich Dad Poor Dad", 1997, "Finance", 350.0),
                new Book("Harry Potter", 1997, "Fantasy", 500.0),
                new Book("The Pragmatic Programmer", 1999, "Programming", 600.0),
                new Book("Think and Grow Rich", 1937, "Self-help", 250.0),
                new Book("Ikigai", 2016, "Lifestyle", 320.0),
                new Book("Deep Work", 2016, "Productivity", 420.0)
        );
        // 1.Filtering: Books Cheaper than $30
        Stream<Book> stream1 = books.stream();
        List<Book> list1 = books.stream()
                .filter(b->b.price<400)
                .toList();
        list1.forEach(System.out::println);

        // 2. Mapping: Convert book titles to uppercase
        Stream<Book> stream2 = books.stream();
        List<String> list2 = books.stream()
                .map(b -> b.title.toUpperCase())
                .toList();
        list2.forEach(System.out::println);

        //3. Sorting: Books by Publication date
        List<Book> list3 = books.stream()
                .sorted((b1, b2) -> b1.pbYear - b2.pbYear)
                .toList();

        list3.forEach(System.out::println);

        //4. Distinct: Remove duplicate titles
        Stream<Book> uniqueBooks = books.stream().distinct();
        uniqueBooks.forEach(System.out::println);

        //5.Limit: Display only the first 3 books
        Stream<Book> firtThreeBooks = books.stream()
                .limit(3);
        firtThreeBooks.forEach(System.out::println);

        //6. Skip: Skip the first 2 books
        Stream<Book> skipBooks = books.stream()
                .skip(3);
        skipBooks.forEach(System.out::println);
    }
}
