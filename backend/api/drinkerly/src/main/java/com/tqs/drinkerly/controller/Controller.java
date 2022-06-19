package com.tqs.drinkerly.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.tqs.drinkerly.service.RequestService;
import com.tqs.drinkerly.model.Product;
import com.tqs.drinkerly.service.ProductService;

@RestController
class Controller {
    @Autowired
    RequestService reqserv;

    @Autowired
    ProductService productService;

    @GetMapping("/v1/some_endpoint")
    @ResponseBody
    String getSomeEndPoint(@RequestParam(required = false) Optional<String> date)
            throws IOException, InterruptedException {
        return "okey";
    }

    @PostMapping("/request")
    public void postRequest( ){

    }

    @GetMapping("/allproducts")
    public List<Product> getProducts(){
        return (List<Product>) productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable(value = "id") long id){
        return productService.getProduct(id);
    }
    
}
 