package com.webapp.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.employee.dao.EmployeeDAO;
import com.webapp.employee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	//need to inject EmployeeDAO
	@Autowired
	private EmployeeDAO  employeeDAO;
	
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		// 
		return employeeDAO.getEmployees();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {
		
		employeeDAO.saveEmployee(theEmployee);
	}

	@Override
	@Transactional
	public Employee getEmployee(int id) {
		
		return employeeDAO.getEmployee(id);
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		
		employeeDAO.deleteEmployee(id);
		
	}

}
