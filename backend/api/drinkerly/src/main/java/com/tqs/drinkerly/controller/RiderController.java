package com.tqs.drinkerly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tqs.drinkerly.model.Rider;
import com.tqs.drinkerly.service.RiderService;

@RestController
class RiderController {

    @Autowired
	private RiderService riderService;


    @PostMapping("/v1/riders/register")
    public ResponseEntity<Rider> registerRider(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String password, @RequestParam String address, @RequestParam int age, @RequestParam int nif, @RequestParam String phone,
    @RequestParam String email, @RequestParam double rating, @RequestParam String vehicleType, @RequestParam String licensePlate, @RequestParam int numDeliveries,
    @RequestParam int numAcceptedDeliveries, @RequestParam int numRefusedDeliveries, @RequestParam boolean occupied) {
        Rider rider;

        if (password.length() < 8 || email == null || firstName == null || lastName == null || nif == 0 || phone == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            rider = new Rider(firstName, lastName, password, address, age, nif, phone,
                    email, rating, vehicleType, licensePlate, numDeliveries,
                    numAcceptedDeliveries, numRefusedDeliveries, occupied);

            RiderService.registerRider(rider);

        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(rider, HttpStatus.CREATED);
    }

    @GetMapping("riders/{id}")
	public Rider getRiderById(@PathVariable(value = "id") long id) {
		return riderService.getRiderById(id);
	}

	@DeleteMapping("riders/{id}")
	public ResponseEntity<Void> deleteRiderById(@PathVariable(value = "id") long id) {
		return riderService.deleteRiderById(id);
	}

    @PutMapping("riders/email/{id}")
    public Rider updateRiderEmailById(@PathVariable(value = "id") long id,  @RequestParam String email) {
		return riderService.updateRiderEmailById(id, email);
	}

    @PutMapping("riders/firstName/{id}")
    public Rider updateRiderFirstNameById(@PathVariable(value = "id") long id,  @RequestParam String firstName) {
		return riderService.updateRiderFirstNameById(id, firstName);
	}

    @PutMapping("riders/lastName/{id}")
    public Rider updateRiderLastNameById(@PathVariable(value = "id") long id,  @RequestParam String lastName) {
		return riderService.updateRiderLastNameById(id, lastName);
	}

    @PutMapping("riders/password/{id}")
    public Rider updateRiderPasswordById(@PathVariable(value = "id") long id,  @RequestParam String password) {
		return riderService.updateRiderPasswordById(id, password);
	}

    @PutMapping("riders/phone/{id}")
    public Rider updateRiderPhoneById(@PathVariable(value = "id") long id,  @RequestParam String phone) {
		return riderService.updateRiderPhoneById(id, phone);
	}

    @PutMapping("riders/address/{id}")
    public Rider updateRiderAddressById(@PathVariable(value = "id") long id,  @RequestParam String address) {
		return riderService.updateRiderAddressById(id, address);
	}

    @PutMapping("riders/age/{id}")
    public Rider updateRiderAgeById(@PathVariable(value = "id") long id,  @RequestParam int age) {
		return riderService.updateRiderAgeById(id, age);
	}

    @PutMapping("riders/nif/{id}")
    public Rider updateRiderNifById(@PathVariable(value = "id") long id,  @RequestParam int nif) {
		return riderService.updateRiderNifById(id, nif);
	}

    @PutMapping("riders/vehicleType/{id}")
    public Rider updateRiderVehicleTypeById(@PathVariable(value = "id") long id,  @RequestParam String vehicleType) {
		return riderService.updateRiderVehicleTypeById(id, vehicleType);
	}

    @PutMapping("riders/licensePlate/{id}")
    public Rider updateRiderLicensePlateById(@PathVariable(value = "id") long id,  @RequestParam String licensePlate) {
		return riderService.updateRiderLicensePlateById(id, licensePlate);
	}
}
 