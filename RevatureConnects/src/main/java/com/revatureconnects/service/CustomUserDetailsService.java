package com.revatureconnects.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;

import org.springframework.stereotype.Service;

import com.revatureconnects.entity.Employee;
import com.revatureconnects.repository.EmployeeRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	Employee employee = employeeRepository.findByEmail(email);
    	if (employee == null) {
    	    throw new UsernameNotFoundException("User not found with email: " + email);
    	}

        return new User(
            employee.getEmail(),
            employee.getPassword(),
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + employee.getRole()))
        );
    }
}
