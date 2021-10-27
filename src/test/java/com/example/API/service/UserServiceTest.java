package com.example.API.service;

import com.example.API.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.util.Optional;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;
    User user = new User("john", "doe", "jdoe", "johndoe@email.com", "0102030405");

    @Test
    void createUserTest() {
        userService.createUser(user);

        Assertions.assertEquals("john", userService.readUser(user.getId()).get().getFirstName());
        userService.deleteUser(user);
    }

    @Test
    void readUserTest() {
        userService.createUser(user);

        Optional<User> userSelected = userService.readUser(user.getId());
        String firstName = userSelected.get().getFirstName();

        Assertions.assertEquals("john", firstName);
        userService.deleteUser(user);
    }

    @Test
    void updateUserTest() {
        userService.createUser(user);


        user.setFirstName("John updated");
        userService.updateUser(user);

        Assertions.assertEquals("John updated", userService.readUser(user.getId()).get().getFirstName());
        userService.deleteUser(user);

    }

    @Test
    void deleteUserTest() {
        userService.createUser(user);
        Long id = user.getId();

        userService.deleteUser(user);

        Assertions.assertFalse(userService.readUser(id).isPresent());
    }
}