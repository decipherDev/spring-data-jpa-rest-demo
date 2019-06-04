package com.decipherDev.hibernatedemo.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
