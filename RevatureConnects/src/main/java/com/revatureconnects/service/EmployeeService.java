package com.revatureconnects.service;


import org.springframework.stereotype.Service;

import com.revatureconnects.entity.Employee;
@Service

public interface EmployeeService {
	
	int registerEmployee(Employee employee);
	
	Employee loginEmployee(Employee employee);
	
	

}
