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
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public final class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
	
	@Column(name="emp_name")
	private String name;
	
	private float salary;
	
	@AttributeOverride(name="flatNo", column = @Column(name="hno"))
	private Address address;
	
	@OneToMany
	@JoinColumn(name="project_identifier")
	private List<Project> project;
		
	@Embeddable
	@Setter
	@Getter
	public class Address {
		String flatNo;
		String street;
		String landmark;
		String city;
		String state;
		String country;
	}
}
