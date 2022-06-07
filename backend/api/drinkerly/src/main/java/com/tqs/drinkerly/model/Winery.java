package com.tqs.drinkerly.model;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Winery")
public class Winery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int nif;
    private String name, address, phone, email, website;
    List<String> products;

    public Winery(String name, String address, int nif, String phone, String email, String website, List<String> products) {
        this.nif = nif;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.website = website;
        this.products = products;
    }

    public int getNif() {
        return this.nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<String> getProducts() {
        return this.products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "{" +
            ", nif='" + getNif() + "'" +
            ", name='" + getName() + "'" +
            ", address='" + getAddress() + "'" +
            ", phone='" + getPhone() + "'" +
            ", email='" + getEmail() + "'" +
            ", website='" + getWebsite() + "'" +
            ", products='" + getProducts() + "'" +
            "}";
    }
}