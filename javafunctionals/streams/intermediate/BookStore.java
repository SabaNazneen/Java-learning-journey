package javafunctionals.streams.intermediate;

import java.util.*;

public class BookStore {
    String title;
    int pbYear;
    String category;
    double price;
    public BookStore(String title, int pbYear, String category, double price) {
        this.title = title;
        this.pbYear = pbYear;
        this.category = category;
        this.price = price;
    }
    public static List<Book> getBooks() {
        return Arrays.asList(
                new Book("Clean Code", 2008, "Programming", 450.0),
                new Book("Effective Java", 2018, "Programming", 550.0),
                new Book("The Alchemist", 1988, "Fiction", 300.0),
                new Book("Atomic Habits", 2018, "Self-help", 400.0),
                new Book("Rich Dad Poor Dad", 1997, "Finance", 350.0),
                new Book("Harry Potter and the Philosopher's Stone", 1997, "Fantasy", 500.0),
                new Book("The Pragmatic Programmer", 1999, "Programming", 600.0),
                new Book("Think and Grow Rich", 1937, "Self-help", 250.0),
                new Book("Ikigai", 2016, "Lifestyle", 320.0),
                new Book("Deep Work", 2016, "Productivity", 420.0)
        );
    }

    @Override
    public String toString() {
        return title + " | " + pbYear + " | " + category + " | " + price;
    }
}