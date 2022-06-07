package com.tqs.drinkerly.model;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Rider")
public class Rider extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double rating;
    private String vehicleType, licensePlate;
    private int numDeliveries, numAcceptedDeliveries, numRefusedDeliveries;


    public Rider(String firstName, String lastName, int age, int nif, String password, String address,
            String phone, String email, String vehicleType, String licensePlate) {
        super(firstName, lastName, age, nif, password, address, phone, email);
        this.vehicleType = vehicleType;
        this.licensePlate = licensePlate;
        this.numDeliveries = 0;
        this.numAcceptedDeliveries = 0;
        this.numRefusedDeliveries = 0;
        this.rating = 5.0;
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", rating='" + getRating() + "'" +
            ", vehicleType='" + getVehicleType() + "'" +
            ", licensePlate='" + getLicensePlate() + "'" +
            ", numDeliveries='" + getNumDeliveries() + "'" +
            ", numAcceptedDeliveries='" + getNumAcceptedDeliveries() + "'" +
            ", numRefusedDeliveries='" + getNumRefusedDeliveries() + "'" +
            "}";
    }

}