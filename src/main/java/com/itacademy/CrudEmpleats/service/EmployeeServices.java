package com.itacademy.CrudEmpleats.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.CrudEmpleats.domain.Employee;
import com.itacademy.CrudEmpleats.persistence.EmployeeRepository;

@Service
public class EmployeeServices {

	@Autowired
	private EmployeeRepository repositori;
	
	public List<Employee> getAllEmployees() {
		return repositori.getAllEmployees();
	}
	
	public Employee getEmployeeById(int id){
		return repositori.getEmployeeById(id);
	}

	public void addEmployee(Employee employee) {
		repositori.addEmployee(employee);
	}

	public void updateEmployee(Employee employee, int id) {
		repositori.updateEmployee(employee, id);
	}

	public void deleteEmployee(int id) {
		repositori.deleteEmployee(id);
	}

}
