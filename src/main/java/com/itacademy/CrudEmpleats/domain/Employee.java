package com.itacademy.CrudEmpleats.domain;

public class Employee {

	/*
	 * D'un treballador identifiquem el nom i la seva feina, estaria bé tenir un
	 * identificador únic per aquest treballador.
	 * Depenent de la feina s'assignarà un
	 * salari a l'empleat un cop es crea.
	 * 
	 */
	
	private static int idCount=0;
	private int id;
	private String name;
	private String job;
	

	
	public Employee(String name, String job) {
		this.id=idCount++;
		this.name = name;
		this.job = job;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
	
}
