package com.tqs.drinkerly.repository;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
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

import java.util.logging.Logger;

import java.util.logging.Level;

//a comment
@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTests {

    @Autowired
    private UserRepository uRep;

    Logger logger
            = Logger.getLogger(
                UserRepositoryTests.class.getName());

    @Test
    @Order(1)
    public void saveUserTest(){

        User u = new User("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, 
        259070137, "938349547", "josetrigo2@ua.pt");

        uRep.save(u);

        Assertions.assertThat(u.getId()).isGreaterThan(0);
    }
    
    @Test
    @Order(2)
    public void getUser_Test(){
        
        User u2 = uRep.findByEmail("josetrigo2@ua.pt");
        
        Assertions.assertThat(u2.getId()).isEqualTo(uRep.findByEmail("josetrigo2@ua.pt").getId());
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

        //User u = uRep.findByEmail("josetrigo2@ua.pt");

        
        //System.out.println(u.toString());
     

        User uUpdated =  uRep.findByEmail("josetrigo2@ua.pt");
        uUpdated.setEmail("renatoaldias12@ua.pt");
        uRep.saveAndFlush(uUpdated);

        Assertions.assertThat(uUpdated.getEmail()).isEqualTo("renatoaldias12@ua.pt");
    }

    @Test
    @Order(5)
    public void deleteUser_Test(){

        User u = uRep.findByEmail("renatoaldias12@ua.pt");

        uRep.delete(u);

        //uRep.deleteById(1L);

        User u1 = uRep.findByEmail("renatoaldias12@ua.pt");;

       

        

        Assertions.assertThat(u1).isNull();
    }
}
