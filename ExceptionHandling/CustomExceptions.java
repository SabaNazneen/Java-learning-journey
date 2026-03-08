package ExceptionHandling;
class BookUnavailableException extends Exception{
    public BookUnavailableException(String message) {
        super(message);
    }
}
class Libraryclass2{
    int availableBooks = 0;
    public void borrowBook(int bookid) throws BookUnavailableException{
            if(availableBooks == 0 ){
                throw new BookUnavailableException("Book Not Available");
            }
        //availableBooks--;
        System.out.println("Book borrowed successfully");
    }
}
public class CustomExceptions {
    static void main() throws Exception {
        Libraryclass2 library = new Libraryclass2();
        try{
            library.borrowBook(0);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
