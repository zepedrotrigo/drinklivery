package com.tqs.drinkerly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tqs.drinkerly.model.Winery;
import com.tqs.drinkerly.repository.WineryRepository;

@RestController
class WineryController {
    @Autowired
    WineryRepository wineryRepository;

    @PostMapping("/v1/wineries/register")
    public ResponseEntity<Winery> registerWinery(@RequestBody Winery winery) {
        wineryRepository.save(winery);
        return new ResponseEntity<>(winery, HttpStatus.CREATED);
    }
}
 