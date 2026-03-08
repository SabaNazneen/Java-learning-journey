package ExceptionHandling;
import java.util.*;
class Libraryclass{
    int availableBooks = 3;

    public void borrowBook(int booksRequested) throws Exception{
        try{
            if(booksRequested>availableBooks){
                throw new Exception("Not enough availible books");
            }
            int [] books ={101,102,103};
            System.out.println("Book Requested: "+books[booksRequested]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Book Not Available");
        }catch(NullPointerException e){
            System.out.println("Null Pointer Exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            System.out.println("finally block");
        }
    }

}
public class Throw {
    public static void main(String[] args) throws Exception {
        Libraryclass library = new Libraryclass();
        library.borrowBook(1);
        library.borrowBook(2);
        library.borrowBook(3);
        library.borrowBook(4);
    }
}
