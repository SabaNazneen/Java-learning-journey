package org.saba.first.app.controller;

import org.saba.first.app.service.UserService;
import org.saba.first.app.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService = new UserService();
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    //Wrap karo Response Entity se
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        //HttpStatus is an Enum class which we use without explicitly using status codes
       // return ResponseEntity.status(HttpStatus.CREATED).body("User created");
       // return ResponseEntity.status(HttpStatus.CREATED).body(user);
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
       User updated = userService.updateUser(user);
       if(updated == null){
           return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

       }
        //return ResponseEntity.ok(user);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping
    public ResponseEntity<User> deleteUser(@RequestBody User user) {
        boolean isDeleted = userService.deleteUser(user);
        if(!isDeleted) {
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userService.getUser(id);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
   @GetMapping("/{userId}/orders/{orderId}")
    public ResponseEntity<User> getUserOrder(@PathVariable int userId,
                                             @PathVariable int orderId
    ) {
       User user = userService.getUser(userId);
       if(user == null) {
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(user);
    }
    //search?name=john
    @GetMapping("/search")
    public ResponseEntity<String> searchUsers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        List<User> users = userService.searchUsers(name, email);
        if(users.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("User not found");
        }
        return ResponseEntity.ok(users.toString());
    }

    @GetMapping("/info")
    public String getInfo(@RequestHeader("User-Agent") String userAgent) {
        return "User Agent: " + userAgent;
    }

    //EXCEPTION HANDLING METHOD
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String,Object>> handleIllegalArgumentException(
           IllegalArgumentException  exception
    ){
        Map<String,Object> errorResponce = new HashMap<>();
        errorResponce.put("message",exception.getMessage());
        return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
    }
}
