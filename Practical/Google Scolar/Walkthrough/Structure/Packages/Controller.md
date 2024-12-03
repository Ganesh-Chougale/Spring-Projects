## GlobalExceptionHandler.java  
```java
package com.Verligence.GSRPM.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ValidationException;
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationErrors(MethodArgumentNotValidException ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ex.getBindingResult().getFieldError()
						.getDefaultMessage());
	}
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<String> handleValidationExceptions(ValidationException ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ex.getMessage());
	}
}
```  
## RegistrationController.java  
```java
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
```  