package com.revatureconnects.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.revatureconnects.entity.Employee;
import com.revatureconnects.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public int registerEmployee(Employee employee) {
		
		if(employeeRepository.existsByEmail(employee.getEmail())) {
			return 0;
		}
		
		employeeRepository.save(employee);
		return 1;
	}

	
	@Override
	public Employee employeeLogin(Employee employee) {
	    Employee existingEmployee = employeeRepository.findByEmail(employee.getEmail());
	    
	    if (existingEmployee == null) {
	        throw new RuntimeException("Invalid email or password");
	    }

	    if (!passwordEncoder.matches(employee.getPassword(), existingEmployee.getPassword())) {
	        throw new RuntimeException("Invalid email or password");
	    }

	    return existingEmployee;
	}
	
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

}
