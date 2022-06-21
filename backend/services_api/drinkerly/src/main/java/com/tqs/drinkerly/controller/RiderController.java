package com.tqs.drinkerly.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tqs.drinkerly.model.Rider;
import com.tqs.drinkerly.repository.RiderRepository;
import com.tqs.drinkerly.service.RiderService;

@RestController
class RiderController {

    @Autowired
    RiderRepository riderRepository;

    @Autowired
    private RiderService riderService;

    @PostMapping("/v1/riders/register")
    public ResponseEntity<Rider> registerRider(@RequestBody Rider rider) {
      if (rider.getPassword().length() < 8 || rider.getEmail() == null || rider.getEmail().equals("")
          || rider.getFirstName() == null || rider.getFirstName().equals("")
          || rider.getLastName() == null || rider.getLastName().equals("")
          || rider.getNif() == 0 || rider.getPhone() == null || rider.getPhone().equals(""))
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

      riderRepository.save(rider);
      return new ResponseEntity<>(rider, HttpStatus.CREATED);
    }
    
    @PostMapping("/v1/riders/login")
    public ResponseEntity<Rider> createAuthenticationToken(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String password = payload.get("password");
        try {
          Rider rider = riderService.getRiderByEmail(email);
          
          if (rider.getEmail().equals(email) && rider.getPassword().equals(password))
            return new ResponseEntity<>(rider, HttpStatus.ACCEPTED);
        } catch (NullPointerException e) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/v1/riders")
    public List<Rider> getAllRiders() {
      return riderService.getAllRiders();
    }

    @GetMapping("/v1/riders/{id}")
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
 