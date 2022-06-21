package com.tqs.drinkerly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tqs.drinkerly.model.Product;
import com.tqs.drinkerly.model.User;
import com.tqs.drinkerly.repository.ProductRepository;
import com.tqs.drinkerly.repository.UserRepository;

@Component
public class DataInitializer implements ApplicationRunner {
    private ProductRepository productRepository;
    private UserRepository userRepository;

    @Autowired
    public DataInitializer(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {

        User u1 = userRepository.findByEmail("user.teste@gmail.com");
        if (u1 == null) {
            u1 = new User("Utilizador", "Teste", "9122378776918b2b7d5e7663c40182c6fda4e5148d8df835d68dba172df27653", "Teste", 21, 259171137, "938341123",
                    "user.teste@gmail.com");
            userRepository.save(u1);
        }

        Product p1 = productRepository.findByName("Gerações de Xisto");
        if (p1 == null) {
            p1 = new Product("Gerações de Xisto", "RED", "Portugal", "Douro Superior", "Tinta Roriz",
            "Descrição...", 0.75, 13.5, 2.79, 4.99, 3.9, 23, 20);
            productRepository.save(p1);
        }
    }
}
