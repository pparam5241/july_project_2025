package com.param.july_project_2025.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.param.july_project_2025.services.KafkaProducerService;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

	@Autowired
	private KafkaProducerService producerService;

	@GetMapping("/send")
	public String sendMessage(@RequestParam String msg) {
		producerService.sendMessage(msg);
		return "Message sent: " + msg;
	}
}