package com.revatureconnects.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revatureconnects.dto.ModuleRequest;
import com.revatureconnects.entity.Modules;
import com.revatureconnects.service.ModuleService;

@RestController
@RequestMapping("/api/modules")
public class ModulesController {
	
	
    @Autowired
    private ModuleService moduleService;
    
    
    @PostMapping("/createModule")
    public Modules createModule(@RequestBody ModuleRequest request) {
        return moduleService.createModuleWithTopics(request.getModule(), request.getTopicIds());
    }
    
    

}
