package com.tqs.drinkerly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tqs.drinkerly.model.User;
import com.tqs.drinkerly.repository.UserRepository;

@RestController
class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/v1/users/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
 