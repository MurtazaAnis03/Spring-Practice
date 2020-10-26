package com.demo8.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo8.springboot.cruddemo.dao.EmployeeRepository;
import com.demo8.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImplWithSpringDataJpa implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImplWithSpringDataJpa(@Qualifier("employeeDAOJpaImpl") EmployeeRepository theEmployeeRepository) {
		
		employeeRepository = theEmployeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if(result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			throw new RuntimeException("Did'nt find employee id: " + theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		
		employeeRepository.deleteById(theId);
	}

}