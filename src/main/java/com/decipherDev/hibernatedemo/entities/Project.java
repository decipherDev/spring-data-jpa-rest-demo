package com.decipherDev.hibernatedemo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.decipherDev.hibernatedemo.entities.Employee.Address;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@ManyToMany
	private List<Employee> employee;

}
