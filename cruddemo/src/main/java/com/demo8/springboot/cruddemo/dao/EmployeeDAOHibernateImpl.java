package com.demo8.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo8.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	//define field for entitymanager
	private EntityManager entityManager;
	
	//setup constuctor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Employee theEmployee = session.get(Employee.class, theId);
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(theEmployee);
	}

	@Override
	public void deleteById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query query = session.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
		
	}
	
}