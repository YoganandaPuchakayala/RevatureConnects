package com.revatureconnects.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.revatureconnects.entity.Employee;

@Service
public interface EmployeeService {
	
	int registerEmployee(Employee employee);
	
	Employee employeeLogin(Employee employee);
	
	List<Employee> getAllEmployees();
	
	
	

}
