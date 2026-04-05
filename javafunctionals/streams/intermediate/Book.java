package javafunctionals.streams.intermediate;

public class Book {
    String title;
    int pbYear;
    String category;
    double price;

    public Book(String title, int pbYear, String category, double price) {
        this.title = title;
        this.pbYear = pbYear;
        this.category = category;
        this.price = price;
    }
    @Override
    public String toString() {
        return title + " | " + pbYear + " | " + category + " | " + price;
    }
}
