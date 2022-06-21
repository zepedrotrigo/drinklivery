package com.tqs.drinkerly.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tqs.drinkerly.model.User;
import com.tqs.drinkerly.repository.UserRepository;
import com.tqs.drinkerly.service.UserService;

@RestController
@RequestMapping("/v1/users/")
class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
      if (user.getPassword().length() < 8 || user.getEmail() == null || user.getEmail().equals("")
          || user.getFirstName() == null || user.getFirstName().equals("")
          || user.getLastName() == null || user.getLastName().equals("")
          || user.getNif() == 0 || user.getPhone() == null || user.getPhone().equals(""))
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

      userRepository.save(user);
      return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<User> createAuthenticationToken(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String password = payload.get("password");
        try {
          User user = userService.getUserByEmail(email);
          
          if (user.getEmail().equals(email) && user.getPassword().equals(password))
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        } catch (NullPointerException e) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/{id}")
	public User getUserById(@PathVariable(value = "id") long id) {
		return userService.getUserById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable(value = "id") long id) {
		return userService.deleteUserById(id);
	}

    @PutMapping("/firstName/{id}")
    public User updateUserFirstNameById(@PathVariable(value = "id") long id,  @RequestBody Map<String,String> firstName) {
		return userService.updateUserFirstNameById(id, firstName.get("firstName"));
	}

    @PutMapping("/lastName/{id}")
    public User updateUserLastNameById(@PathVariable(value = "id") long id,  @RequestBody Map<String,String> lastName) {
		return userService.updateUserLastNameById(id, lastName.get("lastName"));
	}

    @PutMapping("/password/{id}")
    public User updateUserPasswordById(@PathVariable(value = "id") long id,  @RequestBody Map<String,String> password) {
		return userService.updateUserPasswordById(id, password.get("password"));
	}

    @PutMapping("/email/{id}")
    public User updateUserEmailById(@PathVariable(value = "id") long id,  @RequestBody Map<String,String> email) {
		return userService.updateUserEmailById(id, email.get("email"));
	}

    @PutMapping("/address/{id}")
    public User updateUserAddressById(@PathVariable(value = "id") long id,  @RequestBody Map<String,String> address) {
		return userService.updateUserAddressById(id, address.get("address"));
	}

    @PutMapping("/phone/{id}")
    public User updateUserPhoneById(@PathVariable(value = "id") long id,  @RequestBody Map<String,String> phone) {
		return userService.updateUserPhoneById(id, phone.get("phone"));
	}

    @PutMapping("/age/{id}")
    public User updateUserAgeById(@PathVariable(value = "id") long id,  @RequestBody Map<String,Integer> age) {
		return userService.updateUserAgeById(id, age.get("age"));
	}

    @PutMapping("/nif/{id}")
    public User updateUserNifById(@PathVariable(value = "id") long id,  @RequestBody Map<String,Integer> nif) {
		return userService.updateUserNifById(id, nif.get("nif"));
	}
}
 