package com.Verligence.GSRPM.Service;

import java.util.Collections;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Verligence.GSRPM.DTO.RegistrationDTO;
import com.Verligence.GSRPM.Entity.Role;
import com.Verligence.GSRPM.Entity.User;
import com.Verligence.GSRPM.Repository.UserRepository;

import jakarta.validation.ValidationException;

@Service
public class RegistrationService {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	private static final Logger logger = LoggerFactory.getLogger(RegistrationService.class);
	
	public RegistrationService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public String registerUser(RegistrationDTO registrationDTO) {
		
		logger.info("Attempting to resister user: {}", registrationDTO.getUsername());
		
		// check for existing username
		Optional<User> existingUser = userRepository.findByUsername(registrationDTO.getUsername());
		if(existingUser.isPresent()) {
			throw new ValidationException("Username already exists");
		}
		
		// password check
		if(!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
			throw new ValidationException("Password do not match!");
		}
		
		// Create and save the user
		User user = new User();
		user.setUsername(registrationDTO.getUsername());
		user.setEmail(registrationDTO.getEmail());
		user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
		user.setRoles(Collections.singleton(Role.ROLE_USER));
		
		userRepository.save(user);
		
		logger.info("User registered successfully : {}", registrationDTO.getUsername());
		return "User registered successfully!";
	}
}
