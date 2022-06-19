package com.tqs.drinkerly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.tqs.drinkerly.model.Rider;
import com.tqs.drinkerly.repository.RiderRepository;

@Service
public class RiderService {
    private static RiderRepository riderRepository;

    @Autowired
    public RiderService(RiderRepository riderRepository) {
        RiderService.riderRepository = riderRepository;
    }
    
    public List<Rider> getAllRiders() {
        return (List<Rider>) riderRepository.findAll();
    }
}
