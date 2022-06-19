package com.tqs.drinkerly.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tqs.drinkerly.model.Rider;
import com.tqs.drinkerly.repository.RiderRepository;

@RestController
class RiderController {
    @Autowired
    RiderRepository riderRepository;

    @GetMapping("/")
    @ResponseBody
    String getSomeEndPoint()
            throws IOException, InterruptedException {
        return "okey";
    }

    @PostMapping("/v1/riders/register")
    public ResponseEntity<Rider> registerRider(@RequestBody Rider rider) {
        riderRepository.save(rider);
        return new ResponseEntity<>(rider, HttpStatus.CREATED);
    }
}
 