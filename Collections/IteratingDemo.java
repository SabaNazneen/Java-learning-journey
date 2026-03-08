package Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratingDemo {
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
        //Iterator
        Iterator<Integer> it =  integerList.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
            if(it.next()==2)
            {
                it.remove();
            }
        }
    }
}
