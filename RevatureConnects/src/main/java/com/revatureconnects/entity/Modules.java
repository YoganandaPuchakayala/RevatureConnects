package com.revatureconnects.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="modules")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Modules {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long moduleId;
	
	private String title;
	
	private String contentURL;
	
	@OneToMany(mappedBy = "module", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Topics> topics = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="curriculumId")
	@JsonBackReference  
	private Curriculum curriculum;

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContentURL() {
		return contentURL;
	}

	public void setContentURL(String contentURL) {
		this.contentURL = contentURL;
	}

	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

	public List<Topics> getTopics() {
		return topics;
	}

	public void setTopics(List<Topics> topics) {
		this.topics = topics;
	}


	
}
