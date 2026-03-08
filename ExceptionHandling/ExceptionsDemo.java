package ExceptionHandling;

public class ExceptionsDemo {
    static void main() {
        //Exception Handling using try catch block

        try{
            //Exception generating statements
            int a = 10/3;
            System.out.println("DONE");
        }catch(Exception e){
            //Exception Handling statements
            System.out.println("Arithmetic Exception Occurred");
        }
        int a[] = {1,2,3,4};
       try
       {
           System.out.println(a[6]);
       }catch(ArrayIndexOutOfBoundsException e){
           System.out.println("Array Index Out Of Bounds");
       }
        System.out.println("Outside of try block");

       //Multiple catch blocks inside try block
        try{

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array Index Out Of Bounds");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            //Always Executes
            System.out.println("finally block");
        }
    }
}
