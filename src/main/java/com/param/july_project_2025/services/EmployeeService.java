package com.param.july_project_2025.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.param.july_project_2025.entities.Employee;
import com.param.july_project_2025.exceptions.NotFoundException;
import com.param.july_project_2025.models.EmployeeRequestDto;
import com.param.july_project_2025.models.EmployementType;
import com.param.july_project_2025.repositories.EmployeeRepository;

import jakarta.validation.Valid;
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

	public Employee validateAndGetEmployee(Long employeeId) {
		Optional<Employee> opt = employeeRepository.findById(employeeId);
		Employee employee = opt.orElseThrow(() -> new NotFoundException("Invalid Employee ID: " + employeeId));
		return employee;
	}

	public Employee updateEmployee(Long id, @Valid EmployeeRequestDto dto) {
		Employee employee = validateAndGetEmployee(id);
		employee.setEmploymentType(dto.getEmployementType());
		employee.setName(dto.getName());
		employee.setPhoneNumber(dto.getPhoneNumber());
		employee.setSalary(dto.getSalary());
		return employeeRepository.save(employee);

	}

	public void deleteEmployee(Long id) {
		Employee employee = validateAndGetEmployee(id);
		employeeRepository.delete(employee);
	}

	public Employee getEmployeeById(Long id) {
		return validateAndGetEmployee(id);
	}

	public List<Employee> getEmployeeByDepartmentName(String name) {
		return employeeRepository.findByDepartment_Name(name);
	}

	public Object getEmployeeByDepartmentName2(String name, boolean usingClass) {
		if (usingClass) {
			return employeeRepository.findByDepartmentName(name);
		} else {
			return employeeRepository.findByDepartmentNameUsingInterface(name);
		}
	}
}