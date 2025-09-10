package com.revatureconnects.entity;


import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="employeeModuleProgress")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModuleProgress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empProgressId; 
	
	@ManyToOne
	@JoinColumn(name="empId")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="moduleId")
	private Modules module; 
	
	@Enumerated(EnumType.STRING)
	private ProgressStatus status; 
	
	private LocalDate completedAt;

	public Long getEmpProgressId() {
		return empProgressId;
	}

	public void setEmpProgressId(Long empProgressId) {
		this.empProgressId = empProgressId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Modules getModule() {
		return module;
	}

	public void setModule(Modules module) {
		this.module = module;
	}

	public ProgressStatus getStatus() {
		return status;
	}

	public void setStatus(ProgressStatus status) {
		this.status = status;
	}

	public LocalDate getCompletedAt() {
		return completedAt;
	}

	public void setCompletedAt(LocalDate completedAt) {
		this.completedAt = completedAt;
	}
	
	

}
