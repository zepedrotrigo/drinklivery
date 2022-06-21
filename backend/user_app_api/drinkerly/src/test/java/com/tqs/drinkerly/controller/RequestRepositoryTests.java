package com.tqs.drinkerly.controller;
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

import com.tqs.drinkerly.model.Product;
import com.tqs.drinkerly.model.Request;
import com.tqs.drinkerly.model.User;
import com.tqs.drinkerly.model.Rider;
import com.tqs.drinkerly.repository.RequestRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.test.context.junit4.SpringRunner;


import org.assertj.core.api.Assertions;

import java.util.logging.Logger;

import java.util.logging.Level;
import org.junit.jupiter.api.BeforeEach;
@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RequestRepositoryTests {
   private Rider deliverRider = new Rider("firstName", "lastName", "password", "address", 22, 222222222,
      "987654321", "email", "vehicleType", "licensePlate");
   private User user = new User("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, 
      259070137, "938349557", "email1");
   private Product p = new Product();
      List<Product> productList = new ArrayList<>();
      
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
   private RequestRepository rRep;

   @Test
   @Order(1)
   public void saveRequestTest(){
      productList.add(p);
      
      Request req = new Request(deliverRider, user, productList);
      rRep.save(req);

      Assertions.assertThat(req.getId()).isGreaterThan(0);
   }

  

}
