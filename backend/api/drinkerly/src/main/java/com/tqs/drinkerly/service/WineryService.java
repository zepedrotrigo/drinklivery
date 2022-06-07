package com.tqs.drinkerly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqs.drinkerly.model.Winery;
import com.tqs.drinkerly.repository.WineryRepository;

@Service
public class WineryService {
    private final WineryRepository wineryRepository;

    @Autowired
    public WineryService(WineryRepository wineryRepository) {
        this.wineryRepository = wineryRepository;
    }

    public void save(Winery winery) {
        wineryRepository.save(winery);
    }
    
    public Iterable<Winery> getAllWinerys() {
        return wineryRepository.findAll();
    }
}
