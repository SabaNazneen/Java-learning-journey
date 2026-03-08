package Collections;
import java.util.*;
public class MapDemo {
    static void main() {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        System.out.println(map.get(1));
        System.out.println("All users");
        for(Map.Entry<Integer, String> mpp: map.entrySet()) {
            System.out.println(mpp.getKey() + " : " + mpp.getValue());
        }
    }
}
