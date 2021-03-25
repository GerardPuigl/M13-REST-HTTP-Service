package com.itacademy.CrudEmpleats.persistence;

import java.util.List;

import com.itacademy.CrudEmpleats.domain.Employee;


public interface IEmployeeRepository {
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int id);

	public void addEmployee(Employee employee);

	public void updateEmployee(Employee employee, int id);

	public void deleteEmployee(int id);

}
