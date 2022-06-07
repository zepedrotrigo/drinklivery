package com.tqs.drinkerly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime; 
import com.tqs.drinkerly.model.Product;
import com.tqs.drinkerly.model.Request;
import com.tqs.drinkerly.model.User;
import com.tqs.drinkerly.model.Rider;
import com.tqs.drinkerly.repository.RequestRepository;
import com.tqs.drinkerly.repository.RiderRepository;

@Service
public class RequestService {
    @Autowired
    private final RiderService riderService;

    private final RequestRepository requestRepository;
    


    @Autowired
    public RequestService(RequestRepository requestRepository, RiderService riderService) {
        this.requestRepository = requestRepository;
        this.riderService = riderService;
    }

    public void saveRequest(List<String> Products, User user ){
        List<Rider> Riders = riderService.getAllRiders();
        Rider deliverRider = Riders.get(0);
        Request req = new Request( deliverRider, LocalDateTime.now(), user, Products);
        save(req);
    }

    public void save(Request request) {
        requestRepository.save(request);
    }
    
    public Iterable<Request> getAllRequests() {
        return requestRepository.findAll();
    }
}
