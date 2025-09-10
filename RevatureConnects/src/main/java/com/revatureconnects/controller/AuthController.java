package com.revatureconnects.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.revatureconnects.dto.LoginRequest;
import com.revatureconnects.dto.LoginResponse;
import com.revatureconnects.entity.Employee;
import com.revatureconnects.entity.Role;
import com.revatureconnects.repository.EmployeeRepository;
import com.revatureconnects.service.JwtService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtService jwtService;
    
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
   // logging in employee
   @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwtToken = jwtService.generateToken(userDetails.getUsername());
        
        Employee employee = employeeRepository.findByEmail(userDetails.getUsername());
        
        System.out.println("Login request received for: " + request.getEmail());
        return new LoginResponse(jwtToken, employee);
    }

   // registering new employee
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeRepository.save(employee);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Registered");
        return ResponseEntity.ok(response);
    }

    
    // Only IT_ADMIN have the access to change the role level access of an employee. 
    @PatchMapping("/update-role/{empId}")
    @PreAuthorize("hasRole('IT_ADMIN')")
    public ResponseEntity<Map<String, String>> updateRole(
            @PathVariable Long empId,
            @RequestParam Role newRole) {

        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + empId));

        employee.setRole(newRole);
        employeeRepository.save(employee);
        
        Map<String, String> response = new HashMap<>();
        response.put("message", "Employee role updated successfully.");

        return ResponseEntity.ok(response);
    }

    
   
    


}
