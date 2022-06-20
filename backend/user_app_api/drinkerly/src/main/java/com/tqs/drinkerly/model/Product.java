package com.tqs.drinkerly.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

enum Type {
    RED, WHITE, SPARKLING, ROSE, DESSERT, FORTIFIED
 }

@Entity
@Table(name = "Product")
public class Product {
    private String name, Type, country, region, grapeVariety, description; // type can be [red, white, sparkling, rose, dessert, fortified]
    private double volume, alcoholicVolume, buyPrice, retailPrice, ratingScore, numRatings;
    private int stock;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="winery_id", referencedColumnName = "id")
    private Winery winery;

    @ManyToMany(mappedBy = "productList")
    private List<Request> requests;

    public Product() {
    }

    public Product(String name, String Type, String country, String region, String grapeVariety, String description, double volume, double alcoholicVolume, double buyPrice, double retailPrice, double ratingScore, double numRatings, int stock, Winery winery) {
        this.name = name;
        this.Type = Type;
        this.country = country;
        this.region = region;
        this.grapeVariety = grapeVariety;
        this.description = description;
        this.volume = volume;
        this.alcoholicVolume = alcoholicVolume;
        this.buyPrice = buyPrice;
        this.retailPrice = retailPrice;
        this.ratingScore = ratingScore;
        this.numRatings = numRatings;
        this.stock = stock;
        this.winery = winery;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGrapeVariety() {
        return this.grapeVariety;
    }

    public void setGrapeVariety(String grapeVariety) {
        this.grapeVariety = grapeVariety;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getVolume() {
        return this.volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getAlcoholicVolume() {
        return this.alcoholicVolume;
    }

    public void setAlcoholicVolume(double alcoholicVolume) {
        this.alcoholicVolume = alcoholicVolume;
    }

    public double getBuyPrice() {
        return this.buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getRetailPrice() {
        return this.retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public double getRatingScore() {
        return this.ratingScore;
    }

    public void setRatingScore(double ratingScore) {
        this.ratingScore = ratingScore;
    }

    public double getNumRatings() {
        return this.numRatings;
    }

    public void setNumRatings(double numRatings) {
        this.numRatings = numRatings;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Winery getWinery() {
        return this.winery;
    }

    public void setWinery(Winery winery) {
        this.winery = winery;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", Type='" + getType() + "'" +
            ", country='" + getCountry() + "'" +
            ", region='" + getRegion() + "'" +
            ", grapeVariety='" + getGrapeVariety() + "'" +
            ", description='" + getDescription() + "'" +
            ", volume='" + getVolume() + "'" +
            ", alcoholicVolume='" + getAlcoholicVolume() + "'" +
            ", buyPrice='" + getBuyPrice() + "'" +
            ", retailPrice='" + getRetailPrice() + "'" +
            ", ratingScore='" + getRatingScore() + "'" +
            ", numRatings='" + getNumRatings() + "'" +
            ", stock='" + getStock() + "'" +
            ", winery='" + getWinery() + "'" +
            "}";
    }

}
