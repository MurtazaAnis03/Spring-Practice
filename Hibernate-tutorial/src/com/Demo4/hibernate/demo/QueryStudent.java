package com.Demo4.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Demo4.hibernate.entity.Student;

class QueryStudent {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//query all students
			List<Student> students = session.createQuery("from Student").getResultList();
			
			//display all students
			System.out.println("all students");
			displayStudents(students);
			
			//query students: lastName = 'Bond'
			students = session.createQuery("from Student s where s.lastName = 'Bond'").getResultList();
			
			//display students: lastName = 'Bond'
			System.out.println("lastName = 'Bond'");
			displayStudents(students);
			
			//query students: lastName = 'Kol' OR firstName='Dan'
			students = session.createQuery("from Student s where s.lastName = 'Kol' OR s.firstName='Dan'").getResultList();
			
			//display students: lastName = 'Bond'
			System.out.println("lastName = 'Kol' OR firstName='Dan'");
			displayStudents(students);
			
			//query students: email LIKE = 'email.com'
			students = session.createQuery("from Student s where s.email LIKE '%email.com'").getResultList();
			
			//display students: email LIKE = 'email.com'
			System.out.println("email LIKE = 'email.com'");
			displayStudents(students);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		
		finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> students) {
		for(Student temp : students) {
			System.out.println(temp);
		}
	}

}
