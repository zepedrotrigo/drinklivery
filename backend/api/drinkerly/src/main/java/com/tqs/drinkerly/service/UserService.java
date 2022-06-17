package com.tqs.drinkerly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqs.drinkerly.model.User;
import com.tqs.drinkerly.repository.UserRepository;

@Service
public class UserService {
    private static UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        UserService.userRepository = userRepository;
    }

    public static void save(User user) {
        userRepository.save(user);
    }

    public static void registerUser(String firstName, String lastName, String password, String address, int age, int nif, String phone, String email) {
        User user = new User(firstName, lastName, password, address, age, nif, phone, email);
        save(user);
    }

    
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
