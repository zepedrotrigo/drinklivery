package com.tqs.drinkerly.repository;

import org.springframework.data.repository.CrudRepository;
import com.tqs.drinkerly.model.Request;
import com.tqs.drinkerly.model.Rider;

public interface RequestRepository extends CrudRepository<Request, Long> {
    Request findByDeliverRider(Rider rider);

    void saveAndFlush(Request uUpdated);
}