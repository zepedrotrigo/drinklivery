package com.tqs.drinkerly.model;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.time.LocalDateTime; 

@Entity
@Table(name = "Request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="rider_id", referencedColumnName = "id")
    private Rider deliverRider; 
    
    @Column(name = "Time_of_Request", nullable = false)
    private LocalDateTime now = LocalDateTime.now();  
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @ManyToMany
    @JoinTable(
        name="Product_List",
        joinColumns= @JoinColumn(name = "request_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productList;

    public Request() {
        
    }

    public Request( Rider deliverRider, User user, List<Product> productList) {
        this.deliverRider = deliverRider;
        this.now = LocalDateTime.now();
        /*this.user = user;
        this.productList = productList;*/
    }


    /*public List<Product> getproductList() {
        return this.productList;
    }

    public void setproductList(List<Product> productList) {
        this.productList = productList;
    }*/

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

    /*public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

}
