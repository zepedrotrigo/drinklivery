package com.tqs.drinkerly.model;

import java.util.List;

enum Type {
    RED, WHITE, SPARKLING, ROSE, DESSERT, FORTIFIED
 }

public class Product {
    private String name, Type, country, region, grapeVariety, description; // type can be [red, white, sparkling, rose, dessert, fortified]
    private double volume, alcoholicVolume, buyPrice, retailPrice, ratingScore, numRatings;
    private int stock;
    List<String> foodPairings;


    public Product() {
    }

    public Product(String name, String Type, String country, String region, String grapeVariety, String description, double volume, double alcoholicVolume, double buyPrice, double retailPrice, double ratingScore, double numRatings, int stock, List<String> foodPairings) {
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
        this.foodPairings = foodPairings;
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

    public List<String> getFoodPairings() {
        return this.foodPairings;
    }

    public void setFoodPairings(List<String> foodPairings) {
        this.foodPairings = foodPairings;
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
            ", foodPairings='" + getFoodPairings() + "'" +
            "}";
    }

}
