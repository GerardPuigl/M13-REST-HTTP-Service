package com.itacademy.CrudEmpleats.domain;

public class Employee {

	private int id;
	private String name;
	private String job;
	private double salary ;
	
	//salari i cárreg en funció de la calsse Jobs Enum.
	public Employee(int id,String name, String job) {
		this.id=id;
		this.name = name;
		this.job = Jobs.valueOf(job).getName();
		this.salary = Jobs.valueOf(job).getSalary();
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
		this.job = Jobs.valueOf(job).getName();
		this.salary = Jobs.valueOf(job).getSalary();
	}

	public double getSalary() {
		return salary;
	}

}
