package com.webapp.employee.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.employee.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Employee> getEmployees() {
		
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		
		//execute query and get result list
		List<Employee> employees = query.getResultList();
		
		//return the results
		return employees;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		
		//get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//save the employee
		session.saveOrUpdate(theEmployee);
		
	}

	@Override
	public Employee getEmployee(int id) {
		
		//get current hibernate session
		Session session = sessionFactory.getCurrentSession();
				
		//retrieve from database using id
		Employee theEmployee = session.get(Employee.class, id);
		return theEmployee;
	}

	@Override
	public void deleteEmployee(int id) {
		
		//get current hibernate session
		Session session = sessionFactory.getCurrentSession();
				
		//delete object from database using id
		Query query = session.createQuery("delete from Employee where id=employeeId");
		
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
		
	}

}