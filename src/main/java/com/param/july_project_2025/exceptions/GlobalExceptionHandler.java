package com.param.july_project_2025.exceptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException ex) {
		Map<String, Object> errors = new HashMap<>();
		List<String> errorList = new ArrayList<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			errorList.add(error.getDefaultMessage());
		});
		errors.put("errors", errorList);
		errors.put("status", HttpStatus.BAD_REQUEST);
		errors.put("timestamp", new Date());
		errors.put("code", HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}