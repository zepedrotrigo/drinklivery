package com.tqs.drinkerly.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.tqs.drinkerly.model.User;
import com.tqs.drinkerly.model.Request;
import com.tqs.drinkerly.service.RequestService;
import com.tqs.drinkerly.model.Product;
import com.tqs.drinkerly.service.ProductService;

@RestController
class Controller {

    @Autowired
    RequestService requestService;

    @Autowired
    ProductService productService;

    @GetMapping("/v1/some_endpoint")
    @ResponseBody
    String getSomeEndPoint(@RequestParam(required = false) Optional<String> date)
            throws IOException, InterruptedException {
        return "okey";
    }

    @PostMapping("/v1/request")
    public ResponseEntity<Void> postRequest(@RequestParam List<Product> products, @RequestParam User user) {

        requestService.saveRequest(products, user);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("request/{id}")
	public Request getRequestById(@PathVariable(value = "id") long id) {
		return requestService.getRequestById(id);
	}

    @GetMapping("/v1/allproducts")
    public List<Product> getProducts(){
        return (List<Product>) productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable(value = "id") long id){
        return productService.getProduct(id);
    }
    
}
 