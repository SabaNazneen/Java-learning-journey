package javafunctionals.inbuilt;
import java.util.*;
import java.util.function.Consumer;

public class MethodReferencesDemo {
    static void main() {
        //Printing the list in 5 different ways
        //Tradition way: using for loops
        List<String> name = Arrays.asList("John", "Julie", "Julie");
        for(int i=0;i<name.size();i++)
        {
            System.out.println(name.get(i));
        }
        //using enhanced for
        for(String s:name)
        {
            System.out.println(s);
        }
        //Anonymous class(Functional Interface
        name.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        //Lambda Expression
        name.forEach((String s1)->{
            System.out.println(s1);
        });
        //Even shorter version
        name.forEach((String s1)-> System.out.println(s1));
        //Method Reference
        //System.out::println --> For every element call println method
        name.forEach((System.out::println));
    }
}
