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

    public static void save(Rider rider) {
        riderRepository.save(rider);
    }

    public static void registerRider(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String password, @RequestParam String address, @RequestParam int age, @RequestParam int nif, @RequestParam String phone,
    @RequestParam String email, @RequestParam double rating, @RequestParam String vehicleType, @RequestParam String licensePlate, @RequestParam int numDeliveries,
            int numAcceptedDeliveries, int numRefusedDeliveries, boolean occupied) {
        
        Rider rider = new Rider(firstName, lastName, password, address, age, nif, phone,
                email, rating, vehicleType, licensePlate, numDeliveries,
                numAcceptedDeliveries, numRefusedDeliveries, occupied);
        
        save(rider);
    }
    
    public List<Rider> getAllRiders() {
        return (List<Rider>) riderRepository.findAll();
    }
}
