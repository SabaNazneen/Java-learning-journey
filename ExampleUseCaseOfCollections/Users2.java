package ExampleUseCaseOfCollections;
import java.util.*;
public class Users2 {
    private String name;
    private boolean active;
    private Set<String> role;
    public Users2(String name,Boolean active,Set<String> role){
        this.name = name;
        this.active = active;
        this.role = role;
    }

    public Set<String> getRole() {
        return role;
    }

    public String getName() {
        return name;
    }
    public boolean isActive() {
        return active;
    }
}
