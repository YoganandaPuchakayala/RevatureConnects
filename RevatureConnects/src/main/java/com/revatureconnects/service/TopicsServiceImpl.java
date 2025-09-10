package com.revatureconnects.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revatureconnects.entity.Topics;
import com.revatureconnects.repository.TopicsRepo;

@Service
public class TopicsServiceImpl implements TopicService {
	
	@Autowired
	private TopicsRepo topicsRepo;

	@Override
	public Topics createTopic(Topics topic) {
		
		Topics savedTopic = topicsRepo.save(topic);
		
		return savedTopic;
	}

	@Override
	public List<Topics> allTopics() {
		
		return topicsRepo.findAll();
	}

	@Override
	public void deleteTopicById(Long topicId) {
		
		topicsRepo.deleteById(topicId);
	}

}
