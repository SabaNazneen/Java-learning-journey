package ExceptionHandling;
class Library{
    int availableBooks = 3;

    public void borrowBook(int booksRequested){
        try{
            int [] books ={101,102,103};
            System.out.println("Book Requested: "+books[booksRequested]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Book Not Available");
        }catch(NullPointerException e){
            System.out.println("Null Pointer Exception");
        }finally{
            System.out.println("finally block");
        }
    }

}
public class LibraryDemo {
    static void main() {
        Library library = new Library();
        library.borrowBook(1);
        library.borrowBook(2);
        library.borrowBook(3);
        library.borrowBook(4);
    }
}
