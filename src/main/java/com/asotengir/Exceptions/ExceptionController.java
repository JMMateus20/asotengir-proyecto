package com.asotengir.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<String> returnResponseStatusException (ResponseStatusException e){
		return ResponseEntity.badRequest().body(e.getReason());
	}

}
