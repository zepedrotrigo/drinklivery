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
import java.util.List;
import java.util.ArrayList;

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
	private String data;
	private Rider rider, rider2;

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
				
		rider2 = new Rider("Renato", "Dias", "testingpassword1234", "DETI", 20, 256193649, "925097774",
				"renatoaldias12@ua.pt", "car", "08-RD-07");
	}

	// ----------------- Test Register ----------------------

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
				.content(
						"{\"firstName\": \"José\", \"lastName\": \"Trigo\", \"password\": \"testingpassword123\", \"address\": \"Campus de Santiago\", \"age\": \"21\", \"nif\": \"259070137\", \"phone\": \"\", \"email\": \"\", \"vehicleType\": \"motorcycle\", \"licensePlate\": \"00-AB-99\"}"))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());

		Mockito.verify(riderRepository, VerificationModeFactory.times(0)).save(Mockito.any(Rider.class));
	}
	
	@Test
	void testInvalidPassword_thenBadRequest() throws Exception {
		when(riderRepository.save(rider)).thenReturn(rider);

		mvc.perform(MockMvcRequestBuilders
				.post("/v1/riders/register")
				.contentType(MediaType.APPLICATION_JSON)
				.content(
						"{\"firstName\": \"José\", \"lastName\": \"Trigo\", \"password\": \"\", \"address\": \"Campus de Santiago\", \"age\": \"21\", \"nif\": \"259070137\", \"phone\": \"938349547\", \"email\": \"\", \"vehicleType\": \"motorcycle\", \"licensePlate\": \"00-AB-99\"}"))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());

		Mockito.verify(riderRepository, VerificationModeFactory.times(0)).save(Mockito.any(Rider.class));
	}
	
	// ----------------- Test Login ----------------------

	@Test
	void testValidLogin() throws Exception {
		when(riderService.getRiderByEmail(Mockito.any(String.class))).thenReturn(rider);

		mvc.perform(post("/v1/riders/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(String.format("{\"email\": \"%s\", \"password\": \"%s\"}", rider.getEmail(),
						rider.getPassword()))
				)
				.andExpect(status().isAccepted());

		Mockito.verify(riderService, VerificationModeFactory.times(1)).getRiderByEmail(Mockito.any(String.class));
	}

	@Test
	void testInvalidEmail() throws Exception {
		when(riderService.getRiderByEmail(Mockito.any(String.class))).thenThrow(new NullPointerException("Exception: Invalid Email"));

		mvc.perform(post("/v1/riders/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(String.format("{\"email\": \"%s\", \"password\": \"%s\"}", "invalidEmail", rider.getPassword()))
				)
				.andExpect(status().isNotFound());

		Mockito.verify(riderService, VerificationModeFactory.times(1)).getRiderByEmail(Mockito.any(String.class));
	}

	@Test
	void testInvalidPassword() throws Exception {
			when(riderService.getRiderByEmail(Mockito.any(String.class))).thenReturn(rider);

			mvc.perform(post("/v1/riders/login")
							.contentType(MediaType.APPLICATION_JSON)
							.content(String.format("{\"email\": \"%s\", \"password\": \"%s\"}", rider.getEmail(),
											"invalidPassword")))
							.andExpect(status().isForbidden());

			Mockito.verify(riderService, VerificationModeFactory.times(1)).getRiderByEmail(Mockito.any(String.class));
	}
	
		// ----------------- Test getAllRiders ----------------------
	@Test
	void testGetAllRiders() throws Exception {
			when(riderService.getAllRiders()).thenReturn(new ArrayList<Rider>());

			mvc.perform(MockMvcRequestBuilders
			.get("/v1/riders/")
			.contentType(MediaType.APPLICATION_JSON)
			)
			.andExpect(MockMvcResultMatchers.status().isOk());
			
			Mockito.verify(riderService, VerificationModeFactory.times(1)).getAllRiders();
	}

	@Test
	void testGetRider() throws Exception {
			when(riderService.getRiderById(1L)).thenReturn(new Rider());

			mvc.perform(MockMvcRequestBuilders
			.get("/v1/riders/1")
			.contentType(MediaType.APPLICATION_JSON)
			)
			.andExpect(MockMvcResultMatchers.status().isOk());
			
			Mockito.verify(riderService, VerificationModeFactory.times(1)).getRiderById(1L);
	}

        
        @Test
        void testGetRiderById_existentId() throws Exception {

        when(riderService.getRiderById(rider.getId())).thenReturn(rider);

        mvc.perform(MockMvcRequestBuilders
                .get("/v1/riders/" + rider.getId())
                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
	        .andExpect(jsonPath("firstName", is(rider.getFirstName())))
	        .andExpect(jsonPath("lastName", is(rider.getLastName())))
                .andExpect(jsonPath("password", is(rider.getPassword())))
                .andExpect(jsonPath("address", is(rider.getAddress())))
	        .andExpect(jsonPath("age", is(rider.getAge())))
	        .andExpect(jsonPath("nif", is(rider.getNif())))
	        .andExpect(jsonPath("phone", is(rider.getPhone())))
                .andExpect(jsonPath("email", is(rider.getEmail())))
                .andExpect(jsonPath("vehicleType", is(rider.getVehicleType())))
                .andExpect(jsonPath("licensePlate", is(rider.getLicensePlate())));


        }
       
    
        
      @Test
	void testDeleteRiderById_existentId() throws Exception {

	when(riderService.deleteRiderById(rider.getId())).thenReturn(ResponseEntity.noContent().build());

	mvc.perform(MockMvcRequestBuilders
                .delete("/v1/riders/" + rider.getId())
                .contentType(MediaType.APPLICATION_JSON)
                )
		.andExpect(status().isNoContent());
	}

	
   

    @Test
	void testUpdateRiderFirstNameById_completeUpdate() throws Exception {

	when(riderService.updateRiderFirstNameById(rider.getId(), "Renato")).thenReturn(rider2);

	mvc.perform(MockMvcRequestBuilders
                .put("/v1/riders/firstName/" + rider.getId())
				.content("{\"firstName\":\"Renato\"}")
				.contentType(MediaType.APPLICATION_JSON)
		)
                .andExpect(status().isOk())
				//.andDo(MockMvcResultHandlers.print())
	        .andExpect(jsonPath("$.firstName", is(rider2.getFirstName())));
	}

   

        @Test
	void testUpdateRiderLastNameById_completeUpdate() throws Exception {

		when(riderService.updateRiderLastNameById(rider.getId(), "Dias")).thenReturn(rider2);

	mvc.perform(MockMvcRequestBuilders
                .put("/v1/riders/lastName/" + rider.getId())
                .content("{\"lastName\":\"Dias\"}")
                .contentType(MediaType.APPLICATION_JSON)
		)
                .andExpect(status().isOk())
				//.andDo(MockMvcResultHandlers.print())
	        .andExpect(jsonPath("$.lastName", is(rider2.getLastName())));
	}


    @Test
	void testUpdateRiderPasswordById_completeUpdate() throws Exception {

		when(riderService.updateRiderPasswordById(rider.getId(), "testingpassword1234")).thenReturn(rider2);



	mvc.perform(MockMvcRequestBuilders
                .put("/v1/riders/password/" + rider.getId())
                .content("{\"password\":\"testingpassword1234\"}")
                .contentType(MediaType.APPLICATION_JSON)
		)
                .andExpect(status().isOk())
				//.andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("password", is(rider2.getPassword())));
                
	}

       

        @Test
	void testUpdateRiderAddressById_completeUpdate() throws Exception {

		when(riderService.updateRiderAddressById(rider.getId(), "DETI")).thenReturn(rider2);
	

	mvc.perform(MockMvcRequestBuilders
                .put("/v1/riders/address/" + rider.getId())
                .content("{\"address\":\"DETI\"}")
                .contentType(MediaType.APPLICATION_JSON)
		)
                .andExpect(status().isOk())
				//.andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("address", is(rider2.getAddress())));
	        
	}

       

        @Test
	void testUpdateRiderAgeById_completeUpdate() throws Exception {

		when(riderService.updateRiderAgeById(rider.getId(), 20)).thenReturn(rider2);

	mvc.perform(MockMvcRequestBuilders
                .put("/v1/riders/age/" + rider.getId())
                .content("{\"age\":\"20\"}")
                .contentType(MediaType.APPLICATION_JSON)
		)
                .andExpect(status().isOk()) 
				//.andDo(MockMvcResultHandlers.print()) 
	        .andExpect(jsonPath("age", is(rider2.getAge())));
	       
	}

//-----------------------------------------------------------------------------------------------------
//						NIF     NIF		NIF		NIF   

        @Test
	void testUpdateRiderNifById_completeUpdate() throws Exception {

		when(riderService.updateRiderNifById(rider.getId(), 256193649)).thenReturn(rider2);

	mvc.perform(MockMvcRequestBuilders
                .put("/v1/riders/nif/" + rider.getId())
                .content("{\"nif\":\"256193649\"}")
                .contentType(MediaType.APPLICATION_JSON)
		)
                .andExpect(status().isOk()) 
				//.andDo(MockMvcResultHandlers.print())
	        .andExpect(jsonPath("nif", is(rider2.getNif())));
	       
	}

       

        @Test
	void testUpdateRiderPhoneById_completeUpdate() throws Exception {

		when(riderService.updateRiderPhoneById(rider.getId(), "925097774")).thenReturn(rider2);

	mvc.perform(MockMvcRequestBuilders
                .put("/v1/riders/phone/" + rider.getId())
                .content("{\"phone\":\"925097774\"}")
                .contentType(MediaType.APPLICATION_JSON)
		)
                .andExpect(status().isOk())
				//.andDo(MockMvcResultHandlers.print())
	        .andExpect(jsonPath("phone", is(rider2.getPhone())));
               
	}

      

        @Test
	void testUpdateRiderEmailById_completeUpdate() throws Exception {

		when(riderService.updateRiderEmailById(rider.getId(), "renatoaldias12@ua.pt")).thenReturn(rider2);


	mvc.perform(MockMvcRequestBuilders
                .put("/v1/riders/email/" + rider.getId())
                .content("{\"email\":\"renatoaldias12@ua.pt\"}")
                .contentType(MediaType.APPLICATION_JSON)
		)
                .andExpect(status().isOk())
				//.andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("email", is(rider2.getEmail())));
                
	}

       

        @Test
	void testUpdateRiderVehicleTypeById_completeUpdate() throws Exception {

		when(riderService.updateRiderVehicleTypeById(rider.getId(), "car")).thenReturn(rider2);


	mvc.perform(MockMvcRequestBuilders
                .put("/v1/riders/vehicleType/" + rider.getId())
                .content("{\"vehicleType\":\"car\"}")
                .contentType(MediaType.APPLICATION_JSON)
		)
                .andExpect(status().isOk())
				//.andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("vehicleType", is(rider2.getVehicleType())));
                
	}

      

        @Test
	void testUpdateRiderLicensePlateById_completeUpdate() throws Exception {

		when(riderService.updateRiderLicensePlateById(rider.getId(), "08-RD-07")).thenReturn(rider2);


	mvc.perform(MockMvcRequestBuilders
                .put("/v1/riders/licensePlate/" + rider.getId())
                .content("{\"licensePlate\":\"08-RD-07\"}")
                .contentType(MediaType.APPLICATION_JSON)
		)
                .andExpect(status().isOk())
				//.andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("licensePlate", is(rider2.getLicensePlate())));
	}
        
	
}
