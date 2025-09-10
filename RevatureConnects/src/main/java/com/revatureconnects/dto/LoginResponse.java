package com.revatureconnects.dto;

import com.revatureconnects.entity.Employee;

import lombok.*;

@Data
@AllArgsConstructor
public class LoginResponse {
	
	
	private String token;
	
	private Employee employee; 


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LoginResponse(String token, Employee employee) {
		super();
		this.token = token;
		this.employee = employee;
	}
	
	
	
	
	
	

}
