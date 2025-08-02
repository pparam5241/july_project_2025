package com.param.july_project_2025.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.param.july_project_2025.entities.Department;
import com.param.july_project_2025.exceptions.NotFoundException;
import com.param.july_project_2025.models.DepartmentRequestDto;
import com.param.july_project_2025.repositories.DepartmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentService {
	private final DepartmentRepository repository;

	public Department createDepartment(DepartmentRequestDto dto) {
		Department department = Department.builder().name(dto.getName()).build();
		return repository.save(department);
	}

	public Page<Department> getAllDepartments(int page, int pageSize) {
		Pageable pageable = PageRequest.of(page, pageSize);
		return repository.findAll(pageable);
	}

	public Department getById(Long departmentId) {
		return repository.findById(departmentId)
				.orElseThrow(() -> new NotFoundException("Department Not Found with ID: " + departmentId));
	}
}