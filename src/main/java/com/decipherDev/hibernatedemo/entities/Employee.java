package com.decipherDev.hibernatedemo.entities;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="emp_name")
	private String name;
	
	private float salary;
	
	@AttributeOverride(name="flatNo", column = @Column(name="hno"))
	private Address address;
	
	@OneToOne
	@JoinColumn(name="project_identifier")
	private Project project;
		
	@Embeddable
	class Address {
		String flatNo;
		String street;
		String landmark;
		String city;
		String state;
		String country;
	}
}
