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

	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public String getStackName() {
		return stackName;
	}

	public void setStackName(String stackName) {
		this.stackName = stackName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
		
}
