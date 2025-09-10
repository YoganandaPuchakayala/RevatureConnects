package com.revatureconnects.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revatureconnects.entity.Curriculum;

@Repository
public interface CurriculumnRepo extends JpaRepository<Curriculum, Long>{
	
	List<Curriculum> findAll();
	
}
