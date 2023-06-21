package com.zara.test.app.exception;


import static feign.FeignException.*;

import java.net.ConnectException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


import io.github.resilience4j.circuitbreaker.CallNotPermittedException;

@ControllerAdvice
public class ProductControllerException {
	@ExceptionHandler(CallNotPermittedException.class)
	@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
	public ResponseEntity<String> handleCallNotPermittedException(CallNotPermittedException exception) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(exception.getMessage());
	}

	@ExceptionHandler(ConnectException.class)
	@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
	public ResponseEntity<String> handleConnectException(ConnectException exception) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("mockproduct: "+exception.getMessage());
	}
	@ExceptionHandler(NotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<String> handleNotFound(NotFound exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}
	
}
