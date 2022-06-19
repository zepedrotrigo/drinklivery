package com.tqs.drinkerly.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tqs.drinkerly.model.Winery;
import com.tqs.drinkerly.service.WineryService;

@RestController
class WineryController {
    @PostMapping("/v1/wineries/register")
    public ResponseEntity<Winery> registerWinery(@RequestParam String name, @RequestParam String address, @RequestParam int nif, @RequestParam String phone, @RequestParam String email, @RequestParam String website) {
        Winery winery;

        if (name == null || address == null || email == null || nif == 0 || phone == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            winery = new Winery(name, address, nif, phone, email, website);
            WineryService.registerWinery(winery);

        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(winery, HttpStatus.CREATED);
    }
}
 