package javafunctionals.streams.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperationsChallenge {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Design Patterns", 1994, "Programming", 700.0),
                new Book("Refactoring", 1999, "Programming", 650.0),
                new Book("Zero to One", 2014, "Business", 280.0),
                new Book("The Lean Startup", 2011, "Business", 300.0),
                new Book("Sapiens", 2011, "History", 450.0),
                new Book("Homo Deus", 2015, "History", 480.0),
                new Book("The Psychology of Money", 2020, "Finance", 350.0),
                new Book("Can't Hurt Me", 2018, "Self-help", 400.0),
                new Book("The Subtle Art of Not Giving a F*ck", 2016, "Self-help", 380.0),
                new Book("A Brief History of Time", 1988, "Science", 500.0),
                new Book("The Theory of Everything", 2002, "Science", 420.0),
                new Book("Start With Why", 2009, "Motivation", 310.0)
        );
        //Total cost of all books in the bookstore
        Double bookCost = books.stream()
                .mapToDouble(book -> book.price)
                  .reduce(0,Double::sum);
        System.out.println("Cost of all books: "+bookCost);
        //Collecting Books into a list of titles
       List<String>bookTitles= books.stream()
                .map(book->book.title)
                .collect(Collectors.toList());
        System.out.println("Titles: "+bookTitles);
        //Grouping books by category
       Map<String,List<Book>> byCategory= books.stream()
                .collect(Collectors.groupingBy(bookkStringFunction));
       byCategory.forEach((category,bookList)->{
          bookList.forEach(System.out::println);
       });

    }
   static Function<Book,String> bookkStringFunction = new Function<Book, String>() {
        @Override
        public String apply(Book book) {
            return book.getCategory();
        }
    };
}
