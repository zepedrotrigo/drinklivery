package com.tqs.drinkerly.model;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "User")
public class User extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Request> requests;

    public User(String firstName, String lastName, int age, int nif, String password, String address,
            String phone, String email) {
        super(firstName, lastName, age, nif, password, address, phone, email);
    }
}