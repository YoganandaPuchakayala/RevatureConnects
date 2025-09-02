package com.revatureconnects.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="skills")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long skillId;
	
	private String stackName;
	
	private String description;
		
}
