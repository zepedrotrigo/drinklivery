package com.tqs.drinkerly.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tqs.drinkerly.service.UserService;

@RestController
class UserController {
    @PostMapping("/v1/users")
    public int registerUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String password, @RequestParam String address, @RequestParam int age,
            @RequestParam int nif, @RequestParam String phone, @RequestParam String email) {

        UserService.registerUser(firstName, lastName, password, address, age, nif, phone, email);
        return 200;
    }
}
 