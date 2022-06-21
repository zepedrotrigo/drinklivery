package com.tqs.drinkerly.repository;

import org.springframework.data.repository.CrudRepository;
import com.tqs.drinkerly.model.Rider;

public interface RiderRepository extends CrudRepository<Rider, Long> {

    Rider findByEmail(String email);

    Rider deleteByEmail(String email);

    void saveAndFlush(Rider rUpdated);
}