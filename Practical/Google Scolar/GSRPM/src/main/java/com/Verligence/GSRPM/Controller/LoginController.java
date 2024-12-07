package com.Verligence.GSRPM.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Verligence.GSRPM.DTO.AuthenticationRequestDTO;
import com.Verligence.GSRPM.Service.AuthenticationService;

@RestController
public class LoginController {
	
	private final AuthenticationService authenticationService;
	
	public LoginController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@Validated @RequestBody AuthenticationRequestDTO authenticationRequestDTO){
		String token = authenticationService.authenticate(authenticationRequestDTO);
		return ResponseEntity.status(HttpStatus.OK).body("Bearer" + token);
	}
}
