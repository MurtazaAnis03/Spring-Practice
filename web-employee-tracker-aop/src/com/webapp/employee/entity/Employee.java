package com.webapp.employee.entity;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;

	
	public Employee() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public static Comparator<Employee> idComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {
			int emp1 =  e1.getId();
			int emp2 = e2.getId();
			
			return 	Integer.compare(emp1, emp2);
		}
	};
	
	public static Comparator<Employee> firstNameComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {
			String emp1 =  e1.getFirstName().toLowerCase();
			String emp2 = e2.getFirstName().toLowerCase();
			
			return 	emp1.compareTo(emp2);
		}
			
	};
	
	public static Comparator<Employee> lastNameComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {
			String emp1 =  e1.getLastName().toLowerCase();
			String emp2 = e2.getLastName().toLowerCase();
			
			return 	emp1.compareTo(emp2);
		}
			
	};
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	
}
