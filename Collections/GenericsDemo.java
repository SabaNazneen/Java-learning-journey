package Collections;

import java.util.*;

public class GenericsDemo {
    static void main() {
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(1);
        integerList.add(2);
        //For Each
        for(Integer integerList1:integerList)
        {
            System.out.println(integerList1);
        }
        //For Loop
        System.out.println("All users");
        for(int i=0;i<integerList.size();i++)
        {
            System.out.println(integerList.get(i));
        }
    }
}
