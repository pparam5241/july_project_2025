package com.param.july_project_2025.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDto {
	private String name;

	@JsonProperty("phone_number")
	private String phoneNumber;

	@JsonProperty("employment_type")
	private EmployementType employmentType;

	@JsonProperty("department_name")
	private String departmentName;
}