package com.itacademy.CrudEmpleats.controller;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.itacademy.CrudEmpleats.exceptions.IdNotFound;

@RestControllerAdvice
public class ControllerExceptions {

	//Excepció si no s'indrodueix un integer al id de la petició.	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.PRECONDITION_FAILED)  // 412
	public String misMatchException(MethodArgumentTypeMismatchException e) {
		return "<h2>Error!</h2>"
				+ "El paràmetre <strong>" + e.getName()+" = " + e.getValue() + "</strong>"
				+ " ha de ser del tipus <strong>"+ e.getRequiredType() + "</strong>.";
	}

	//Excepció is no es troba l'element demanat.
	@ExceptionHandler(IdNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)  // 404
	public String noSuchElementException(IdNotFound e) {
		return "<h2>Error!</h2>"
				+ "No s'ha trobat cap empleat amb el ID: " + e.getId();
	}

		
	//Filtre per errors no controlats amb informació per millorar l'aplicació.
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.CONFLICT)  // 409
	public String exceptionHandeler(Exception e) {
		return "<h2>Error!</h2>"
				+ "Tipo: " + e.getClass() + "<br>"
				+ "Mensaje Error: " + e.getMessage();
	}
}
