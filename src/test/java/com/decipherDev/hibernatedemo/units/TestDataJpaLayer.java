package com.decipherDev.hibernatedemo.units;

import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.decipherDev.hibernatedemo.entities.Employee;
import com.decipherDev.hibernatedemo.entities.Employee.Address;
import com.decipherDev.hibernatedemo.entities.Project;
import com.decipherDev.hibernatedemo.repositories.EmployeeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestDataJpaLayer {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private EmployeeRepository repository;
	
	@Test
	public void addEmployee_returnsEmployee() {
		Employee emp = new Employee();
		emp.setName("Max");
		emp.setSalary(1000F);
		
		Address addr = emp.new Address();
		addr.setCity("pune");
		addr.setCountry("India");
		addr.setFlatNo("Flat No 1");
		addr.setLandmark("Pune");
		addr.setState("Maharastra");
		addr.setStreet("9/10 clover lane");
		
		Project project = new Project();
		project.setName("MasterCard");
		project.setEmployee(Collections.singletonList(emp));
		
		emp.setProject(Collections.singletonList(project));
		
		
		entityManager.persist(project);
		
		Employee persistedEmployee = entityManager.persistFlushFind(emp);
		//entityManager.persistFlushFind(project);
		
		List<Employee> empFound = repository.findByName("Max");
		int count = repository.getNoOfRowCount();
		
		Assertions.assertThat(empFound.get(0).getName()).isEqualTo(persistedEmployee.getName());
		Assertions.assertThat(count).isEqualTo(1);
	}
	
	
}
