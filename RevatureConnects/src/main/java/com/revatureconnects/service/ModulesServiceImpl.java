package com.revatureconnects.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revatureconnects.entity.Modules;
import com.revatureconnects.entity.Topics;
import com.revatureconnects.repository.ModuleRepo;
import com.revatureconnects.repository.TopicsRepo;

@Service
public class ModulesServiceImpl implements ModuleService{
	
	
	@Autowired
	private ModuleRepo modulesRepo;
	
	@Autowired
	private TopicsRepo topicsRepo; 

	@Override
	public Modules createModuleWithTopics(Modules module, List<Long> topicsIds) {
		List<Topics> topics = topicsRepo.findAllById(topicsIds);
		for(Topics topic : topics) {
			topic.setModule(module);
		}
		module.setTopics(topics);
		return modulesRepo.save(module);
	}

}
