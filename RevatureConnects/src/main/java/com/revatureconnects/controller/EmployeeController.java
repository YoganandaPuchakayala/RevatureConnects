package com.revatureconnects.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revatureconnects.entity.Employee;
import com.revatureconnects.service.*;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/registerEmployee")
	public ResponseEntity<String> registerEmployee(@RequestBody Employee employee){
		int result = empService.registerEmployee(employee);
		
		if(result == 1) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Employee registered successfully");
		}else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
		} 
	}
	
	@PostMapping("/loginEmployee")
	public ResponseEntity<Employee> loginEmployee(@RequestBody Employee employee){
		try {
			
			Employee loggedInEmp = empService.loginEmployee(employee);
			
			return ResponseEntity.ok(loggedInEmp);
			
		}catch(RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);		
		}		
	}

}
