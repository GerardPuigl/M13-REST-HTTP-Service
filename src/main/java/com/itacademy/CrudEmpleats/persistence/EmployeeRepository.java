package com.itacademy.CrudEmpleats.persistence;

import java.util.*;

import org.springframework.stereotype.Service;

import com.itacademy.CrudEmpleats.domain.Employee;
import com.itacademy.CrudEmpleats.exceptions.IdNotFound;

@Service
public class EmployeeRepository implements IEmployeeRepository{

	// Els objectes persistents únicament en memòria

	private static int idcount=0;

	private List<Employee> repository = new ArrayList<>(
			Arrays.asList(
					new Employee(idcount++,"Joan", "Director_Projectes"),
					new Employee(idcount++,"Gerard", "Programador_Junior"),
					new Employee(idcount++,"Maria", "Administratiu")
					)
			);
	
	
	public List<Employee> getAllEmployees() {
		return repository;
	}
	
	public Employee getEmployeeById(int id){
		try {
			return repository.stream().filter(employee -> employee.getId()==id).findFirst().get();
		} catch (Exception e) {
			throw new IdNotFound(id);
		}
	}

	public void addEmployee(Employee employee) {
		employee.setId(idcount++);
		repository.add(employee);
	}

	public void updateEmployee(Employee employee, int id) {
		Employee existingEmployee = getEmployeeById(id);
		employee.setId(id); //garantitzar que el nou objecte tingui el mateix id que l'antic.
		repository.set(repository.indexOf(existingEmployee),employee);
	}

	public void deleteEmployee(int id) {
		repository.remove(getEmployeeById(id));
	}

}
