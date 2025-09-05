package com.revatureconnects.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;
    
    private String empName;
    
    private String email;
    
    private String password;
    
    private String department;
    
    private String empDesignation;
    
    @Enumerated(EnumType.STRING)
    private Role role; 
    
    @OneToMany(mappedBy = "curriculumId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Curriculum> assignedCurriculums;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Curriculum> getAssignedCurriculums() {
		return assignedCurriculums;
	}

	public void setAssignedCurriculums(List<Curriculum> assignedCurriculums) {
		this.assignedCurriculums = assignedCurriculums;
	}
    
    


}
