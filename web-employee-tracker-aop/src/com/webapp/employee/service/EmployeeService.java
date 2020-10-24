package com.webapp.employee.service;

import java.util.List;

import com.webapp.employee.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();

	public void saveEmployee(Employee theEmployee);

	public Employee getEmployee(int id);

	public void deleteEmployee(int id);
	
}