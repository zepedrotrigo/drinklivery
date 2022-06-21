package com.tqs.drinkerly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.tqs.drinkerly.model.Product;
import com.tqs.drinkerly.model.Winery;
import com.tqs.drinkerly.repository.ProductRepository;

@Component
public class ProductsInitializer implements ApplicationRunner {
    private ProductRepository productRepository;

    @Autowired
    public ProductsInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void run(ApplicationArguments args) {
        Winery w1 = new Winery("Quinta Palatos", "Vila Nova de Foz Coa", 259171137, "938343542",
                "comercial.palatos@gmail.com", "testingpassword123", "www.vinho-palatos.pt");

        Product p1 = new Product("Gerações de Xisto", "RED", "Portugal", "Douro Superior", "Tinta Roriz",
                "Descrição...", 0.75, 13.5, 2.79, 4.99, 3.9, 23, 20, w1);

        productRepository.save(p1);
    }
}
