package com.revatureconnects.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revatureconnects.entity.Topics;
import com.revatureconnects.repository.TopicsRepo;
import com.revatureconnects.service.TopicService;

@RestController
@RequestMapping("/api/topic")
public class TopicsController {
	
	
	@Autowired
	private TopicsRepo topicsRepo; 
	
	@Autowired
	private TopicService topicsService; 
	
	@PostMapping("/createTopic")
	public ResponseEntity<Topics> createTopic(@RequestBody Topics topic){
		
		topicsRepo.save(topic);
		
		return ResponseEntity.ok(topic); 
	}
	
	@GetMapping("/getAllTopics")
	public ResponseEntity<List<Topics>> getAllTopics(){
		
		List<Topics> topics = topicsService.allTopics();
		
		return ResponseEntity.ok(topics);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTopic(@PathVariable("id") Long topicId){
        try {
            topicsService.deleteTopicById(topicId);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); 
        }
	}
	
	
}
