package com.spring.jwtOnly.JWT_Decipher;

public class PrintDecode {
	
	public static void printDecodedToken(String jwtToken) {
		String decodeJwt = JwtDecoder.decodeJwt(jwtToken);
		System.out.println(decodeJwt);
	}

}
