package com.tqs.drinkerly.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tqs.drinkerly.model.Rider;
import com.tqs.drinkerly.service.RiderService;

@RestController
class RiderController {
    @PostMapping("/v1/riders/register")
    public ResponseEntity<Rider> registerRider(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String password, @RequestParam String address, @RequestParam int age, @RequestParam int nif, @RequestParam String phone,
    @RequestParam String email, @RequestParam String vehicleType, @RequestParam String licensePlate) {
        Rider rider;

        if (password.length() < 8 || email == null || firstName == null || lastName == null || nif == 0 || phone == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            rider = new Rider(firstName, lastName, password, address, age, nif, phone,
                    email, vehicleType, licensePlate);

            RiderService.registerRider(rider);

        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(rider, HttpStatus.CREATED);
    }
}
 