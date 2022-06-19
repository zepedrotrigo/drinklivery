package com.tqs.drinkerly.repository;

import org.springframework.data.repository.CrudRepository;
import com.tqs.drinkerly.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}