package com.param.july_project_2025.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.param.july_project_2025.entities.Employee;
import com.param.july_project_2025.models.EmployementType;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Page<Employee> findAllByNameLikeAndEmploymentType(String search, EmployementType type, Pageable pageable);
}