package com.itacademy.CrudEmpleats.persistence;

import java.util.*;

import org.springframework.stereotype.Service;

import com.itacademy.CrudEmpleats.domain.Employee;

@Service
public class EmployeeRepository {

	/*
	 * Els objectes seran persistits únicament en memòria
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

	public void updateEmployee(Employee employee, int id) {
		for(Employee e : repository) {
			if(e.getId()==id) {
				repository.set(repository.indexOf(e),employee);
			}
		}
	}

	public void deleteEmployee(int id) {
		repository.removeIf(empleat -> empleat.getId()==id);		
	}

}
