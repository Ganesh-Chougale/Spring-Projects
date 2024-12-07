package com.Verligence.GSRPM.Service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Verligence.GSRPM.DTO.AuthenticationRequestDTO;
import com.Verligence.GSRPM.Entity.User;
//import com.Verligence.GSRPM.Security.JWTUtil;
import com.Verligence.GSRPM.Repository.UserRepository;
import com.Verligence.GSRPM.Security.JWTUtil;

@Service
public class AuthenticationService {
	
	private final AuthenticationManager authenticationManager;
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	private final JWTUtil jwtUtil;
	
	public AuthenticationService(AuthenticationManager authenticationManager, UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, JWTUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
	}
	
	public String authenticate(AuthenticationRequestDTO authenticationRequestDTO) {
		
		// verify user
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authenticationRequestDTO.getUsername(), authenticationRequestDTO.getPassword());
		
		authenticationManager.authenticate(authenticationToken);
		
		// find the user by username
		User user = userRepository.findByUsername(authenticationRequestDTO.getUsername()).orElseThrow(()-> new RuntimeException("user not found"));
		
		// Generate JWT Token
		return jwtUtil.generateToken(user);
		
	}
	
	

}
