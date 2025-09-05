package com.revatureconnects.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revatureconnects.entity.Employee;
import com.revatureconnects.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public int registerEmployee(Employee employee) {
		
		if(employeeRepository.existsByEmail(employee.getEmail())) {
			return 0;
		}
		
		employeeRepository.save(employee);
		return 1;
	}

	@Override
	public Employee loginEmployee(Employee employee) {
		
		Employee existingEmployeeOptional = employeeRepository.findByEmail(employee.getEmail());
		
		if(existingEmployeeOptional.getPassword().equals(employee.getPassword())) {
			return existingEmployeeOptional;
		}else {
			throw new RuntimeException("Invalid email or password");
		}
		
	}

}
