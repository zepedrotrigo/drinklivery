package com.tqs.drinkerly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tqs.drinkerly.model.Winery;
import com.tqs.drinkerly.repository.WineryRepository;

@RestController
@RequestMapping("/v1/wineries/")
class WineryController {
    @Autowired
    WineryRepository wineryRepository;

    @PostMapping("/register")
    public ResponseEntity<Winery> registerWinery(@RequestBody Winery winery) {
        if (winery.getPassword().length() < 8 || winery.getEmail() == null || winery.getEmail().equals("")
                || winery.getName() == null || winery.getName().equals("")
                || winery.getAddress() == null || winery.getAddress().equals("")
                || winery.getNif() == 0 || winery.getPhone() == null || winery.getPhone().equals(""))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    
        wineryRepository.save(winery);
        return new ResponseEntity<>(winery, HttpStatus.CREATED);
    }
}
 