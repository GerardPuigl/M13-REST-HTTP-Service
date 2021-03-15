package com.itacademy.CrudEmpleats.controller;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	
	//Temporalment redirigim a la llista d'empleats	
	@GetMapping("/")
	void start(HttpServletResponse reponse) throws IOException {
		reponse.sendRedirect("/Empleat");
	}

	// Retorna una llista JSon d'empleats
	@GetMapping("/Empleat")
	public List<Employee> allEmployees() {
		return repositori.getAllEmployees();
	}

	// Busca un empleat per Id
	@GetMapping("/Empleat/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {
		try {
			return repositori.getEmployeeById(id);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No s'ha trobat cap empleat amb el id =" + id);
		}

	}
	
}
