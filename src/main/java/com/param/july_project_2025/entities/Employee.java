package com.param.july_project_2025.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.param.july_project_2025.models.EmployementType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private double salary;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Enumerated(EnumType.STRING)
	@Column(name = "employement_type")
	private EmployementType employmentType;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(columnDefinition = "department_id")
	private Department department;

	@Transient
	Object salaries;
}