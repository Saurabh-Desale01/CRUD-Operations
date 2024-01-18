package com.developer.fullstackcrudoperations.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.fullstackcrudoperations.exception.UserNotFoundException;
import com.developer.fullstackcrudoperations.model.User;
import com.developer.fullstackcrudoperations.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User newUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> fetchUsers(){
		return userRepository.findAll();
	}
	
	public Optional<User> fetchById(long id) {
		return userRepository.findById(id);
	}
	
	public User updateUser(User existingUser, long id) {
		return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(existingUser.getUsername());
                    user.setName(existingUser.getName());
                    user.setEmail(existingUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
	}
	
	public void deleteUser(long id) {
		if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
		userRepository.deleteById(id);
	}

}
