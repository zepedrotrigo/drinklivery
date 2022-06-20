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

import com.tqs.drinkerly.model.Winery;
import com.tqs.drinkerly.repository.WineryRepository;
import com.tqs.drinkerly.service.WineryService;

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

@WebMvcTest(WineryController.class)
public class WineryControllerTest {
    private Winery winery;

    @Autowired
    private MockMvc mvc;

    @MockBean
    WineryRepository wineryRepository;

    @MockBean
    WineryService wineryService;

    @BeforeEach
    void setUp() {
        winery = new Winery("Vinhos Duorum", "Campus de Santiago", 259070137, "938349547", "duorum@gmail.com", "testingpassword123", "www.duorum.pt");
    }

    // Register tests

    // 1. Testar parameter validation do controller
    @Test
    void testValidRegister() throws Exception {
        when(wineryRepository.save(winery)).thenReturn(winery);

        mvc.perform(MockMvcRequestBuilders
        .post("/v1/wineries/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"Vinhos Duorum\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"nif\": \"259070137\", \"phone\": \"938349547\", \"email\": \"duorum@gmail.com\", \"website\": \"www.duorum.pt\"}")
        )
        .andExpect(MockMvcResultMatchers.status().isCreated());
        
        Mockito.verify(wineryRepository, VerificationModeFactory.times(1)).save(Mockito.any(Winery.class));
    }

    @Test
    void testInvalidName_thenBadRequest() throws Exception {
        when(wineryRepository.save(winery)).thenReturn(winery);

        mvc.perform(MockMvcRequestBuilders
                .post("/v1/wineries/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                        "{\"name\": \"\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"nif\": \"259070137\", \"phone\": \"938349547\", \"email\": \"duorum@gmail.com\", \"website\": \"www.duorum.pt\"}"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

        Mockito.verify(wineryRepository, VerificationModeFactory.times(0)).save(Mockito.any(Winery.class));
    }

    @Test
    void testInvalidPassword_thenBadRequest() throws Exception {
        when(wineryRepository.save(winery)).thenReturn(winery);

        mvc.perform(MockMvcRequestBuilders
        .post("/v1/wineries/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content(
            "{\"name\": \"Vinhos Duorum\", \"password\": \"\", \"address\": \"Campus de Santiago\", \"nif\": \"259070137\", \"phone\": \"938349547\", \"email\": \"duorum@gmail.com\", \"website\": \"www.duorum.pt\"}"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());

        Mockito.verify(wineryRepository, VerificationModeFactory.times(0)).save(Mockito.any(Winery.class));
    }
    
    @Test
    void testInvalidAddress_thenBadRequest() throws Exception {
        when(wineryRepository.save(winery)).thenReturn(winery);

        mvc.perform(MockMvcRequestBuilders
                .post("/v1/wineries/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                        "{\"name\": \"Vinhos Duorum\", \"password\": \"testingpassword123\", \"address\": \"\", \"nif\": \"259070137\", \"phone\": \"938349547\", \"email\": \"duorum@gmail.com\", \"website\": \"www.duorum.pt\"}"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

        Mockito.verify(wineryRepository, VerificationModeFactory.times(0)).save(Mockito.any(Winery.class));
    }
    
    @Test
    void testInvalidNif_thenBadRequest() throws Exception {
        when(wineryRepository.save(winery)).thenReturn(winery);

        mvc.perform(MockMvcRequestBuilders
        .post("/v1/wineries/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content(
            "{\"name\": \"Vinhos Duorum\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"nif\": \"\", \"phone\": \"938349547\", \"email\": \"duorum@gmail.com\", \"website\": \"www.duorum.pt\"}"))        .andExpect(MockMvcResultMatchers.status().isBadRequest());

        Mockito.verify(wineryRepository, VerificationModeFactory.times(0)).save(Mockito.any(Winery.class));
    }

    @Test
    void testInvalidPhone_thenBadRequest() throws Exception {
        when(wineryRepository.save(winery)).thenReturn(winery);

        mvc.perform(MockMvcRequestBuilders
        .post("/v1/wineries/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content(
            "{\"name\": \"Vinhos Duorum\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"nif\": \"259070137\", \"phone\": \"\", \"email\": \"duorum@gmail.com\", \"website\": \"www.duorum.pt\"}"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());

        Mockito.verify(wineryRepository, VerificationModeFactory.times(0)).save(Mockito.any(Winery.class));
    }

    @Test
    void testInvalidEmail_thenBadRequest() throws Exception {
        when(wineryRepository.save(winery)).thenReturn(winery);

        mvc.perform(MockMvcRequestBuilders
        .post("/v1/wineries/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content(
            "{\"name\": \"Vinhos Duorum\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"nif\": \"259070137\", \"phone\": \"938349547\", \"email\": \"\", \"website\": \"www.duorum.pt\"}"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());

        Mockito.verify(wineryRepository, VerificationModeFactory.times(0)).save(Mockito.any(Winery.class));
    }
}
