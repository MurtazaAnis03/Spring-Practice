package com.Demo4.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Demo4.hibernate.entity.Student;

class UpdateStudent {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			//get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on id
			System.out.println("Getting student with id: "+studentId);
			Student myStudent = session.get(Student.class, studentId);
			
			myStudent.setFirstName("Danny");
			
			//commit the transaction
			session.getTransaction().commit();
			
			//new code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students
			session.createQuery("update Student set email='school@email.com'").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		
		finally {
			factory.close();
		}
		
	}

}
