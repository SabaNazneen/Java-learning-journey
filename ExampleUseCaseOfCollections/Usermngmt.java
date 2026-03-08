package ExampleUseCaseOfCollections;
import java.util.*;

public class Usermngmt {
    static void main() {
        ArrayList<Users2> users2 = new ArrayList<>();
        users2.add(new Users2("Alice",true,new HashSet<>(Arrays.asList("ADMIN","USERS"))));
        users2.add(new Users2("Bob",false,new HashSet<>(Arrays.asList("MANAGER"))));
        users2.add(new Users2("Carlos",true,new HashSet<>(Arrays.asList("USER"))));
        users2.add(new Users2("Daniel",false,new HashSet<>(Arrays.asList("ADMIN"))));
        Iterator<Users2> iterator = users2.iterator();
            while(iterator.hasNext())
            {
                if(!iterator.next().isActive())
                {
                    iterator.remove();
            }
        }
        System.out.println("Active users: ");
            for(Users2 user:users2)
            {
                System.out.println(user.getName());
            }
            Map<String,Integer> roleCount = new HashMap<>();
            for(Users2 user:users2)
            {
                for(String role:user.getRole()) {
                    roleCount.put(role, roleCount.getOrDefault(role, 0) + 1);
                }
            }
            for(Map.Entry<String,Integer> entry:roleCount.entrySet())
            {
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }
    }
}
