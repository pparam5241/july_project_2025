package com.param.july_project_2025.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.param.july_project_2025.entities.Employee;
import com.param.july_project_2025.models.EmployeeResponseDto;
import com.param.july_project_2025.models.EmployementType;
import com.param.july_project_2025.models.IEmployeeResponseDto;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Page<Employee> findAllByNameLikeAndEmploymentType(String search, EmployementType type, Pageable pageable);

//	@Query(nativeQuery = true, value = "select * from employee where department_id = (select id from department where name = :name)")
//	@Query("from Employee e where e.department.name=:name") 

	List<Employee> findByDepartment_Name(String name);

	@Query("""
				SELECT
				    new com.param.july_project_2025.models.EmployeeResponseDto(e.name,
				    e.phoneNumber,
				    e.employmentType,
				    d.name)
				FROM
				    Employee e
				        INNER JOIN
				    Department d ON d = e.department
				WHERE
				    d.name = :name
			""")
	List<EmployeeResponseDto> findByDepartmentName(String name);

	@Query(value = """
			SELECT
			    name,
			    employement_type AS employementType,
			    phone_number AS phoneNumber
			FROM
			    employee
			WHERE
			    department_id = (SELECT
			            id
			        FROM
			            department
			        WHERE
			            name = :name)
			""", nativeQuery = true)
	List<IEmployeeResponseDto> findByDepartmentNameUsingInterface(String name);
}