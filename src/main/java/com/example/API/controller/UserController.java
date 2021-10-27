package com.example.API.controller;

import com.example.API.model.User;
import com.example.API.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //CREATE
    //http://localhost:8080/createUser=<user>
    @PostMapping(value = "/createUser")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    //READ
    //http://localhost:8080/readUser=<user>
    @GetMapping("/readUser={id}")
    public Optional<User> readUser(@PathVariable Long id) {
        return userService.readUser(id);
    }
    //UPDATE
    //http://localhost:8080/updateUser=<user>
    @PutMapping("/updateUser")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }
    //DELETE
    //http://localhost:8080/deleteUser={id}
    @DeleteMapping("/deleteUser={id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(userService.readUser(id).get());
    }

}
