package com.Demo4.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Demo4.hibernate.entity.Student;

class CreateStudent {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create a student object
			Student tempStudent1 = new Student("Dan", "Brown", "dan@email.com");
			Student tempStudent2 = new Student("John", "Green", "john@email.com");
			Student tempStudent3 = new Student("Ruskin", "Bond", "bond@email.com");
			Student tempStudent4 = new Student("James", "Bond", "bond@email.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			session.save(tempStudent4);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		
		finally {
			factory.close();
		}
		
	}

}
