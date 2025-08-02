package com.param.july_project_2025.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.param.july_project_2025.services.AsyncService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
@Slf4j
public class PublicController {

	private final AsyncService service;

	@GetMapping("/health")
	public ResponseEntity<String> checkHealth() {
		return ResponseEntity.ok("Application is running!");
	}

	@GetMapping("/async")
	public ResponseEntity<String> asyncMethod() throws InterruptedException {
		log.info("Thread Name in PublicController: {}", Thread.currentThread().getName());
		service.asyncMethod1();
		return ResponseEntity.ok("Async Method Called");
	}
	
	@GetMapping("/async/future")
	public ResponseEntity<String> asyncMethodUsingFuture() throws InterruptedException {
		log.info("Thread Name in PublicController: {}", Thread.currentThread().getName());
		service.asyncMethod2();
		return ResponseEntity.ok("Async Method Called");
	}
}