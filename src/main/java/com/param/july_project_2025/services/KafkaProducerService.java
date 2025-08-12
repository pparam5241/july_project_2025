package com.param.july_project_2025.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerService {
	private static final String TOPIC = "demo-topic";

	private final KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {
		kafkaTemplate.send(TOPIC, message);
		log.info("Produced message: {}", message);
	}
}