package com.tqs.drinkerly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tqs.drinkerly.model.User;
import com.tqs.drinkerly.repository.UserRepository;

@RestController
class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/v1/users/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("users/{id}")
	public User getUserById(@PathVariable(value = "id") long id) {
		return userService.getUserById(id);
	}

	@DeleteMapping("users/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable(value = "id") long id) {
		return userService.deleteUserById(id);
	}

    @PutMapping("users/firstName/{id}")
    public User updateUserFirstNameById(@PathVariable(value = "id") long id,  @RequestParam String firstName) {
		return userService.updateUserFirstNameById(id, firstName);
	}

    @PutMapping("users/lastName/{id}")
    public User updateUserLastNameById(@PathVariable(value = "id") long id,  @RequestParam String lastName) {
		return userService.updateUserLastNameById(id, lastName);
	}

    @PutMapping("users/password/{id}")
    public User updateUserPasswordById(@PathVariable(value = "id") long id,  @RequestParam String password) {
		return userService.updateUserPasswordById(id, password);
	}

    @PutMapping("users/email/{id}")
    public User updateUserEmailById(@PathVariable(value = "id") long id,  @RequestParam String email) {
		return userService.updateUserEmailById(id, email);
	}

    @PutMapping("users/address/{id}")
    public User updateUserAddressById(@PathVariable(value = "id") long id,  @RequestParam String address) {
		return userService.updateUserAddressById(id, address);
	}

    @PutMapping("users/phone/{id}")
    public User updateUserPhoneById(@PathVariable(value = "id") long id,  @RequestParam String phone) {
		return userService.updateUserPhoneById(id, phone);
	}

    @PutMapping("users/age/{id}")
    public User updateUserAgeById(@PathVariable(value = "id") long id,  @RequestParam int age) {
		return userService.updateUserAgeById(id, age);
	}

    @PutMapping("users/nif/{id}")
    public User updateUserNifById(@PathVariable(value = "id") long id,  @RequestParam int nif) {
		return userService.updateUserNifById(id, nif);
	}
}
 