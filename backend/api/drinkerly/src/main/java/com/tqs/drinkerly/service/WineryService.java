package com.tqs.drinkerly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.tqs.drinkerly.model.Winery;
import com.tqs.drinkerly.repository.WineryRepository;

@Service
public class WineryService {
    private static WineryRepository wineryRepository;

    @Autowired
    public WineryService(WineryRepository wineryRepository) {
        WineryService.wineryRepository = wineryRepository;
    }

    public static void save(Winery winery) {
        wineryRepository.save(winery);
    }

    public static void registerWinery(@RequestParam String name, @RequestParam String address, @RequestParam int nif, @RequestParam String phone, @RequestParam String email, @RequestParam String website) {
        
        Winery winery = new Winery(name, address, nif, phone, email, website);
        
        save(winery);
    }
    
    public Iterable<Winery> getAllWinerys() {
        return wineryRepository.findAll();
    }
}
