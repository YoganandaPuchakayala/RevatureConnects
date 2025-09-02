package com.revatureconnects.entity;

import java.util.List;

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
	
	@ManyToOne
	@JoinColumn(name="skillId")
	private Skill skill; 
	
	@ManyToOne
	@JoinColumn(name="empId")
	private Employee assignedby;
	
	@OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Module> modules;


}
