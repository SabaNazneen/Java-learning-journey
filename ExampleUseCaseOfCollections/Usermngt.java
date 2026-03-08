package ExampleUseCaseOfCollections;
import java.util.*;
public class Usermngt {
    static void main() {

        List <Users> usersList = new ArrayList<>();
        usersList.add(new Users("Alice",true,new HashSet<>(Arrays.asList("ADMIN","USER"))));
        usersList.add(new Users("Bob",false,new HashSet<>(Arrays.asList("USER"))));
        usersList.add(new Users("Carlos",true,new HashSet<>(Arrays.asList("USER"))));
        // Remove Inactive users
        Iterator <Users>iterator = usersList.iterator();
        while(iterator.hasNext()){
            if(!iterator.next().isActive())
            {
                iterator.remove();
            }
        }
        //Print Active Users
        System.out.println("Active users");
        for(Users user:usersList)
        {
            System.out.println(user.getName());
        }
        //Count Users Per role
        Map<String,Integer> roleCount = new HashMap<>();
        for(Users user:usersList)
        {
            for(String role:user.getRoles())
            {
                roleCount.put(role,roleCount.getOrDefault(role,0)+1);
            }
        }
        System.out.println("Role count");
        for(Map.Entry<String,Integer>entry:roleCount.entrySet())
        {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}
