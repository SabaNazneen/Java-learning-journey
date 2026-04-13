package javaoptionals;

import java.util.Optional;

public class FunctionalOperations {
    static void main() {
        Optional<String> name = Optional.of("John");
        Optional<String> nullOptional = Optional.ofNullable(null);
        //ifPresent()
        name.ifPresent(System.out::println);
        nullOptional.ifPresent(System.out::println);
        nullOptional.ifPresent(value->{
            System.out.println(value);
            System.out.println("Harry");
        });
        //map()
       Optional<String>upperCase = name.map(value->value.toUpperCase());
       System.out.println(upperCase.orElse("default"));

        //filter()
        name.filter(n->n.startsWith("F")).ifPresent(System.out::println);
        //Combined Operation
        name.filter(n->n.startsWith("F"))
                .map(String::toUpperCase)
                .ifPresent(System.out::println);

    }
}
