package com.tqs.drinkerly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqs.drinkerly.model.Rider;
import com.tqs.drinkerly.repository.RiderRepository;

@Service
public class RiderService {
    private final RiderRepository riderRepository;

    @Autowired
    public RiderService(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    public void save(Rider rider) {
        riderRepository.save(rider);
    }
    
    public List<Rider> getAllRiders() {
        return (List<Rider>) riderRepository.findAll();
    }
}
