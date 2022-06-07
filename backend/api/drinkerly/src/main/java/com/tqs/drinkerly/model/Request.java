package com.tqs.drinkerly.model;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.time.LocalDateTime; 

@Entity
@Table(name = "Request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Rider", nullable = false)
    private Rider deliverRider; 
    
    @Column(name = "Time of Request", nullable = false)
    private LocalDateTime now = LocalDateTime.now();  
    
    @Column(name = "User", nullable = false)
    private User user;

    @Column(name = "Product List", nullable = false)
    private List<String> ProductList;

    public Request( Rider deliverRider, LocalDateTime now, User user, List<String> ProductList) {
        this.deliverRider = deliverRider;
        this.now = now;
        this.user = user;
        this.ProductList = ProductList;
    }


    public List<String> getProductList() {
        return this.ProductList;
    }

    public void setProductList(List<String> ProductList) {
        this.ProductList = ProductList;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rider getDeliverRider() {
        return this.deliverRider;
    }

    public void setDeliverRider(Rider deliverRider) {
        this.deliverRider = deliverRider;
    }

    public LocalDateTime getNow() {
        return this.now;
    }

    public void setNow(LocalDateTime now) {
        this.now = now;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
