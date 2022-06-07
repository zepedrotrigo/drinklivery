package com.tqs.drinkerly.model;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@Column(name = "Rider", nullable = false)

    public User(String firstName, String lastName, int age, int nif, String password, String address,
            String phone, String email) {
        super(firstName, lastName, age, nif, password, address, phone, email);
    }
}