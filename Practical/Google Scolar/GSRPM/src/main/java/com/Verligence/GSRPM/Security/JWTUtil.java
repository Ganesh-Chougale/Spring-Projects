package com.Verligence.GSRPM.Security;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.Verligence.GSRPM.Entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	
	private final String SECRET_KEY = "Verligence.GSRPM.Security";
	private final long EXPIRATION_TIME = 86400000L;
	
	public String generateToken(User user) {
		return Jwts.builder()
				.setSubject(user.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
				.compact();
	}

}
