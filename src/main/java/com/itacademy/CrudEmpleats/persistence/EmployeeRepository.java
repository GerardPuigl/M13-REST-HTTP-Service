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
					new Employee("Juan", "Director de Projectes"),
					new Employee("Gerard", "Programador"),
					new Employee("Maria", "Administrativa")
					)
			);
	public List<Employee> getAllEmployees() {
		return repository;
	}

}
