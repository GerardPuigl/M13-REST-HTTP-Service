package com.itacademy.CrudEmpleats.domain;

public enum Jobs {

	//Enum que defineix nom del carreg i sou.
	
	Director_Projectes("Director de projectes",50000),
	Programador_Senior("Programador Senior",35000),
	Programador_Mid("Programador Mid-Level",29000), 
	Programador_Junior("Programador Junior",21000), 
	Administratiu("Administratiu",25000);
	
	private String name;
	private double salary;
	
	private Jobs(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	double getSalary() {
		
		return salary;
	}
	
}
