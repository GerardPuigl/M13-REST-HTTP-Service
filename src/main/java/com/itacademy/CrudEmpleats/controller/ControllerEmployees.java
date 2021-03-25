package com.itacademy.CrudEmpleats.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.itacademy.CrudEmpleats.domain.Employee;
import com.itacademy.CrudEmpleats.service.EmployeeServices;

@RestController
public class ControllerEmployees {
	/*
	 * Controlador d'operacions CRUD
	 */
	
	@Autowired
	private EmployeeServices repositori;
	
	// Crear nou empleat
	@PostMapping( "/EmployeeList")
	@ResponseStatus(HttpStatus.CREATED)  // 201
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		repositori.addEmployee(employee);
		return repositori.getEmployeeById(employee.getId());

	}
	
	// Retorna una llista JSon d'empleats
	@GetMapping("/EmployeeList")
	public List<Employee> allEmployees() {
		return repositori.getAllEmployees();
	}

	// Busca un empleat per Id
	@GetMapping("/EmployeeList/{id}")
	public Employee getFirstEmployee(@PathVariable("id") int id) {
			return repositori.getEmployeeById(id);
	}

	// Actualitzar Empleat
	@PutMapping("/EmployeeList/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)  // 202
	public Employee updateEmployee(@Valid @RequestBody Employee employee, @PathVariable("id") int id) {
		repositori.updateEmployee(employee,id);
		return repositori.getEmployeeById(id);
	}

	// Eliminar Empleat
	@DeleteMapping("/EmployeeList/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)  // 202
	public String deleteEmployee(@PathVariable("id") int id) {
			repositori.deleteEmployee(id);
			return "Empleat eliminat correctament.";
	}
}
