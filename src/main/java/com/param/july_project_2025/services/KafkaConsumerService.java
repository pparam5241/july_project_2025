package com.param.july_project_2025.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumerService {

	@KafkaListener(topics = "demo-topic", groupId = "demo-group")
	public void consume(String message) {
		log.info("Consumed message: {}", message);
	}
}