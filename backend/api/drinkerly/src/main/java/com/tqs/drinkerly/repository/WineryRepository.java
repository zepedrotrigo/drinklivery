package com.tqs.drinkerly.repository;

import org.springframework.data.repository.CrudRepository;
import com.tqs.drinkerly.model.Winery;

public interface WineryRepository extends CrudRepository<Winery, Long> {
    
}