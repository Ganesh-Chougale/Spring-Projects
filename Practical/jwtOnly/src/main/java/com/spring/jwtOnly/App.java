package com.spring.jwtOnly;

import com.spring.jwtOnly.JWT_Decipher.PrintDecode;
import com.spring.jwtOnly.JWT_Generation.JWTGenerator;
import com.spring.jwtOnly.JWT_Generation.PrintEncode;

public class App {
	
    public static void main( String[] args )    {    	
        System.out.println( "Hello World!" );
        
        String jwtToken = JWTGenerator.generateToken();
        PrintEncode.printGeneratedToken();
        
        PrintDecode.printDecodedToken(jwtToken);
        

    }
    	
}
