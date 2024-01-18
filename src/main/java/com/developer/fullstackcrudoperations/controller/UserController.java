package com.developer.fullstackcrudoperations.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developer.fullstackcrudoperations.model.User;
import com.developer.fullstackcrudoperations.service.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin("http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public User createUser(@RequestBody User user) {
		return userService.newUser(user);
	}
	
	@GetMapping("/get")
	public List<User> getAllUsers(){
		return userService.fetchUsers();
	}
	
	@GetMapping("/get/{id}")
	public Optional<User> getUserById(@PathVariable long id){
		return userService.fetchById(id);
	}
	
	@PutMapping("get/{id}")
	public User updateUserById(@RequestBody User existingUser, @PathVariable long id) {
		return userService.updateUser(existingUser, id);
	}
	
	@DeleteMapping("get/{id}")
	public String deleteUserById(@PathVariable long id) {
		userService.deleteUser(id);
		return "User Deleted Successfully";
	}

}
