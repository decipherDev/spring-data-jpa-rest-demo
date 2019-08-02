package com.decipherDev.hibernatedemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.decipherDev.hibernatedemo.entities.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	public List<Employee> findByName(String name);
	
	@Query(nativeQuery = true, value = "select count(*) from employee")
	public int getNoOfRowCount();
	
}
