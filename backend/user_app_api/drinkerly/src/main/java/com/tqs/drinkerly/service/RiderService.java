package com.tqs.drinkerly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.tqs.drinkerly.model.Rider;
import com.tqs.drinkerly.repository.RiderRepository;

@Service
public class RiderService {
	
    private static RiderRepository riderRepository;

    @Autowired
    public RiderService(RiderRepository riderRepository) {
        RiderService.riderRepository = riderRepository;
    }
    
    public List<Rider> getAllRiders() {
        return (List<Rider>) riderRepository.findAll();
    }

	public Rider getRiderById(long id){
		return riderRepository.findById(id).get();
	}

	public ResponseEntity<Void> deleteRiderById(long id){

		Rider rider = riderRepository.findById(id).get();

		riderRepository.delete(rider);
		
		return ResponseEntity.noContent().build();
	}

    public Rider updateRiderEmailById(long id, @RequestParam String email) {

		Rider rider = riderRepository.findById(id).get();
				
		if (rider.getEmail() != null) {
			rider.setEmail(email);
		}

		return riderRepository.save(rider);
	}

	public Rider updateRiderFirstNameById(long id, @RequestParam String firstName) {

		Rider rider = riderRepository.findById(id).get();
				
		if (rider.getFirstName() != null) {
			rider.setFirstName(firstName);
		}

		return riderRepository.save(rider);
	}

	public Rider updateRiderLastNameById(long id, @RequestParam String lastName) {

		Rider rider = riderRepository.findById(id).get();
				
		if (rider.getLastName() != null) {
			rider.setLastName(lastName);
		}

		return riderRepository.save(rider);
	}

	public Rider updateRiderPasswordById(long id, @RequestParam String password) {

		Rider rider = riderRepository.findById(id).get();
				
		if (rider.getPassword() != null) {
			rider.setPassword(password);
		}

		return riderRepository.save(rider);
	}

	public Rider updateRiderPhoneById(long id, @RequestParam String phone) {

		Rider rider = riderRepository.findById(id).get();
				
		if (rider.getPhone() != null) {
			rider.setPhone(phone);
		}

		return riderRepository.save(rider);
	}

	public Rider updateRiderAddressById(long id, @RequestParam String address) {

		Rider rider = riderRepository.findById(id).get();
				
		if (rider.getAddress() != null) {
			rider.setAddress(address);
		}

		return riderRepository.save(rider);
	}

	public Rider updateRiderAgeById(long id, @RequestParam int age) {

		Rider rider = riderRepository.findById(id).get();
				
		if (rider.getAge() != 0) {
			rider.setAge(age);
		}

		return riderRepository.save(rider);
	}

	public Rider updateRiderNifById(long id, @RequestParam int nif) {

		Rider rider = riderRepository.findById(id).get();
				
		if (rider.getNif() != 0) {
			rider.setNif(nif);
		}

		return riderRepository.save(rider);
	}

	public Rider updateRiderVehicleTypeById(long id, @RequestParam String vehicleType) {

		Rider rider = riderRepository.findById(id).get();
				
		if (rider.getVehicleType() != null) {
			rider.setVehicleType(vehicleType);
		}

		return riderRepository.save(rider);
	}

	public Rider updateRiderLicensePlateById(long id, @RequestParam String licensePlate) {

		Rider rider = riderRepository.findById(id).get();
				
		if (rider.getLicensePlate() != null) {
			rider.setLicensePlate(licensePlate);
		}

		return riderRepository.save(rider);
	}
	
}
