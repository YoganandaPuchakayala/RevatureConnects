package com.revatureconnects.dto;

import java.util.List;

import com.revatureconnects.entity.Curriculum;

public class CurriculumRequest {
	
	private String title; 
	private Curriculum curriculum;
    private List<Long> moduleIds;
    
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Curriculum getCurriculum() {
		return curriculum;
	}
	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}
	public List<Long> getModuleIds() {
		return moduleIds;
	}
	public void setModuleIds(List<Long> moduleIds) {
		this.moduleIds = moduleIds;
	}
    
    

}
