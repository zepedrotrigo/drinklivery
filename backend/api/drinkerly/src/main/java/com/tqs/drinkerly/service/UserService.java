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
    
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
