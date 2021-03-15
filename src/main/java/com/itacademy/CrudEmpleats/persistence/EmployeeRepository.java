package com.itacademy.CrudEmpleats.persistence;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.itacademy.CrudEmpleats.domain.Employee;

@Service
public class EmployeeRepository {

	/*
	 * Els objectes seran persistidos únicament en memòria
	 * 
	 */

	private ArrayList<Employee> repository = new ArrayList<>(
			Arrays.asList(
					new Employee("Juan", "Director de Projectes"),
					new Employee("Gerard", "Programador"),
					new Employee("Maria", "Administrativa")
					)
			);

}
