package com.tqs.drinkerly.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tqs.drinkerly.service.RiderService;

@RestController
class RiderController {
    @PostMapping("/v1/register_rider")
    public int registerRider(String firstName, String lastName, String password, String address, int age, int nif, String phone,
    String email, double rating, String vehicleType, String licensePlate, int numDeliveries,
            int numAcceptedDeliveries, int numRefusedDeliveries, boolean occupied) {

        RiderService.registerRider(firstName, lastName, password, address, age, nif, phone,
                email, rating, vehicleType, licensePlate, numDeliveries,
                numAcceptedDeliveries, numRefusedDeliveries, occupied);

        return 200;
    }
}
 