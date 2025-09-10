package com.revatureconnects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revatureconnects.entity.Modules;

@Repository
public interface ModuleRepo extends JpaRepository<Modules, Long> {

}
