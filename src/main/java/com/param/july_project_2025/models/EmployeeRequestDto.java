package com.param.july_project_2025.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeRequestDto {
	@NotBlank(message = "Name cannot be null or empty.")
	private String name;

	@NotBlank(message = "Phone Number cannot be null or empty.")
	@JsonProperty("phone_number")
	private String phoneNumber;

	@NotNull(message = "Salary cannot be null.")
	private Double salary;

	@NotNull(message = "Employement type cannot be null")
	@JsonProperty("employement_type")
	private EmployementType employementType;
}