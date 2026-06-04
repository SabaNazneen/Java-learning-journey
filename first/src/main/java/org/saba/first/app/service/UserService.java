package org.saba.first.app.service;

import org.saba.first.app.controller.UserController;
import org.saba.first.app.exceptions.UserNotFoundException;
import org.saba.first.app.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private Map<Integer, User> userDB = new HashMap<Integer, User>();
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public User createUser(User user) {
        logger.info("Creating User....INFO");
        logger.debug("Creating User....DEBUG");
        logger.trace("Creating User....TRACE");
        logger.warn("Creating User....WARN");
        logger.error("Creating User....ERROR");
        System.out.println(user.getEmail());
        userDB.putIfAbsent(user.getId(),user);
        return user;
    }

    public User updateUser(User user) {
        if(!userDB.containsKey(user.getId())) {
            throw new UserNotFoundException("User with ID "+user.getId());
            //return new ResponseEntity.notFound().build();
            //return new ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        userDB.put(user.getId(), user);
        return user;
    }

    public boolean deleteUser(User user) {
        if(!userDB.containsKey(user.getId())) {
            return false;
        }
        userDB.remove(user.getId());
        return true;
    }

    public List<User> getAllUsers() {
        return new ArrayList<User>(userDB.values());
    }

    public User getUser(int id) {
        return userDB.get(id);
    }

    public List<User> searchUsers(String name, String email) {
       return userDB.values().stream()
                .filter(u->u.getName().equalsIgnoreCase(name))
                .toList();
    }
}
