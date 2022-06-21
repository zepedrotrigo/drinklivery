package com.tqs.drinkerly.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tqs.drinkerly.model.Rider;
import com.tqs.drinkerly.repository.RiderRepository;
import com.tqs.drinkerly.service.RiderService;

@RestController
@RequestMapping("/v1/riders/")
class RiderController {

    @Autowired
    RiderRepository riderRepository;

    @Autowired
    private RiderService riderService;

    @GetMapping("/")
    public List<Rider> getAllRiders() {
      return riderService.getAllRiders();
    }

    @PostMapping("/register")
    public ResponseEntity<Rider> registerRider(@RequestBody Rider rider) {
      if (rider.getPassword().length() < 8 || rider.getEmail() == null || rider.getEmail().equals("")
          || rider.getFirstName() == null || rider.getFirstName().equals("")
          || rider.getLastName() == null || rider.getLastName().equals("")
          || rider.getNif() == 0 || rider.getPhone() == null || rider.getPhone().equals(""))
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

      riderRepository.save(rider);
      return new ResponseEntity<>(rider, HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<Rider> login(@RequestBody Map<String, String> payload) {
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


  @GetMapping("/{id}")
	public Rider getRiderById(@PathVariable(value = "id") long id) {
		return riderService.getRiderById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRiderById(@PathVariable(value = "id") long id) {
		return riderService.deleteRiderById(id);
	}

    @PutMapping("/email/{id}")
    public Rider updateRiderEmailById(@PathVariable(value = "id") long id,   @RequestBody Map<String,String> email) {
		return riderService.updateRiderEmailById(id, email.get("email"));
	}

    @PutMapping("/firstName/{id}")
    public Rider updateRiderFirstNameById(@PathVariable(value = "id") long id,  @RequestBody Map<String,String> firstName) {
    //System.out.println(riderService.updateRiderFirstNameById(id, firstName.get("firstName").toString()));
   
		return riderService.updateRiderFirstNameById(id, firstName.get("firstName"));
	}

    @PutMapping("/lastName/{id}")
    public Rider updateRiderLastNameById(@PathVariable(value = "id") long id,   @RequestBody Map<String,String> lastName) {
		return riderService.updateRiderLastNameById(id, lastName.get("lastName"));
	}

    @PutMapping("/password/{id}")
    public Rider updateRiderPasswordById(@PathVariable(value = "id") long id,  @RequestBody Map<String,String> password) {
		return riderService.updateRiderPasswordById(id, password.get("password"));
	}

    @PutMapping("/phone/{id}")
    public Rider updateRiderPhoneById(@PathVariable(value = "id") long id,  @RequestBody Map<String,String> phone) {
		return riderService.updateRiderPhoneById(id, phone.get("phone"));
	}

    @PutMapping("/address/{id}")
    public Rider updateRiderAddressById(@PathVariable(value = "id") long id,  @RequestBody Map<String,String> address) {
		return riderService.updateRiderAddressById(id, address.get("address"));
	}

    @PutMapping("/age/{id}")
    public Rider updateRiderAgeById(@PathVariable(value = "id") long id,  @RequestBody Map<String,Integer> age) {
		return riderService.updateRiderAgeById(id, age.get("age"));
	}

    @PutMapping("/nif/{id}")
    public Rider updateRiderNifById(@PathVariable(value = "id") long id,  @RequestBody Map<String,Integer> nif) {
		return riderService.updateRiderNifById(id, nif.get("nif"));
	}

    @PutMapping("/vehicleType/{id}")
    public Rider updateRiderVehicleTypeById(@PathVariable(value = "id") long id,  @RequestBody Map<String,String>  vehicleType) {
		return riderService.updateRiderVehicleTypeById(id, vehicleType.get("vehicleType"));
	}

    @PutMapping("/licensePlate/{id}")
    public Rider updateRiderLicensePlateById(@PathVariable(value = "id") long id, @RequestBody Map<String,String>  licensePlate) {
      return riderService.updateRiderLicensePlateById(id, licensePlate.get("licensePlate"));
    }
}
 