package com.revatureconnects.service;

import java.util.List;

import com.revatureconnects.entity.Curriculum;

public interface CurriculumService {
	
	Curriculum CreateCurriculumWithModules(Curriculum curriculum, List<Long> moduleIds);
	
    Curriculum assignEmployees(Long curriculumId, List<Long> employeeIds);
    
    List<Curriculum> getAssignedCurriculums(Long empId);
    
    List<Curriculum> getAllCurriculums();
    
    Curriculum getCurriculumById(Long id);
    
    void removeCurriculumFromEmployee(Long empId, Long curriculumId);

}
