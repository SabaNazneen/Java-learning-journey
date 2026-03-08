package Collections;
import java.util.*;
class A{
    String name;
    A(String name){
        this.name = name;
    }
}
public class SetDemo {
    static void main() {
        Set<String> roles = new HashSet<>();
        roles.add("ADMIN");
        roles.add("USER");
        roles.add("MANAGER");
        for(String role : roles) {
            System.out.println("Role: "+role);
        }
        A a1 = new A("A1");
        A a2 = new A("A2");
        A a3 = new A("A3");
        Set<A> traverse = new HashSet<>();
        traverse.add(a1);
        traverse.add(a2);
        traverse.add(a3);
        for( A a:traverse ) {
            System.out.println(a.name);
        }
    }
}
