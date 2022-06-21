package com.tqs.drinkerly.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime; 
import com.tqs.drinkerly.model.Product;
import com.tqs.drinkerly.model.Request;
import com.tqs.drinkerly.model.User;
import com.tqs.drinkerly.model.Rider;
import com.tqs.drinkerly.repository.RequestRepository;
import com.tqs.drinkerly.service.RiderService;

//Another One
//Anoothwe
@Service
public class RequestService {

    @Autowired
    private final RiderService riderService;

    @Autowired
    private final RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository, RiderService riderService) {
        this.requestRepository = requestRepository;
        this.riderService = riderService;
    }

    public void saveRequest(Request request){
        List<Rider> riders = riderService.getAllRiders();
        Collections.shuffle(riders);
        for (Integer i = 0; i < riders.size(); i ++){
            if (!riders.get(i).getOccupied()){
                riders.get(i).setOccupied(true);
                riders.get(i).setNumAcceptedDeliveries(riders.get(i).getNumAcceptedDeliveries()+1);
                request.setDeliverRider(riders.get(i));                
            }
        }
        save(request);
        
    }

    public Request getRequestById(long id){
		return requestRepository.findById(id).get();
	}

    public void save(Request request) {
        requestRepository.save(request);
    }
    
    public Iterable<Request> getAllRequests() {
        return requestRepository.findAll();
    }
}
