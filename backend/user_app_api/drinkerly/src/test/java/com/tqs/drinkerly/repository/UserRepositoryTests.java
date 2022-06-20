package com.tqs.drinkerly.repository;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.*;
import org.testcontainers.containers.MySQLContainer;
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
import org.junit.jupiter.api.BeforeEach;

//a comment
@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTests {

    @Container
	public static MySQLContainer<?> mySqlDB = new MySQLContainer<>
			("mysql:5.7.37")
			.withDatabaseName("drinklivery")
			.withUsername("user")
			.withPassword("password");


	@DynamicPropertySource
	public static void properties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url",mySqlDB::getJdbcUrl);
		registry.add("spring.datasource.username", mySqlDB::getUsername);
		registry.add("spring.datasource.password", mySqlDB::getPassword);

	}


    @Autowired
    private UserRepository uRep;

    private String email1 = "josetrigo2@ua.pt";
    private String email2 = "josefina2@ua.pt";
    private String email3 = "renatoaldias12@ua.pt";
   

    @Test
    @Order(1)
    public void saveUserTest(){

        User u = new User("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, 
        259070137, "938349557", email1);
        uRep.save(u);


        User u2 = new User("Josefina", "Marta", "testingpassword1234", "Campus de Santiago2", 21, 
        259070139, "938349547", email2);
        uRep.save(u2);

        Assertions.assertThat(u.getId()).isGreaterThan(0);
    }
    
    @Test
    @Order(2)
    public void getUser_Test(){
        
        User u3 = uRep.findByEmail( email1);
        
        Assertions.assertThat(u3.getId()).isEqualTo(uRep.findByEmail( email1).getId());
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

        if (uRep.findByEmail(email3) != null){
            uRep.delete(uRep.findByEmail(email3));
        }
     

        User uUpdated =  uRep.findByEmail( email1);
        uUpdated.setEmail(email3);
        uRep.saveAndFlush(uUpdated);

        Assertions.assertThat(uUpdated.getEmail()).isEqualTo(email3);
    }

    @Test
    @Order(5)
    public void deleteUser_Test(){

        User u = uRep.findByEmail(email2);

        uRep.delete(u);

        User u1 = uRep.findByEmail(email2);;

        Assertions.assertThat(u1).isNull();
    }
}
