package com.tqs.drinkerly.service;

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
import com.google.common.base.Predicates;
import com.google.common.collect.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.tqs.drinkerly.model.Rider;
import com.tqs.drinkerly.repository.RiderRepository;
import com.tqs.drinkerly.service.RiderService;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.Mockito;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.logging.Logger;

import java.util.logging.Level;
import org.junit.jupiter.api.BeforeEach;

import org.mockito.ArgumentMatchers.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.*;
import org.mockito.*;

@ExtendWith(MockitoExtension.class)
public class RiderServiceTests {

   @Mock
   private RiderRepository rRep;


   @InjectMocks
   private RiderService rServ;


   @Test
   void testUpdateFirstName()  {
      Rider base = new Rider("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, 259070137, "938349547", "josetrigo@ua.pt", "motorcycle", "00-AB-99");
      Rider base2 = new Rider("Pedro", "Trigo", "testingpassword123", "Campus de Santiago", 21, 259070137, "938349547", "josetrigo@ua.pt", "motorcycle", "00-AB-99");
      
      Mockito.when(rRep.findById(1L)).thenReturn(Optional.of(base));
      Mockito.when(rRep.save(Mockito.any())).thenReturn(base2);
     
    
      Rider r = rServ.updateRiderFirstNameById(1L, "Pedro"); 
      //System.out.println("\n\n\n\n\n "+u.toString()+"\n\n\n\n");
      //

      Assertions.assertThat(r.getFirstName()).isEqualTo("Pedro");
      
   }

   @Test
   void testUpdateLastName()  {
      Rider base = new Rider("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, 259070137, "938349547", "josetrigo@ua.pt", "motorcycle", "00-AB-99");
      Rider base2 = new Rider("José", "Figueiredo", "testingpassword123", "Campus de Santiago", 21, 259070137, "938349547", "josetrigo@ua.pt", "motorcycle", "00-AB-99");
      
      Mockito.when(rRep.findById(1L)).thenReturn(Optional.of(base));
      Mockito.when(rRep.save(Mockito.any())).thenReturn(base2);
     
    
      Rider r = rServ.updateRiderLastNameById(1L, "Figueiredo"); 
      //System.out.println("\n\n\n\n\n "+u.toString()+"\n\n\n\n");

      Assertions.assertThat(r.getLastName()).isEqualTo("Figueiredo");
      
   }

   @Test
   void testUpdatePassword()  {
      Rider base = new Rider("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, 259070137, "938349547", "josetrigo@ua.pt", "motorcycle", "00-AB-99");
      Rider base2 = new Rider("José", "Trigo", "testingpassword1234", "Campus de Santiago", 21, 259070137, "938349547", "josetrigo@ua.pt", "motorcycle", "00-AB-99");
      
      Mockito.when(rRep.findById(1L)).thenReturn(Optional.of(base));
      Mockito.when(rRep.save(Mockito.any())).thenReturn(base2);
     
    
      Rider r = rServ.updateRiderPasswordById(1L, "password2"); 
      //System.out.println("\n\n\n\n\n "+u.toString()+"\n\n\n\n");

      Assertions.assertThat(r.getPassword()).isEqualTo("testingpassword1234");
      
   }

   @Test
   void testUpdateAddress()  {
      String add2 = "address2";
      Rider base = new Rider("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, 259070137, "938349547", "josetrigo@ua.pt", "motorcycle", "00-AB-99");
      Rider base2 = new Rider("José", "Trigo", "testingpassword123", add2, 21, 259070137, "938349547", "josetrigo@ua.pt", "motorcycle", "00-AB-99");
      
      Mockito.when(rRep.findById(1L)).thenReturn(Optional.of(base));
      Mockito.when(rRep.save(Mockito.any())).thenReturn(base2);
     
    
      Rider u = rServ.updateRiderAddressById(1L, add2); 
      //System.out.println("\n\n\n\n\n "+u.toString()+"\n\n\n\n");

      Assertions.assertThat(u.getAddress()).isEqualTo(add2);
      
   }

   @Test
   void testUpdateAge()  {
      Integer add2 = 88;
      Rider base = new Rider("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, 259070137, "938349547", "josetrigo@ua.pt", "motorcycle", "00-AB-99");
      Rider base2 = new Rider("José", "Trigo", "testingpassword123", "Campus de Santiago", add2, 259070137, "938349547", "josetrigo@ua.pt", "motorcycle", "00-AB-99");
      
      Mockito.when(rRep.findById(1L)).thenReturn(Optional.of(base));
      Mockito.when(rRep.save(Mockito.any())).thenReturn(base2);
     
    
      Rider r = rServ.updateRiderAgeById(1L, add2); 
      //System.out.println("\n\n\n\n\n "+u.toString()+"\n\n\n\n");

      Assertions.assertThat(r.getAge()).isEqualTo(add2);
      
   }

   @Test
   void testUpdateNif()  {
      Integer add2 = 888888888;
      Rider base = new Rider("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, 259070137, "938349547", "josetrigo@ua.pt", "motorcycle", "00-AB-99");
      Rider base2 = new Rider("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, add2, "938349547", "josetrigo@ua.pt", "motorcycle", "00-AB-99");
      
      Mockito.when(rRep.findById(1L)).thenReturn(Optional.of(base));
      Mockito.when(rRep.save(Mockito.any())).thenReturn(base2);
     
    
      Rider r = rServ.updateRiderNifById(1L, add2); 
      //System.out.println("\n\n\n\n\n "+u.toString()+"\n\n\n\n");

      Assertions.assertThat(r.getNif()).isEqualTo(add2);
      
   }

   @Test
   void testUpdatePhone()  {
      String add2 = "987654321";
      Rider base = new Rider("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, 259070137, "938349547", "josetrigo@ua.pt", "motorcycle", "00-AB-99");
      Rider base2 = new Rider("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, 259070137, add2, "josetrigo@ua.pt", "motorcycle", "00-AB-99");
      
      Mockito.when(rRep.findById(1L)).thenReturn(Optional.of(base));
      Mockito.when(rRep.save(Mockito.any())).thenReturn(base2);
     
    
      Rider u = rServ.updateRiderPhoneById(1L, add2); 
      //System.out.println("\n\n\n\n\n "+u.toString()+"\n\n\n\n");

      Assertions.assertThat(u.getPhone()).isEqualTo(add2);
      
   }

   @Test
   void testUpdateEmail()  {
      String add2 = "gmail@gmail.com";
      Rider base = new Rider("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, 259070137, "938349547", "josetrigo@ua.pt", "motorcycle", "00-AB-99");
      Rider base2 = new Rider("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, 259070137, "938349547", add2, "motorcycle", "00-AB-99");
      
      Mockito.when(rRep.findById(1L)).thenReturn(Optional.of(base));
      Mockito.when(rRep.save(Mockito.any())).thenReturn(base2);
     
    
      Rider r = rServ.updateRiderEmailById(1L, add2); 
      //System.out.println("\n\n\n\n\n "+u.toString()+"\n\n\n\n");

      Assertions.assertThat(r.getEmail()).isEqualTo(add2);
      
   }

   @Test
   void testUpdateVehicleType()  {
      String add2 = "car";
      Rider base = new Rider("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, 259070137, "938349547", "josetrigo@ua.pt", "motorcycle", "00-AB-99");
      Rider base2 = new Rider("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, 259070137, "938349547", "josetrigo@ua.pt", add2, "00-AB-99");
      
      Mockito.when(rRep.findById(1L)).thenReturn(Optional.of(base));
      Mockito.when(rRep.save(Mockito.any())).thenReturn(base2);
     
    
      Rider r = rServ.updateRiderEmailById(1L, add2); 
      //System.out.println("\n\n\n\n\n "+u.toString()+"\n\n\n\n");

      Assertions.assertThat(r.getVehicleType()).isEqualTo(add2);
      
   }

   @Test
   void testUpdateLicensePlate()  {
      String add2 = "08-RD-07";
      Rider base = new Rider("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, 259070137, "938349547", "josetrigo@ua.pt", "motorcycle", "00-AB-99");
      Rider base2 = new Rider("José", "Trigo", "testingpassword123", "Campus de Santiago", 21, 259070137, "938349547", "josetrigo@ua.pt", "motorcycle", add2);
      
      Mockito.when(rRep.findById(1L)).thenReturn(Optional.of(base));
      Mockito.when(rRep.save(Mockito.any())).thenReturn(base2);
     
    
      Rider r = rServ.updateRiderEmailById(1L, add2); 
      //System.out.println("\n\n\n\n\n "+u.toString()+"\n\n\n\n");

      Assertions.assertThat(r.getLicensePlate()).isEqualTo(add2);
      
   }
}

/*@InjectMocks
private CompanyServiceImpl companyService;

@Mock
private CompanyRepository companyRepository;

@Captor
ArgumentCaptor<Company> companyCaptorEntity;    

@Test
public void testUpdate() {
    final UUID uuid = UUID.randomUUID();
    final CompanyRequest request = new CompanyRequest();
    request.setName("Updated Company Name");

    final Company company = new Company();
    company.setName("Company Name");
    
    when(companyRepository.findByUuid(uuid))
        .thenReturn(Optional.ofNullable(company));

    //??? Do we need this?
    when(companyRepository.save(any())).thenReturn(company);

    CompanyDTO result = companyService.update(request, uuid);

    Mockito.verify(companyRepository).save(companyCaptor.capture());

    Company savedCompany = companyCaptor.getValue();
    assertEquals(request.getName(), savedCompany.getName());
}*/
