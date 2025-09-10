package com.revatureconnects.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revatureconnects.entity.Topics;

@Repository
public interface TopicsRepo extends JpaRepository<Topics, Long> {
	
	List<Topics> findAll();
}
