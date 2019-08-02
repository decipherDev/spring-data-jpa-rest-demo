package com.decipherDev.hibernatedemo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.decipherDev.hibernatedemo.entities.Project;
	
public interface ProjectRepository extends CrudRepository<Project, Integer>{

}
