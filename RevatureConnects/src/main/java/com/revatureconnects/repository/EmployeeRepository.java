package com.revatureconnects.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revatureconnects.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Employee findByEmail(String email);
	
	boolean existsByEmail(String email);
	
	List<Employee> findAll();

	
	
}
