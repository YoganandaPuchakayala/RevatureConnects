package com.revatureconnects.service;

import java.util.List;

import com.revatureconnects.entity.Topics;

public interface TopicService {
	
	Topics createTopic(Topics topic);
	
	List<Topics> allTopics();
	
    void deleteTopicById(Long topicId);}
