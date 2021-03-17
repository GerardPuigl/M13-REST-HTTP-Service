package com.itacademy.CrudEmpleats.exceptions;

public class IdNotFound extends RuntimeException {

	private int id;
	
	public IdNotFound(int id) {
		this.id=id;
	}

	public int getId() {
		return id;
	}
}
