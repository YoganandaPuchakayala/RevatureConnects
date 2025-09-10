package com.revatureconnects.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.revatureconnects.dto.CurriculumRequest;
import com.revatureconnects.entity.Curriculum;
import com.revatureconnects.service.CurriculumService;

@RestController
@RequestMapping("/api/curriculum")
public class CurriculumController {
	
	
    @Autowired
    private CurriculumService curriculumService;
    
    // creating the curriculums
    @PostMapping("/create")
    @PreAuthorize("hasRole('TRAINER')")
    public Curriculum createCurriculum(@RequestBody CurriculumRequest request) {
        return curriculumService.CreateCurriculumWithModules(request.getCurriculum(), request.getModuleIds());
    }
    
    // assign curriculums to the employees
    @PostMapping(value = "/{curriculumId}/assign-employees", consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasRole('MANAGER')")
    public Curriculum assignEmployeesToCurriculum(
            @PathVariable Long curriculumId,
            @RequestBody List<Long> employeeIds) {
        return curriculumService.assignEmployees(curriculumId, employeeIds);
    }
    
    // get curriculums assigned to curriculums 
    @GetMapping("/{empId}/curriculums")
    public List<Curriculum> getAssignedCurriculums(@PathVariable Long empId) {
        return curriculumService.getAssignedCurriculums(empId);
    }
    
    // get all curriculums 
    @GetMapping("/allCurriculums")
    public List<Curriculum> getAllCurriculums(){
    	return curriculumService.getAllCurriculums();
    }
    
    // get curriculum by curriculum id 
    @GetMapping("/{id}")
    public Curriculum getCurriculumById(@PathVariable Long id) {
        return curriculumService.getCurriculumById(id);
    }
    
    // To delete the assigned curriculum to employee
    @DeleteMapping("/{empId}/remove-curriculum/{curriculumId}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<String> removeAssignedCurriculum(
            @PathVariable Long empId,
            @PathVariable Long curriculumId) {
        curriculumService.removeCurriculumFromEmployee(empId, curriculumId);
        return ResponseEntity.ok("Curriculum removed from employee successfully.");
    }




}
