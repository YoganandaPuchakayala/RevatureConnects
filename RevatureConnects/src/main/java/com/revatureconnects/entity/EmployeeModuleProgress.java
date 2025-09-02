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
	private Module module; 
	
	@Enumerated(EnumType.STRING)
	private ProgressStatus status; 
	
	private LocalDate completedAt;

}
