package com.example.API.service;

import com.example.API.model.User;
import com.example.API.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> readUser(Long id) {
        return userRepository.findById(id);
    }

    public void updateUser(User user) {
        User userSelected = userRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User with " + user.getId() + "not found"));
        userSelected.setEmail(user.getEmail());
        userSelected.setFirstName(user.getFirstName());
        userSelected.setLastName(user.getLastName());
        userSelected.setPhone(user.getPhone());
        userSelected.setSurname(user.getSurname());

        userRepository.save(userSelected);
    }


    public void deleteUser(User user) {
        userRepository.delete(user);
    }

}
