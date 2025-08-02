package com.param.july_project_2025.models;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DepartmentRequestDto {

	@NotBlank(message = "Department Name cannot be null or empty.")
	private String name;
}