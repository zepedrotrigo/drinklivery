package com.tqs.drinkerly.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tqs.drinkerly.model.User;
import com.tqs.drinkerly.service.UserService;

@RestController
class UserController {
    @PostMapping("/v1/users/register")
    public ResponseEntity<User> registerUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String password, @RequestParam String address, @RequestParam int age,
    @RequestParam int nif, @RequestParam String phone, @RequestParam String email) {
        User user;

        if (password.length() < 8 || email == null || firstName == null || lastName == null || nif == 0 || phone == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            user = new User(firstName, lastName, password, address, age, nif, phone, email);
            UserService.registerUser(user);

        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
 