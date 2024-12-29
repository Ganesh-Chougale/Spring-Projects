package com.spring.jwtOnly.JWT_Decipher;

import java.util.Base64;

public class JwtDecoder {
	
	public static String decodeJwt(String jwtToken) {
		// Split JWT into parts (Header, Payload, Signature)
		String[] parts = jwtToken.split("\\.");
		
		// Decode the base64url encoded header and payload
		String header = new String(Base64.getUrlDecoder().decode(parts[0]));
		String payload = new String(Base64.getUrlDecoder().decode(parts[1]));
		
		return "Header : " + header + "\nPayload: " + payload;
	}

}
