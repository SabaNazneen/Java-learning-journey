package org.saba.first.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private Map<Integer,User> userDB = new HashMap<Integer, User>();
    @PostMapping
    //Wrap karo Response Entity se
    public ResponseEntity<User> createUser(@RequestBody User user) {
        System.out.println(user.getEmail());
        userDB.putIfAbsent(user.getId(), user);
        //HttpStatus is an Enum class which we use without explicitly using status codes
       // return ResponseEntity.status(HttpStatus.CREATED).body("User created");
       // return ResponseEntity.status(HttpStatus.CREATED).body(user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        if(!userDB.containsKey(user.getId())) {
            return new ResponseEntity<>(user,HttpStatus.NOT_FOUND);
            //return new ResponseEntity.notFound().build();
            //return new ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        userDB.put(user.getId(), user);
        return new ResponseEntity<>(user,HttpStatus.OK);
        //return ResponseEntity.ok(user);
    }
    @DeleteMapping
    public ResponseEntity<User> deleteUser(@RequestBody User user) {
        if(!userDB.containsKey(user.getId())) {
           return ResponseEntity.notFound().build();
        }
        userDB.remove(user.getId());
        return ResponseEntity.ok(user);
    }
    @GetMapping
    public List<User> getAllUsers() {
        return new ArrayList<User>(userDB.values());
    }
}
