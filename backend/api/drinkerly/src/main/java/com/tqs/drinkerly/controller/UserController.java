package com.tqs.drinkerly.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tqs.drinkerly.service.RequestService;
import com.tqs.drinkerly.service.UserService;
import com.tqs.drinkerly.model.Product;
import com.tqs.drinkerly.service.ProductService;

@RestController
class UserController {
    @Autowired
    RequestService reqserv;

    @Autowired
    ProductService productService;
    
    @PostMapping("/v1/register_user")
    public int registerUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String password, @RequestParam String address, @RequestParam int age,
            @RequestParam int nif, @RequestParam String phone, @RequestParam String email) {

        UserService.registerUser(firstName, lastName, password, address, age, nif, phone, email);
        return 200;
    }
}
 