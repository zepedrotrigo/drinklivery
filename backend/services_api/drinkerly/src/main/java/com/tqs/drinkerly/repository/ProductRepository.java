package com.tqs.drinkerly.repository;

import org.springframework.data.repository.CrudRepository;
import com.tqs.drinkerly.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findByName(String name);

    void saveAndFlush(Product pUpdated);
    
}