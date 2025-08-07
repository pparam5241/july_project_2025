package com.param.july_project_2025.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.param.july_project_2025.entities.Employee;
import com.param.july_project_2025.models.EmployeeRequestDto;
import com.param.july_project_2025.models.EmployementType;
import com.param.july_project_2025.services.EmployeeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employee")
@Slf4j
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService service;

	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody @Valid EmployeeRequestDto dto) {
		log.info("Request : {}", dto);
		return ResponseEntity.ok(service.createEmployee(dto));
	}

	@GetMapping
	public ResponseEntity<Page<Employee>> getAllEmployees(@RequestParam int page, @RequestParam int pageSize,
			@RequestParam String search, @RequestParam EmployementType type) {
		return ResponseEntity.ok(service.getAllEmployees(page, pageSize, search, type));
	}

	@PutMapping("/{id}")
//	public ResponseEntity<Employee> updateEmployee(@PathVariable(name = "id") Long employeeId) {
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody @Valid EmployeeRequestDto dto) {
		return ResponseEntity.ok(service.updateEmployee(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		service.deleteEmployee(id);
		return ResponseEntity.ok("Employee Deleted Successfully!");
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getEmployeeById(id));
	}

	@GetMapping("/department/{name}")
	public ResponseEntity<List<Employee>> getEmployeeByDepartmentName(@PathVariable String name) {
		return ResponseEntity.ok(service.getEmployeeByDepartmentName(name));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/department2/{name}")
	public ResponseEntity<Object> getEmployeeByDepartmentName2(@PathVariable String name,
			@RequestParam(defaultValue = "false") boolean usingClass) {
		return ResponseEntity.ok(service.getEmployeeByDepartmentName2(name, usingClass));
	}
}