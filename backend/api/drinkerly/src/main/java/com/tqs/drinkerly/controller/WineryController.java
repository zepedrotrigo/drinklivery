package com.tqs.drinkerly.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tqs.drinkerly.service.WineryService;

@RestController
class WineryController {
    @PostMapping("/v1/register_winery")
    public int registerWinery(String name, String address, int nif, String phone, String email, String website) {

        WineryService.registerWinery(name, address, nif, phone, email, website);

        return 200;
    }
}
 