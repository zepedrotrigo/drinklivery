package com.tqs.drinkerly.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import com.google.common.base.Predicates;
import com.google.common.collect.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.tqs.drinkerly.model.User;
import com.tqs.drinkerly.repository.UserRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.test.context.junit4.SpringRunner;


import org.assertj.core.api.Assertions;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTests {

    @Autowired
    private UserRepository uRep;

    @Test
    @Order(1)
    public void saveUserTest(){

        User u = new User("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, 259070137, "938349547", "josetrigo@ua.pt");

        uRep.save(u);

        Assertions.assertThat(u.getId()).isGreaterThan(0);
    }
    
    @Test
    @Order(2)
    public void getUser_Test(){

        User u = uRep.findById(1L).get();

        Assertions.assertThat(u.getId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    public void getListOfUsers_Test(){

        List<User> users = (List<User>) uRep.findAll();

        Assertions.assertThat(users.size()).isGreaterThan(0);
    } 

    @Test
    @Order(4)
    public void updateUser_Test(){

        User u = uRep.findById(1L).get();

        u.setEmail("renatoaldias12@ua.pt");

        User uUpdated = uRep.save(u);

        Assertions.assertThat(uUpdated.getEmail()).isEqualTo("renatoaldias12@ua.pt");
    }

    @Test
    @Order(5)
    public void deleteUser_Test(){

        User u = uRep.findById(1L).get();

        uRep.delete(u);

        //uRep.deleteById(1L);

        User u1 = null;

        Optional<User> optionalUser = uRep.findByEmail("renatoaldias12@ua.pt");

        if(optionalUser.isPresent()){
            u1 = optionalUser.get();
        }

        Assertions.assertThat(u1).isNull();
    }
}
