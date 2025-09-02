package com.revatureconnects.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="modules")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long moduleId;
	
	private String title;
	
	private String contentURL;
	
	@ManyToOne
	@JoinColumn(name="curriculumId")
	private Curriculum curriculum;
	

}
