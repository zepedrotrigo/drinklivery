package com.tqs.drinkerly.service;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.*;
import org.testcontainers.containers.MySQLContainer;
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
import com.tqs.drinkerly.service.UserService;

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
public class UserServiceTests {

   @Mock
   private UserRepository uRep;


   @InjectMocks
   private UserService uServ;


   @Test
   void testUpdateFirstName()  {
      User base = new User("firstName", "lastName", "password", "address", 23, 222222222, "phone", "email");
      User base2 = new User("Pedro", "lastName", "password", "address", 23, 222222222, "phone", "email");
      
      Mockito.when(uRep.findById(1L)).thenReturn(Optional.of(base));
      Mockito.when(uRep.save(Mockito.any())).thenReturn(base2);
     
    
      User u = uServ.updateUserFirstNameById(1L, "Pedro"); 
      //System.out.println("\n\n\n\n\n "+u.toString()+"\n\n\n\n");

      Assertions.assertThat(u.getFirstName()).isEqualTo("Pedro");
      
   }

   @Test
   void testUpdateLastName()  {
      User base = new User("firstName", "lastName", "password", "address", 23, 222222222, "phone", "email");
      User base2 = new User("firstName", "Figueiredo", "password", "address", 23, 222222222, "phone", "email");
      
      Mockito.when(uRep.findById(1L)).thenReturn(Optional.of(base));
      Mockito.when(uRep.save(Mockito.any())).thenReturn(base2);
     
    
      User u = uServ.updateUserLastNameById(1L, "Figueiredo"); 
      //System.out.println("\n\n\n\n\n "+u.toString()+"\n\n\n\n");

      Assertions.assertThat(u.getLastName()).isEqualTo("Figueiredo");
      
   }

   @Test
   void testUpdatePassword()  {
      User base = new User("firstName", "lastName", "password", "address", 23, 222222222, "phone", "email");
      User base2 = new User("firstName", "Figueiredo", "password2", "address", 23, 222222222, "phone", "email");
      
      Mockito.when(uRep.findById(1L)).thenReturn(Optional.of(base));
      Mockito.when(uRep.save(Mockito.any())).thenReturn(base2);
     
    
      User u = uServ.updateUserPasswordById(1L, "password2"); 
      //System.out.println("\n\n\n\n\n "+u.toString()+"\n\n\n\n");

      Assertions.assertThat(u.getPassword()).isEqualTo("password2");
      
   }

   @Test
   void testUpdateAddress()  {
      String add2 = "address2";
      User base = new User("firstName", "lastName", "password", "address", 23, 222222222, "phone", "email");
      User base2 = new User("firstName", "Figueiredo", "password", add2, 23, 222222222, "phone", "email");
      
      Mockito.when(uRep.findById(1L)).thenReturn(Optional.of(base));
      Mockito.when(uRep.save(Mockito.any())).thenReturn(base2);
     
    
      User u = uServ.updateUserAddressById(1L, add2); 
      //System.out.println("\n\n\n\n\n "+u.toString()+"\n\n\n\n");

      Assertions.assertThat(u.getAddress()).isEqualTo(add2);
      
   }

   @Test
   void testUpdateAge()  {
      Integer add2 = 88;
      User base = new User("firstName", "lastName", "password", "address", 
      23, 222222222, "phone", "email");
      User base2 = new User("firstName", "Figueiredo", "password", "address", 
      add2, 222222222, "phone", "email");
      
      Mockito.when(uRep.findById(1L)).thenReturn(Optional.of(base));
      Mockito.when(uRep.save(Mockito.any())).thenReturn(base2);
     
    
      User u = uServ.updateUserAgeById(1L, add2); 
      //System.out.println("\n\n\n\n\n "+u.toString()+"\n\n\n\n");

      Assertions.assertThat(u.getAge()).isEqualTo(add2);
      
   }

   @Test
   void testUpdateNif()  {
      Integer add2 = 888888888;
      User base = new User("firstName", "lastName", "password", "address", 
      23, 222222222, "phone", "email");
      User base2 = new User("firstName", "Figueiredo", "password", "address", 
      23, add2, "phone", "email");
      
      Mockito.when(uRep.findById(1L)).thenReturn(Optional.of(base));
      Mockito.when(uRep.save(Mockito.any())).thenReturn(base2);
     
    
      User u = uServ.updateUserNifById(1L, add2); 
      //System.out.println("\n\n\n\n\n "+u.toString()+"\n\n\n\n");

      Assertions.assertThat(u.getNif()).isEqualTo(add2);
      
   }

   @Test
   void testUpdatePhone()  {
      String add2 = "987654321";
      User base = new User("firstName", "lastName", "password", "address", 
      23, 222222222, "phone", "email");
      User base2 = new User("firstName", "Figueiredo", "password", "address", 
      23, 222222222, add2,  "email");
      
      Mockito.when(uRep.findById(1L)).thenReturn(Optional.of(base));
      Mockito.when(uRep.save(Mockito.any())).thenReturn(base2);
     
    
      User u = uServ.updateUserPhoneById(1L, add2); 
      //System.out.println("\n\n\n\n\n "+u.toString()+"\n\n\n\n");

      Assertions.assertThat(u.getPhone()).isEqualTo(add2);
      
   }

   @Test
   void testUpdateEmail()  {
      String add2 = "gmail@gmail.com";
      User base = new User("firstName", "lastName", "password", "address", 
      23, 222222222, "phone", "email");
      User base2 = new User("firstName", "Figueiredo", "password", "address", 
      23, 222222222, "999999999", add2);
      
      Mockito.when(uRep.findById(1L)).thenReturn(Optional.of(base));
      Mockito.when(uRep.save(Mockito.any())).thenReturn(base2);
     
    
      User u = uServ.updateUserEmailById(1L, add2); 
      //System.out.println("\n\n\n\n\n "+u.toString()+"\n\n\n\n");

      Assertions.assertThat(u.getEmail()).isEqualTo(add2);
      
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
