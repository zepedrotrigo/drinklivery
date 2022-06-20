package com.tqs.drinkerly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.tqs.drinkerly.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);

    void saveAndFlush(User uUpdated);

    
}