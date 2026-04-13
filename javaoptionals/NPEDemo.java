package javaoptionals;

import java.util.Optional;

public class NPEDemo {
    static void main() {
        String name="Java";
        if(name!=null)
        System.out.println(name.length());
        else
            System.out.println("No name value");
        //Optionals are introduced to handle excpetions like these
        Optional<String> optionalString = Optional.of("Java");
        System.out.println(optionalString);

        //empty optionals
        Optional<String> empty = Optional.empty();
        System.out.println(empty);

        //Null value optional
        Optional<String> mayBe = Optional.ofNullable(null);
        System.out.println(mayBe);

        //Checking values
        System.out.println(mayBe.isPresent());
        System.out.println(optionalString.isPresent());
        System.out.println(optionalString.isEmpty());
        System.out.println(empty.isPresent());
       // System.out.println(mayBe.get());

        //orElse("default-value")
        System.out.println(optionalString.orElse("default"));
        System.out.println(mayBe.orElse("default"));

        //orElseGet(<supllier>)
        String result = mayBe.orElseGet(()->{
            System.out.println("default value");
            return "default";
        });
        System.out.println(result);

        //orElseThrow()
        String newResult = optionalString.orElseThrow(() ->new RuntimeException("Not Found"));
        System.out.println(newResult);

    }
}
