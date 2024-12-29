package com.spring.jwtOnly.JWT_Generation;

public class PrintEncode {
	
	public static void printGeneratedToken() {
		String jwtToken = JWTGenerator.generateToken();
		System.out.println("Generated JWT Tokeen: " + jwtToken);
	}
}