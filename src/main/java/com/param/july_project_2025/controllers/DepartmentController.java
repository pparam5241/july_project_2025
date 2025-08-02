package com.param.july_project_2025.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.param.july_project_2025.entities.Department;
import com.param.july_project_2025.models.DepartmentRequestDto;
import com.param.july_project_2025.services.DepartmentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
@Slf4j
public class DepartmentController {
	private final DepartmentService service;

	@PostMapping
	public ResponseEntity<Department> createDepartment(@RequestBody @Valid DepartmentRequestDto dto) {
		return ResponseEntity.ok(service.createDepartment(dto));
	}

	@GetMapping
	public ResponseEntity<Page<Department>> getAllDepartment(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int pageSize) {
		return ResponseEntity.ok(service.getAllDepartments(page, pageSize));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getById(id));
	}
}