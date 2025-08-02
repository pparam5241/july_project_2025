package com.param.july_project_2025.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.param.july_project_2025.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}