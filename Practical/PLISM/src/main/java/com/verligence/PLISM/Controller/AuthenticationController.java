package com.verligence.PLISM.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.verligence.PLISM.Service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verligence.PLISM.DTO.LoginDTO;
import com.verligence.PLISM.Security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        String jwtToken = userService.authenticateUser(loginDTO.getUsername(), loginDTO.getPassword());
        // if authenticate return token
        return ResponseEntity.ok(jwtToken);
    }

}
