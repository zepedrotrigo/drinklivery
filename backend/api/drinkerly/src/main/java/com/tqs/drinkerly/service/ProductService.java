package com.tqs.drinkerly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqs.drinkerly.model.Product;
import com.tqs.drinkerly.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(Product product) {
        productRepository.save(product);
    }
    
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
