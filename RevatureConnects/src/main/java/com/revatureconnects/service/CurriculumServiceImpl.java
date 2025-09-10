package com.revatureconnects.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revatureconnects.entity.Curriculum;
import com.revatureconnects.entity.Employee;
import com.revatureconnects.entity.Modules;
import com.revatureconnects.exceptions.ResourceNotFoundException;
import com.revatureconnects.repository.CurriculumnRepo;
import com.revatureconnects.repository.EmployeeRepository;
import com.revatureconnects.repository.ModuleRepo;

@Service 
public class CurriculumServiceImpl implements CurriculumService{
	
	@Autowired
	private ModuleRepo modulesRepo;
	
	@Autowired
	private CurriculumnRepo curriculumRepo; 
	
	@Autowired
	private EmployeeRepository employeeRepo; 

	@Override
	public Curriculum CreateCurriculumWithModules(Curriculum curriculum, List<Long> moduleIds) {
        List<Modules> modules = modulesRepo.findAllById(moduleIds);
        for (Modules module : modules) {
            module.setCurriculum(curriculum);
        }
        curriculum.setModules(modules);
        return curriculumRepo.save(curriculum);
	}

    @Override
    public Curriculum assignEmployees(Long curriculumId, List<Long> employeeIds) {
        Curriculum curriculum = curriculumRepo.findById(curriculumId)
                .orElseThrow(() -> new RuntimeException("Curriculum not found"));

        List<Employee> employees = employeeRepo.findAllById(employeeIds);

        curriculum.getAssignedEmployees().addAll(employees);

        return curriculumRepo.save(curriculum);
    }
    
    @Override
    public List<Curriculum> getAssignedCurriculums(Long empId) {
        Employee employee = employeeRepo.findById(empId)
            .orElseThrow(() -> new RuntimeException("Employee not found"));

        return employee.getAssignedCurriculums();
    }

	@Override
	public List<Curriculum> getAllCurriculums() {
		
		return curriculumRepo.findAll();
	}

    @Override
    public Curriculum getCurriculumById(Long id) {
        return curriculumRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Curriculum not found"));
    }

    @Override
    public void removeCurriculumFromEmployee(Long empId, Long curriculumId) {
        Employee employee = employeeRepo.findById(empId)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        Curriculum curriculum = curriculumRepo.findById(curriculumId)
            .orElseThrow(() -> new ResourceNotFoundException("Curriculum not found"));

        employee.getAssignedCurriculums().remove(curriculum);
        curriculum.getAssignedEmployees().remove(employee);

        employeeRepo.save(employee);
        curriculumRepo.save(curriculum);
    }

}
