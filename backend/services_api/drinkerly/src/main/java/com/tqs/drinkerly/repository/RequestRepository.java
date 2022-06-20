package com.tqs.drinkerly.repository;

import org.springframework.data.repository.CrudRepository;
import com.tqs.drinkerly.model.Request;

public interface RequestRepository extends CrudRepository<Request, Long> {
    
}