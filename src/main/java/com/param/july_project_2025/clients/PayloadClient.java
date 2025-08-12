package com.param.july_project_2025.clients;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PayloadClient {

	private RestTemplate restTemplate = new RestTemplate();

	private static final String PATH = "http://localhost:8081/salary?employeeId=";

	public Object getSalariesByEmployeeId(Long employeeId) {
		try {
			String pathUrl = PATH + employeeId;
			ResponseEntity<Object> resp = restTemplate.getForEntity(pathUrl, Object.class);
			if (resp.getStatusCode().is2xxSuccessful()) {
				return resp.getBody();
			}
			throw new RuntimeException("There's some error while fetching data!");
		} catch (Exception e) {
			throw new RuntimeException("Payload call Failed!");
		}
	}
}