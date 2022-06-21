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
import org.testcontainers.containers.MySQLContainer;
import com.google.common.base.Predicates;
import com.google.common.collect.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.tqs.drinkerly.model.Product;
import com.tqs.drinkerly.model.Winery;
import com.tqs.drinkerly.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.annotation.Rollback;


import org.assertj.core.api.Assertions;

import java.util.logging.Logger;

import java.util.logging.Level;

//a comment
@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTests {
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

	};

    private String email1 = "Vinho do Dão";
    private String email2 = "Vinho do Porto";
    private String email3 = "Vinho do Alentejo";

    @Autowired
    private ProductRepository pRep;


    @Test
    @Order(1)
    @Rollback(false)
    public void saveProductTest(){

<<<<<<< HEAD
        Winery winery = new Winery("Adega 1", "Lagar Esquerdo", 222222222, "987646321", "wine@email.com", "testingpassword12345", "www.wine.com");
=======
        Winery winery = new Winery("Adega 1", "Lagar Esquerdo", 222222222, "987646321", "wine@email.com", "testingpassword123", "www.wine.com");
>>>>>>> 057ef115bcf7524204a2e38f0143c9d662022263

        Product p = new Product(email1, "Red", "Portugal", "Dão", "encruzado", 
        "bebe-se", 23.00, 13.52, 24.50, 30.50,
        4.65, 42.00, 55, winery);
        pRep.save(p);


        Product p2 = new Product(email2, "Red", "Portugal", "Douro", "encruzado", 
        "Transportado em barco rabelo", 23.00, 13.52, 20.50, 35.50,
        4.65, 42.00, 85, winery);
        pRep.save(p2);

        //Assertions.assertThat(p.getId()).isGreaterThan(0);
        Assertions.assertThat(pRep.findByName(email1));
        Assertions.assertThat(pRep.findByName(email2));
    }
    
    @Test
    @Order(2)
    public void getProduct_Test(){
        
        Product p3 = pRep.findByName(email1);
        
        Assertions.assertThat(p3).isEqualTo(pRep.findByName(email1));
    }

    @Test
    @Order(3)
    public void getListOfProducts_Test(){

        //List<Product> products = (List<Product>) pRep.findAll();

        List<Product> products = new ArrayList<>();
         products.add(pRep.findByName(email1));

        Assertions.assertThat(products.size()).isGreaterThan(0);
    } 

    @Test
    @Order(4)
    public void updateProduct_Test(){

        if (pRep.findByName(email3) != null){
            pRep.delete(pRep.findByName(email3));
        }

        Product p = pRep.findByName(email2);
        Assertions.assertThat(p).isNotNull();
    
        Product pUpdated =  pRep.findByName(email1);
        pUpdated.setName(email3);
        pRep.saveAndFlush(pUpdated);

        Assertions.assertThat(pUpdated.getName()).isEqualTo(email3);
    }

    /*@Test
    @Order(5)
    public void deleteProduct_Test(){
        Assertions.assertThat(pRep.findByName(email2));
        Product p = pRep.findByName(email2);
        Assertions.assertThat(p).isNotNull();
        pRep.delete(p);

        Product p1 = pRep.findByName(email2);

        Assertions.assertThat(p1).isNull();
    }*/
}
    