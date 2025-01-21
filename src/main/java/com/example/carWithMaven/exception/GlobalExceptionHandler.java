package com.example.carWithMaven.exception;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> internalServerError(Exception ex, WebRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", ex.getMessage());
		map.put("timestamp", System.currentTimeMillis());
		map.put("details", req.getDescription(false));
		return new ResponseEntity(map, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<Map<String, Object>> usernameNotFoundException(UsernameNotFoundException ex, WebRequest req) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", ex.getMessage());
		response.put("timestamp", System.currentTimeMillis());
		response.put("details", req.getDescription(false));

		return new ResponseEntity(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<Map<String, Object>> NoResourceFoundException(NoResourceFoundException ex, WebRequest req) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", ex.getMessage());
		response.put("timestamp", System.currentTimeMillis());
		response.put("details", req.getDescription(false));

		return new ResponseEntity(response, HttpStatus.NOT_FOUND);
	}
}

