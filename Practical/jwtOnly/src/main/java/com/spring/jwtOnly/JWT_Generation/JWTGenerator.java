package com.spring.jwtOnly.JWT_Generation;

import java.security.Key;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JWTGenerator {
	
	private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	private static final long EXPRITATION_TIME = 1000 * 60 * 30;
	
	public static String generateToken() {
		return Jwts.builder()
				.setSubject("Default User")
				.claim("role", "user")
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+ EXPRITATION_TIME))
				.signWith(SECRET_KEY)
				.compact();
	}

}