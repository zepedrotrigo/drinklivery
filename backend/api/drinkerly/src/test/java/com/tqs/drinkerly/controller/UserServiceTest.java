package com.tqs.drinkerly.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tqs.drinkerly.model.User;
import com.tqs.drinkerly.repository.UserRepository;
import com.tqs.drinkerly.service.UserService;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class UserServiceTest{

    @MockBean
    private UserRepository uRep;

    @InjectMocks
    private UserService uServ;

    @Test
    void whenSearchUserById_thenReturnUser(){
        User u = new User();
        Mockito.when(uRep.findById(1L).get()).thenReturn(u);

        User u2 = uServ.getUserById(1L);

        assertEquals(u, u2);
    }
}
