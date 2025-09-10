package com.revatureconnects.service;

import java.util.List;

import com.revatureconnects.entity.Modules;

public interface ModuleService {
	
	
	Modules createModuleWithTopics(Modules module, List<Long> topicsIds);
	
	

}
