package com.param.july_project_2025.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.param.july_project_2025.entities.Employee;
import com.param.july_project_2025.models.EmployeeRequestDto;
import com.param.july_project_2025.models.EmployementType;
import com.param.july_project_2025.repositories.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public Employee createEmployee(EmployeeRequestDto dto) {
		Employee employee = Employee.builder().name(dto.getName()).employmentType(dto.getEmployementType())
				.salary(dto.getSalary()).phoneNumber(dto.getPhoneNumber()).build();
		return employeeRepository.save(employee);
	}

	public Page<Employee> getAllEmployees(int page, int pageSize, String search, EmployementType type) {
		Pageable pageable = PageRequest.of(page, pageSize);
		return employeeRepository.findAllByNameLikeAndEmploymentType("%" + search + "%", type, pageable);
	}
}