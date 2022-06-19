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

import com.tqs.drinkerly.model.Rider;
import com.tqs.drinkerly.repository.RiderRepository;
import com.tqs.drinkerly.service.RiderService;

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

@WebMvcTest(RiderController.class)
public class RiderControllerTest {
    private Rider rider;

    @Autowired
    private MockMvc mvc;

    @MockBean
    RiderRepository riderRepository;

    @MockBean
    RiderService riderService;

    @BeforeEach
    void setUp() {
        rider = new Rider("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, 259070137, "938349547",
        "josetrigo@ua.pt", "motorcycle", "00-AB-99");
    }

    // Register tests

    // 1. Testar parameter validation do controller
    @Test
    void testValidRegister() throws Exception {
        when(riderRepository.save(rider)).thenReturn(rider);

        mvc.perform(MockMvcRequestBuilders
        .post("/v1/riders/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"firstName\": \"José\", \"lastName\": \"Trigo\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"age\": \"21\", \"nif\": \"259070137\", \"phone\": \"938349547\", \"email\": \"josetrigo@ua.pt\", \"vehicleType\": \"motorcycle\", \"licensePlate\": \"00-AB-99\"}")
        )
        .andExpect(MockMvcResultMatchers.status().isCreated());
        
        Mockito.verify(riderRepository, VerificationModeFactory.times(1)).save(Mockito.any(Rider.class));
    }

    @Test
    void testInvalidEmail_thenBadRequest() throws Exception {
        when(riderRepository.save(rider)).thenReturn(rider);

        mvc.perform(MockMvcRequestBuilders
        .post("/v1/riders/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content(
                "{\"firstName\": \"José\", \"lastName\": \"Trigo\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"age\": \"21\", \"nif\": \"259070137\", \"phone\": \"938349547\", \"email\": \"\", \"vehicleType\": \"motorcycle\", \"licensePlate\": \"00-AB-99\"}"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());

        Mockito.verify(riderRepository, VerificationModeFactory.times(0)).save(Mockito.any(Rider.class));
    }
    
    @Test
    void testInvalidFirstName_thenBadRequest() throws Exception {
        when(riderRepository.save(rider)).thenReturn(rider);

        mvc.perform(MockMvcRequestBuilders
        .post("/v1/riders/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content(
                "{\"firstName\": \"\", \"lastName\": \"Trigo\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"age\": \"21\", \"nif\": \"259070137\", \"phone\": \"938349547\", \"email\": \"\", \"vehicleType\": \"motorcycle\", \"licensePlate\": \"00-AB-99\"}"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());

        Mockito.verify(riderRepository, VerificationModeFactory.times(0)).save(Mockito.any(Rider.class));
    }
    
    @Test
    void testInvalidLastname_thenBadRequest() throws Exception {
        when(riderRepository.save(rider)).thenReturn(rider);

        mvc.perform(MockMvcRequestBuilders
        .post("/v1/riders/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content(
                "{\"firstName\": \"José\", \"lastName\": \"\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"age\": \"21\", \"nif\": \"259070137\", \"phone\": \"938349547\", \"email\": \"\", \"vehicleType\": \"motorcycle\", \"licensePlate\": \"00-AB-99\"}"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());

        Mockito.verify(riderRepository, VerificationModeFactory.times(0)).save(Mockito.any(Rider.class));
    }
    
    @Test
    void testInvalidNif_thenBadRequest() throws Exception {
        when(riderRepository.save(rider)).thenReturn(rider);

        mvc.perform(MockMvcRequestBuilders
        .post("/v1/riders/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content(
                "{\"firstName\": \"José\", \"lastName\": \"Trigo\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"age\": \"21\", \"nif\": \"\", \"phone\": \"938349547\", \"email\": \"\", \"vehicleType\": \"motorcycle\", \"licensePlate\": \"00-AB-99\"}"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());

        Mockito.verify(riderRepository, VerificationModeFactory.times(0)).save(Mockito.any(Rider.class));
    }
    
    @Test
    void testInvalidPhone_thenBadRequest() throws Exception {
        when(riderRepository.save(rider)).thenReturn(rider);

        mvc.perform(MockMvcRequestBuilders
        .post("/v1/riders/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"firstName\": \"José\", \"lastName\": \"Trigo\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"age\": \"21\", \"nif\": \"259070137\", \"phone\": \"\", \"email\": \"\", \"vehicleType\": \"motorcycle\", \"licensePlate\": \"00-AB-99\"}")
        )
        .andExpect(MockMvcResultMatchers.status().isBadRequest());

        Mockito.verify(riderRepository, VerificationModeFactory.times(0)).save(Mockito.any(Rider.class));
    }
}
