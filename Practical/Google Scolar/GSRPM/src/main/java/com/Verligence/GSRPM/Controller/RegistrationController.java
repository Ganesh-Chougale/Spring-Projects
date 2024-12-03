package com.Verligence.GSRPM.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Verligence.GSRPM.DTO.RegistrationDTO;
import com.Verligence.GSRPM.Service.RegistrationService;

@RestController
public class RegistrationController {
	
	private final RegistrationService registrationService;
	
	public RegistrationController(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@Validated @RequestBody RegistrationDTO registrationDTO){
		String message = registrationService.registerUser(registrationDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}

}
