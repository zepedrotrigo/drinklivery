package com.tqs.drinkerly.controller;

import net.minidev.json.JSONObject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.tqs.drinkerly.model.User;
import com.tqs.drinkerly.repository.UserRepository;
import com.tqs.drinkerly.service.UserService;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.http.MediaType;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    private User user;

    @Autowired
    private MockMvc mvc;

    @MockBean
    UserRepository userRepository;

    @MockBean
    UserService userService;

    @BeforeEach
    void setUp() {
        user = new User("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, 259070137, "938349547",
        "josetrigo@ua.pt");
    }

    // Register tests

    // 1. Testar parameter validation do controller
    @Test
    void testValidRegister() throws Exception {
        when(userRepository.save(user)).thenReturn(user);

        mvc.perform(MockMvcRequestBuilders
        .post("/v1/users/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"firstName\": \"José\", \"lastName\": \"Trigo\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"age\": \"21\", \"nif\": \"259070137\", \"phone\": \"938349547\", \"email\": \"josetrigo@ua.pt\"}")
        )
        .andExpect(MockMvcResultMatchers.status().isCreated());
        
        Mockito.verify(userRepository, VerificationModeFactory.times(1)).save(Mockito.any(User.class));
    }

    @Test
    void testInvalidEmail_thenBadRequest() throws Exception {
        when(userRepository.save(user)).thenReturn(user);

        mvc.perform(MockMvcRequestBuilders
        .post("/v1/users/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content(
                "{\"firstName\": \"José\", \"lastName\": \"Trigo\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"age\": \"21\", \"nif\": \"259070137\", \"phone\": \"938349547\", \"email\": \"\"}"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());

        Mockito.verify(userRepository, VerificationModeFactory.times(0)).save(Mockito.any(User.class));
    }
    
    @Test
    void testInvalidFirstName_thenBadRequest() throws Exception {
        when(userRepository.save(user)).thenReturn(user);

        mvc.perform(MockMvcRequestBuilders
        .post("/v1/users/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content(
                "{\"firstName\": \"\", \"lastName\": \"Trigo\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"age\": \"21\", \"nif\": \"259070137\", \"phone\": \"938349547\", \"email\": \"\"}"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());

        Mockito.verify(userRepository, VerificationModeFactory.times(0)).save(Mockito.any(User.class));
    }
    
    @Test
    void testInvalidLastname_thenBadRequest() throws Exception {
        when(userRepository.save(user)).thenReturn(user);

        mvc.perform(MockMvcRequestBuilders
        .post("/v1/users/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content(
                "{\"firstName\": \"José\", \"lastName\": \"\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"age\": \"21\", \"nif\": \"259070137\", \"phone\": \"938349547\", \"email\": \"\"}"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());

        Mockito.verify(userRepository, VerificationModeFactory.times(0)).save(Mockito.any(User.class));
    }
    
    @Test
    void testInvalidNif_thenBadRequest() throws Exception {
        when(userRepository.save(user)).thenReturn(user);

        mvc.perform(MockMvcRequestBuilders
        .post("/v1/users/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content(
                "{\"firstName\": \"José\", \"lastName\": \"Trigo\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"age\": \"21\", \"nif\": \"\", \"phone\": \"938349547\", \"email\": \"\"}"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());

        Mockito.verify(userRepository, VerificationModeFactory.times(0)).save(Mockito.any(User.class));
    }
    
    @Test
    void testInvalidPhone_thenBadRequest() throws Exception {
        when(userRepository.save(user)).thenReturn(user);

        mvc.perform(MockMvcRequestBuilders
        .post("/v1/users/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"firstName\": \"José\", \"lastName\": \"Trigo\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"age\": \"21\", \"nif\": \"259070137\", \"phone\": \"\", \"email\": \"\"}")
        )
        .andExpect(MockMvcResultMatchers.status().isBadRequest());

        Mockito.verify(userRepository, VerificationModeFactory.times(0)).save(Mockito.any(User.class));
    }
    
}
