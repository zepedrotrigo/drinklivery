package com.tqs.drinkerly.repository;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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

import com.tqs.drinkerly.model.Rider;
import com.tqs.drinkerly.repository.RiderRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.test.context.junit4.SpringRunner;


import org.assertj.core.api.Assertions;

import java.util.logging.Logger;

import java.util.logging.Level;


@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RiderRepositoryTests {

    @Autowired
    private RiderRepository rRep;

    @Test
    @Order(1)
    public void saveRiderTest(){

        Rider r = new Rider("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, 259070137, "938349547",
        "josetrigo@ua.pt", "motorcycle", "00-AB-99");

        rRep.save(r);

        Assertions.assertThat(r.getId()).isGreaterThan(0);
    }
    
    
    @Test
    @Order(2)
    public void getRider_Test(){
        
        Rider r2 = rRep.findByEmail("josetrigo@ua.pt");
        
        Assertions.assertThat(r2.getId()).isEqualTo(rRep.findByEmail("josetrigo@ua.pt").getId());
    }
    
    @Test
    @Order(3)
    public void getListOfRiders_Test(){

        List<Rider> riders = (List<Rider>) rRep.findAll();

        Assertions.assertThat(riders.size()).isGreaterThan(0);
    } 
    
    @Test
    @Order(4)
    public void updateRiders_Test(){

        //User u = uRep.findByEmail("josetrigo2@ua.pt");

        
        //System.out.println(u.toString());
     

        Rider rUpdated =  rRep.findByEmail("josetrigo@ua.pt");
        rUpdated.setEmail("josetrigo2@ua.pt");
        rRep.saveAndFlush(rUpdated);

        Assertions.assertThat(rUpdated.getEmail()).isEqualTo("josetrigo2@ua.pt");
        assertThat(rRep.count()).isGreaterThan(0);
    }
    
    /*@Test
    @Order(5)
    public void deleteRiders_Test(){

        Rider r = rRep.findByEmail("josetrigo@ua.pt");

        assertThat(rRep.count()).isGreaterThan(0);

        rRep.deleteByEmail(r.getEmail());

        //uRep.deleteById(1L);
        Rider r1 = rRep.findByEmail("josetrigo@ua.pt");

        Assertions.assertThat(r1).isNull();
    }*/
    
}
