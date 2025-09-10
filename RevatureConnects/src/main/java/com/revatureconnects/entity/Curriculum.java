package com.revatureconnects.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="curriculum")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curriculum {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long curriculumId; 
	
	private String title;
	
	@ManyToMany
    @JoinTable(
            name = "employee_curriculum",
            joinColumns = @JoinColumn(name = "curriculum_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
        )	@JsonBackReference
    private List<Employee> assignedEmployees = new ArrayList<>();
	
	@OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference  
	private List<Modules> modules = new ArrayList<>();

	public Long getCurriculumId() {
		return curriculumId;
	}

	public void setCurriculumId(Long curriculumId) {
		this.curriculumId = curriculumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Employee> getAssignedEmployees() {
		return assignedEmployees;
	}

	public void setAssignedEmployees(List<Employee> assignedEmployees) {
		this.assignedEmployees = assignedEmployees;
	}

	public List<Modules> getModules() {
		return modules;
	}

	public void setModules(List<Modules> modules) {
		this.modules = modules;
	}

	
	

}
