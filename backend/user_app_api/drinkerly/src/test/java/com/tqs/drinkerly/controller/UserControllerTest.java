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
                .content(
                        "{\"firstName\": \"José\", \"lastName\": \"Trigo\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"age\": \"21\", \"nif\": \"259070137\", \"phone\": \"\", \"email\": \"\"}"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

        Mockito.verify(userRepository, VerificationModeFactory.times(0)).save(Mockito.any(User.class));
    }
    
    // Register login

    @Test
    void testValidLogin() throws Exception {
        when(userService.getUserByEmail(Mockito.any(String.class))).thenReturn(user);

        mvc.perform(post("/v1/users/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.format("{\"email\": \"%s\", \"password\": \"%s\"}", user.getEmail(),
                        user.getPassword()))
                )
                .andExpect(status().isAccepted());

        Mockito.verify(userService, VerificationModeFactory.times(1)).getUserByEmail(Mockito.any(String.class));
    }

    @Test
    void testInvalidEmail() throws Exception {
        when(userService.getUserByEmail(Mockito.any(String.class))).thenThrow(new NullPointerException("Exception: Invalid Email"));

        mvc.perform(post("/v1/users/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.format("{\"email\": \"%s\", \"password\": \"%s\"}", "invalidEmail", user.getPassword()))
                )
                .andExpect(status().isNotFound());

        Mockito.verify(userService, VerificationModeFactory.times(1)).getUserByEmail(Mockito.any(String.class));
    }

    @Test
    void testInvalidPassword() throws Exception {
        when(userService.getUserByEmail(Mockito.any(String.class))).thenReturn(user);

        mvc.perform(post("/v1/users/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.format("{\"email\": \"%s\", \"password\": \"%s\"}", user.getEmail(), "invalidPassword"))
                )
                .andExpect(status().isForbidden());

        Mockito.verify(userService, VerificationModeFactory.times(1)).getUserByEmail(Mockito.any(String.class));
    }
    
    @Test
	void testGetUserById_existentId() throws Exception {

        when(userService.getUserById(user.getId())).thenReturn(user);

        mvc.perform(MockMvcRequestBuilders
        .get("/v1/users/" + user.getId())
        .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk())
		.andExpect(jsonPath("firstName", is(user.getFirstName())))
		.andExpect(jsonPath("lastName", is(user.getLastName())))
        .andExpect(jsonPath("password", is(user.getPassword())))
        .andExpect(jsonPath("address", is(user.getAddress())))
		.andExpect(jsonPath("age", is(user.getAge())))
		.andExpect(jsonPath("nif", is(user.getNif())))
		.andExpect(jsonPath("phone", is(user.getPhone())))
        .andExpect(jsonPath("email", is(user.getEmail())));


    }
    /*
    @Test
	void testGetUserById_InexistentId() throws Exception {

        mvc.perform(MockMvcRequestBuilders
        .get("/v1/users/0")
        .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isNotFound());


    }

    @Test
	void testDeleteUserById_existentId() throws Exception {

		when(userService.getUserById(user.getId())).thenReturn(user);

		mvc.perform(MockMvcRequestBuilders
        .delete("/v1/users/" + user.getId())
        .contentType(MediaType.APPLICATION_JSON)
        )
		.andExpect(status().isNoContent());
	}

	@Test
	void testDeleteUserById_inexistentId() throws Exception {

		mvc.perform(MockMvcRequestBuilders
        .delete("/v1/users/0")
        .contentType(MediaType.APPLICATION_JSON)
        )
		.andExpect(status().isNotFound());
	}

    @Test
	void testUpdateUserFirstNameById_userDoesNotExist() throws Exception {

		//String userJsonString = mapper.writeValueAsString(userDTO);

		mvc.perform(MockMvcRequestBuilders
        .put("/v1/users/firstName/0")
        .contentType(MediaType.APPLICATION_JSON)
		)
		.andExpect(status().isNotFound());
	}

    @Test
	void testUpdateUserFirstNameById_completeUpdate() throws Exception {

		when(userService.getUserById(user.getId())).thenReturn(user);

		user.setFirstName("Renato");

		mvc.perform(MockMvcRequestBuilders
        .put("/v1/users/firstName/" + user.getId())
        .content("{\"firstName\": \"Renato\", \"lastName\": \"Trigo\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"age\": \"21\", \"nif\": \"259070137\", \"phone\": \"938349547\", \"email\": \"josetrigo@ua.pt\"}")
        .contentType(MediaType.APPLICATION_JSON)
		)
        .andExpect(status().isOk())
		.andExpect(jsonPath("firstName", is(user.getFirstName())))
		.andExpect(jsonPath("lastName", is(user.getLastName())))
        .andExpect(jsonPath("password", is(user.getPassword())))
        .andExpect(jsonPath("address", is(user.getAddress())))
		.andExpect(jsonPath("age", is(user.getAge())))
		.andExpect(jsonPath("nif", is(user.getNif())))
		.andExpect(jsonPath("phone", is(user.getPhone())))
        .andExpect(jsonPath("email", is(user.getEmail())));
	}

    @Test
	void testUpdateUserLastNameById_userDoesNotExist() throws Exception {

		//String userJsonString = mapper.writeValueAsString(userDTO);

		mvc.perform(MockMvcRequestBuilders
        .put("/v1/users/lastName/0")
        .contentType(MediaType.APPLICATION_JSON)
		)
		.andExpect(status().isNotFound());
	}

    @Test
	void testUpdateUserLastNameById_completeUpdate() throws Exception {

		when(userService.getUserById(user.getId())).thenReturn(user);

		user.setLastName("Dias");

		mvc.perform(MockMvcRequestBuilders
        .put("/v1/users/lastName/" + user.getId())
        .content("{\"firstName\": \"José\", \"lastName\": \"Dias\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"age\": \"21\", \"nif\": \"259070137\", \"phone\": \"938349547\", \"email\": \"josetrigo@ua.pt\"}")
        .contentType(MediaType.APPLICATION_JSON)
		)
        .andExpect(status().isOk())
		.andExpect(jsonPath("firstName", is(user.getFirstName())))
		.andExpect(jsonPath("lastName", is(user.getLastName())))
        .andExpect(jsonPath("password", is(user.getPassword())))
        .andExpect(jsonPath("address", is(user.getAddress())))
		.andExpect(jsonPath("age", is(user.getAge())))
		.andExpect(jsonPath("nif", is(user.getNif())))
		.andExpect(jsonPath("phone", is(user.getPhone())))
        .andExpect(jsonPath("email", is(user.getEmail())));
	}

    @Test
	void testUpdateUserPasswordById_userDoesNotExist() throws Exception {

		//String userJsonString = mapper.writeValueAsString(userDTO);

		mvc.perform(MockMvcRequestBuilders
        .put("/v1/users/password/0")
        .contentType(MediaType.APPLICATION_JSON)
		)
		.andExpect(status().isNotFound());
	}

    @Test
	void testUpdateUserPasswordById_completeUpdate() throws Exception {

		when(userService.getUserById(user.getId())).thenReturn(user);

		user.setPassword("testingpassword1234");

		mvc.perform(MockMvcRequestBuilders
        .put("/v1/users/password/" + user.getId())
        .content("{\"firstName\": \"José\", \"lastName\": \"Trigo\", \"password\": \"testingpassword1234\", \"address\": \"Campus de Santiago\", \"age\": \"21\", \"nif\": \"259070137\", \"phone\": \"938349547\", \"email\": \"josetrigo@ua.pt\"}")
        .contentType(MediaType.APPLICATION_JSON)
		)
        .andExpect(status().isOk())
		.andExpect(jsonPath("firstName", is(user.getFirstName())))
		.andExpect(jsonPath("lastName", is(user.getLastName())))
        .andExpect(jsonPath("password", is(user.getPassword())))
        .andExpect(jsonPath("address", is(user.getAddress())))
		.andExpect(jsonPath("age", is(user.getAge())))
		.andExpect(jsonPath("nif", is(user.getNif())))
		.andExpect(jsonPath("phone", is(user.getPhone())))
        .andExpect(jsonPath("email", is(user.getEmail())));
	}

    @Test
	void testUpdateUserAddressById_userDoesNotExist() throws Exception {

		//String userJsonString = mapper.writeValueAsString(userDTO);

		mvc.perform(MockMvcRequestBuilders
        .put("/v1/users/address/0")
        .contentType(MediaType.APPLICATION_JSON)
		)
		.andExpect(status().isNotFound());
	}

    @Test
	void testUpdateUserAddressById_completeUpdate() throws Exception {

		when(userService.getUserById(user.getId())).thenReturn(user);

		user.setAddress("DETI");

		mvc.perform(MockMvcRequestBuilders
        .put("/v1/users/address/" + user.getId())
        .content("{\"firstName\": \"José\", \"lastName\": \"Trigo\", \"password\": \"testingpassword123\", \"address\": \"DETI\", \"age\": \"21\", \"nif\": \"259070137\", \"phone\": \"938349547\", \"email\": \"josetrigo@ua.pt\"}")
        .contentType(MediaType.APPLICATION_JSON)
		)
        .andExpect(status().isOk())
		.andExpect(jsonPath("firstName", is(user.getFirstName())))
		.andExpect(jsonPath("lastName", is(user.getLastName())))
        .andExpect(jsonPath("password", is(user.getPassword())))
        .andExpect(jsonPath("address", is(user.getAddress())))
		.andExpect(jsonPath("age", is(user.getAge())))
		.andExpect(jsonPath("nif", is(user.getNif())))
		.andExpect(jsonPath("phone", is(user.getPhone())))
        .andExpect(jsonPath("email", is(user.getEmail())));
	}

    @Test
	void testUpdateUserAgeById_userDoesNotExist() throws Exception {

		//String userJsonString = mapper.writeValueAsString(userDTO);

		mvc.perform(MockMvcRequestBuilders
        .put("/v1/users/age/0")
        .contentType(MediaType.APPLICATION_JSON)
		)
		.andExpect(status().isNotFound());
	}

    @Test
	void testUpdateUserAgeById_completeUpdate() throws Exception {

		when(userService.getUserById(user.getId())).thenReturn(user);

		user.setAge(20);

		mvc.perform(MockMvcRequestBuilders
        .put("/v1/users/age/" + user.getId())
        .content("{\"firstName\": \"José\", \"lastName\": \"Trigo\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"age\": \"20\", \"nif\": \"259070137\", \"phone\": \"938349547\", \"email\": \"josetrigo@ua.pt\"}")
        .contentType(MediaType.APPLICATION_JSON)
		)
        .andExpect(status().isOk())
		.andExpect(jsonPath("firstName", is(user.getFirstName())))
		.andExpect(jsonPath("lastName", is(user.getLastName())))
        .andExpect(jsonPath("password", is(user.getPassword())))
        .andExpect(jsonPath("address", is(user.getAddress())))
		.andExpect(jsonPath("age", is(user.getAge())))
		.andExpect(jsonPath("nif", is(user.getNif())))
		.andExpect(jsonPath("phone", is(user.getPhone())))
        .andExpect(jsonPath("email", is(user.getEmail())));
	}

    @Test
	void testUpdateUserNifById_userDoesNotExist() throws Exception {

		//String userJsonString = mapper.writeValueAsString(userDTO);

		mvc.perform(MockMvcRequestBuilders
        .put("/v1/users/nif/0")
        .contentType(MediaType.APPLICATION_JSON)
		)
		.andExpect(status().isNotFound());
	}

    @Test
	void testUpdateUserNifById_completeUpdate() throws Exception {

		when(userService.getUserById(user.getId())).thenReturn(user);

		user.setNif(256193649);

		mvc.perform(MockMvcRequestBuilders
        .put("/v1/users/nif/" + user.getId())
        .content("{\"firstName\": \"José\", \"lastName\": \"Trigo\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"age\": \"21\", \"nif\": \"256193649\", \"phone\": \"938349547\", \"email\": \"josetrigo@ua.pt\"}")
        .contentType(MediaType.APPLICATION_JSON)
		)
        .andExpect(status().isOk())
		.andExpect(jsonPath("firstName", is(user.getFirstName())))
		.andExpect(jsonPath("lastName", is(user.getLastName())))
        .andExpect(jsonPath("password", is(user.getPassword())))
        .andExpect(jsonPath("address", is(user.getAddress())))
		.andExpect(jsonPath("age", is(user.getAge())))
		.andExpect(jsonPath("nif", is(user.getNif())))
		.andExpect(jsonPath("phone", is(user.getPhone())))
        .andExpect(jsonPath("email", is(user.getEmail())));
	}

    @Test
	void testUpdateUserPhoneById_userDoesNotExist() throws Exception {

		//String userJsonString = mapper.writeValueAsString(userDTO);

		mvc.perform(MockMvcRequestBuilders
        .put("/v1/users/phone/0")
        .contentType(MediaType.APPLICATION_JSON)
		)
		.andExpect(status().isNotFound());
	}

    @Test
	void testUpdateUserPhoneById_completeUpdate() throws Exception {

		when(userService.getUserById(user.getId())).thenReturn(user);

		user.setPhone("925097774");

		mvc.perform(MockMvcRequestBuilders
        .put("/v1/users/phone/" + user.getId())
        .content("{\"firstName\": \"José\", \"lastName\": \"Trigo\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"age\": \"21\", \"nif\": \"259070137\", \"phone\": \"925097774\", \"email\": \"josetrigo@ua.pt\"}")
        .contentType(MediaType.APPLICATION_JSON)
		)
        .andExpect(status().isOk())
		.andExpect(jsonPath("firstName", is(user.getFirstName())))
		.andExpect(jsonPath("lastName", is(user.getLastName())))
        .andExpect(jsonPath("password", is(user.getPassword())))
        .andExpect(jsonPath("address", is(user.getAddress())))
		.andExpect(jsonPath("age", is(user.getAge())))
		.andExpect(jsonPath("nif", is(user.getNif())))
		.andExpect(jsonPath("phone", is(user.getPhone())))
        .andExpect(jsonPath("email", is(user.getEmail())));
	}

    @Test
	void testUpdateUserEmailById_userDoesNotExist() throws Exception {

		//String userJsonString = mapper.writeValueAsString(userDTO);

		mvc.perform(MockMvcRequestBuilders
        .put("/v1/users/email/0")
        .contentType(MediaType.APPLICATION_JSON)
		)
		.andExpect(status().isNotFound());
	}

    @Test
	void testUpdateUserEmailById_completeUpdate() throws Exception {

		when(userService.getUserById(user.getId())).thenReturn(user);

		user.setEmail("renatoaldias12@ua.pt");

		mvc.perform(MockMvcRequestBuilders
        .put("/v1/users/email/" + user.getId())
        .content("{\"firstName\": \"José\", \"lastName\": \"Trigo\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"age\": \"21\", \"nif\": \"259070137\", \"phone\": \"938349547\", \"email\": \"renatoaldias12@ua.pt\"}")
        .contentType(MediaType.APPLICATION_JSON)
		)
        .andExpect(status().isOk())
		.andExpect(jsonPath("firstName", is(user.getFirstName())))
		.andExpect(jsonPath("lastName", is(user.getLastName())))
        .andExpect(jsonPath("password", is(user.getPassword())))
        .andExpect(jsonPath("address", is(user.getAddress())))
		.andExpect(jsonPath("age", is(user.getAge())))
		.andExpect(jsonPath("nif", is(user.getNif())))
		.andExpect(jsonPath("phone", is(user.getPhone())))
        .andExpect(jsonPath("email", is(user.getEmail())));
	}
    */
}
