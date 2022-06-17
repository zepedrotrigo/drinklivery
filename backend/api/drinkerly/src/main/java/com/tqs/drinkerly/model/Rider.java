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
@Table(name = "Rider")
public class Rider {
    private int age, nif;
    private String firstName, lastName, password, address, phone, email;

    private double rating;
    private String vehicleType, licensePlate;
    private int numDeliveries, numAcceptedDeliveries, numRefusedDeliveries;
    private boolean occupied;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @OneToMany(mappedBy = "deliverRider")
    List<Request> requests;

    public Rider() {
        
    }

    public Rider(String firstName, String lastName, String password, String address, int age, int nif, String phone,
            String email, double rating, String vehicleType, String licensePlate, int numDeliveries,
            int numAcceptedDeliveries, int numRefusedDeliveries, boolean occupied) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
        this.age = age;
        this.nif = nif;
        this.phone = phone;
        this.email = email;
        this.rating = rating;
        this.vehicleType = vehicleType;
        this.licensePlate = licensePlate;
        this.numDeliveries = numDeliveries;
        this.numAcceptedDeliveries = numAcceptedDeliveries;
        this.numRefusedDeliveries = numRefusedDeliveries;
        this.occupied = occupied;
    }
    
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNif() {
        return this.nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
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

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getVehicleType() {
        return this.vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getNumDeliveries() {
        return this.numDeliveries;
    }

    public void setNumDeliveries(int numDeliveries) {
        this.numDeliveries = numDeliveries;
    }

    public int getNumAcceptedDeliveries() {
        return this.numAcceptedDeliveries;
    }

    public void setNumAcceptedDeliveries(int numAcceptedDeliveries) {
        this.numAcceptedDeliveries = numAcceptedDeliveries;
    }

    public int getNumRefusedDeliveries() {
        return this.numRefusedDeliveries;
    }

    public void setNumRefusedDeliveries(int numRefusedDeliveries) {
        this.numRefusedDeliveries = numRefusedDeliveries;
    }

    public boolean isOccupied() {
        return this.occupied;
    }

    public boolean getOccupied() {
        return this.occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Request> getRequests() {
        return this.requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    @Override
    public String toString() {
        return "{" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", password='" + getPassword() + "'" +
            ", address='" + getAddress() + "'" +
            " age='" + getAge() + "'" +
            ", nif='" + getNif() + "'" +
            ", phone='" + getPhone() + "'" +
            ", email='" + getEmail() + "'" +
            ", rating='" + getRating() + "'" +
            ", vehicleType='" + getVehicleType() + "'" +
            ", licensePlate='" + getLicensePlate() + "'" +
            ", numDeliveries='" + getNumDeliveries() + "'" +
            ", numAcceptedDeliveries='" + getNumAcceptedDeliveries() + "'" +
            ", numRefusedDeliveries='" + getNumRefusedDeliveries() + "'" +
            ", occupied='" + isOccupied() + "'" +
            ", id='" + getId() + "'" +
            ", requests='" + getRequests() + "'" +
            "}";
    }
}