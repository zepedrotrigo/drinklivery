package com.tqs.drinkerly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tqs.drinkerly.model.User;
import com.tqs.drinkerly.service.UserService;

@RestController
class UserController {

    @Autowired
	private UserService userService;

    @PostMapping("/v1/users/register")
    public ResponseEntity<User> registerUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String password, @RequestParam String address, @RequestParam int age,
    @RequestParam int nif, @RequestParam String phone, @RequestParam String email) {
        User user;

        if (password.length() < 8 || email == null || firstName == null || lastName == null || nif == 0 || phone == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            user = new User(firstName, lastName, password, address, age, nif, phone, email);
            UserService.registerUser(user);

        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
	public User getUserById(@PathVariable(value = "id") long id) {
		return userService.getUserById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable(value = "id") long id) {
		return userService.deleteUserById(id);
	}

    @PutMapping("users/{id}")
    public User updateUserFirstNameById(@PathVariable(value = "id") long id,  @RequestParam String firstName) {
		return userService.updateUserFirstNameById(id, firstName);
	}

    @PutMapping("users/{id}")
    public User updateUserLastNameById(@PathVariable(value = "id") long id,  @RequestParam String lastName) {
		return userService.updateUserLastNameById(id, lastName);
	}

    @PutMapping("users/{id}")
    public User updateUserPasswordById(@PathVariable(value = "id") long id,  @RequestParam String password) {
		return userService.updateUserPasswordById(id, password);
	}

    @PutMapping("users/{id}")
    public User updateUserEmailById(@PathVariable(value = "id") long id,  @RequestParam String email) {
		return userService.updateUserEmailById(id, email);
	}

    @PutMapping("users/{id}")
    public User updateUserAddressById(@PathVariable(value = "id") long id,  @RequestParam String address) {
		return userService.updateUserAddressById(id, address);
	}

    @PutMapping("users/{id}")
    public User updateUserPhoneById(@PathVariable(value = "id") long id,  @RequestParam String phone) {
		return userService.updateUserPhoneById(id, phone);
	}

    @PutMapping("users/{id}")
    public User updateUserAgeById(@PathVariable(value = "id") long id,  @RequestParam int age) {
		return userService.updateUserAgeById(id, age);
	}

    @PutMapping("users/{id}")
    public User updateUserNifById(@PathVariable(value = "id") long id,  @RequestParam int nif) {
		return userService.updateUserNifById(id, nif);
	}
}
 