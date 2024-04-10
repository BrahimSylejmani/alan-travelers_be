package org.alan.flightbooking.controller;

import org.alan.flightbooking.model.User;
import org.alan.flightbooking.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(path = "/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping(path = "/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(path = "/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping(path = "/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){

        if(id == null || user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userService.update(id, user));
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.delete(id);
    }




}
