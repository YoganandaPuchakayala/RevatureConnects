package com.revatureconnects.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revatureconnects.entity.Employee;
import com.revatureconnects.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	
    @Autowired
    private EmployeeService employeeService;
	
    @GetMapping("/all-employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

}
