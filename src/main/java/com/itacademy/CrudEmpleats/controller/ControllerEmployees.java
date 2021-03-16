package com.itacademy.CrudEmpleats.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.itacademy.CrudEmpleats.domain.Employee;
import com.itacademy.CrudEmpleats.persistence.EmployeeRepository;

@RestController
public class ControllerEmployees {

	/*
	 * Crearem un programa de gestió d'empleats molt senzill on depenent de la feina
	 * de l'empleat se li assignarà un salari automàticament
	 * 
	 * El domini ha de tindre el CRUD al complet (Create, Read, Update, Delete),
	 * utilitzant els verbs HTTP associats.
	 * 
	 * Crea una petició HTTP especial que busqui empleats per feina, a més de totes
	 * les que creen, llegeixen, actualitzen o esborren elements de tipus empleat
	 * 
	 * Has de tindre en compte les bones pràctiques de disseny de les API: utilitzi
	 * correctament els codis d'error i les respostes en cas d'invocacions
	 * incorrectes
	 * 
	 */

	@Autowired
	private EmployeeRepository repositori;

	
	// Temporalment redirigim a la llista d'empleats
	@GetMapping("/")
	void start(HttpServletResponse reponse) throws IOException {
		reponse.sendRedirect("/Empleat");
	}
	
	// Crear nou empleat
	@PostMapping( "/Empleat")
	public Employee addEmployee(@RequestBody Employee employee) {
		repositori.addEmployee(employee);
		return employee;
	}
	
	// Retorna una llista JSon d'empleats
	@GetMapping("/Empleat")
	public List<Employee> allEmployees() {
		return repositori.getAllEmployees();
	}

	// Busca un empleat per Id
	@GetMapping("/Empleat/{id}")
	public Employee getFirstEmployee(@PathVariable("id") int id) {
			return repositori.getEmployeeById(id);
	}

	// Actualitzar Empleat
	@PutMapping("/Empleat/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") int id) {
		repositori.updateEmployee(employee,id);
		return repositori.getEmployeeById(id);
	}

	// Eliminar Empleat
	@DeleteMapping("/Empleat/{id}")
	public String deleteEmployee( @PathVariable("id") int id) {
		repositori.deleteEmployee(id);
		if(repositori.getEmployeeById(id)==null) {
			return "Empleat eliminat correctament.";
		}
			return "L'emplat no s'ha pogut eliminar.";
	}
}
