package com.itacademy.CrudEmpleats.persistence;

import java.util.*;

import org.springframework.stereotype.Service;

import com.itacademy.CrudEmpleats.domain.Employee;

@Service
public class EmployeeRepository {

	/*
	 * Els objectes seran persistidos únicament en memòria
	 * 
	 */

	private List<Employee> repository = new ArrayList<>(
			Arrays.asList(
					new Employee("Joan", "Director de Projectes"),
					new Employee("Gerard", "Programador"),
					new Employee("Maria", "Administrativa")
					)
			);
	
	public List<Employee> getAllEmployees() {
		return repository;
	}
	
	public Employee getEmployeeById(int id) throws NoSuchElementException{
		return repository.stream().filter(employee -> employee.getId()==id).findFirst().get();
	}

	public void addEmployee(Employee employee) {
		repository.add(employee);
		
	}

}
