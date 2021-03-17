package com.itacademy.CrudEmpleats.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.itacademy.CrudEmpleats.domain.Employee;
import com.itacademy.CrudEmpleats.persistence.EmployeeRepository;

@RestController
public class ControllerEmployees {
	/*
	 * Controlador d'operacions CRUD
	 */
	
	@Autowired
	private EmployeeRepository repositori;

	/*
	// Temporalment redirigim a la llista d'empleats
	@GetMapping("/")
	void start(HttpServletResponse reponse) throws IOException {
		reponse.sendRedirect("/Empleat");
	}*/
	
	// Crear nou empleat
	@PostMapping( "/EmpleatList")
	@ResponseStatus(HttpStatus.CREATED)  // 201
	public Employee addEmployee(@RequestBody Employee employee) {
		repositori.addEmployee(employee);
		return employee;
	}
	
	// Retorna una llista JSon d'empleats
	@GetMapping("/EmpleatList")
	public List<Employee> allEmployees() {
		return repositori.getAllEmployees();
	}

	// Busca un empleat per Id
	@GetMapping("/EmpleatList/{id}")
	public Employee getFirstEmployee(@PathVariable("id") int id) {
			return repositori.getEmployeeById(id);
	}

	// Actualitzar Empleat
	@PutMapping("/EmpleatList/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)  // 202
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") int id) {
		repositori.updateEmployee(employee,id);
		return repositori.getEmployeeById(id);
	}

	// Eliminar Empleat
	@DeleteMapping("/EmpleatList/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)  // 202
	public String deleteEmployee(@PathVariable("id") int id) {
			repositori.deleteEmployee(id);
			return "Empleat eliminat correctament.";
	}
}
