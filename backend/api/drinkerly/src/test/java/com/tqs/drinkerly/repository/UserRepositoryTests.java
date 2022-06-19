package com.tqs.drinkerly.repository;

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

import org.springframework.test.context.junit4.SpringRunner;


import org.assertj.core.api.Assertions;


@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTests {

    @Autowired
    private UserRepository uRep;

    @Test
    public void saveUserTest(){

        User u = new User("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, 259070137, "938349547",
        "josetrigo@ua.pt");

        uRep.save(u);

        Assertions.assertThat(u.getId()).isGreaterThan(0);
    }

}
