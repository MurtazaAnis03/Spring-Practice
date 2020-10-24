package com.webapp.employee.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.employee.entity.Employee;
import com.webapp.employee.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	//need to inject EmployeeService
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		//get employees from Service
		List<Employee> theEmployees = employeeService.getEmployees();
		
		//add the employees to the model
		model.addAttribute("employees", theEmployees);

		return "list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		//create model attribute to bind form data
		Employee theEmployee = new Employee();
		model.addAttribute("employee", theEmployee);
		
		return "employee-form";
	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		//save employee using our service
		employeeService.saveEmployee(theEmployee);
		
		return "redirect:/employee/list";
	}
	
	@GetMapping("/showFormForEdit")
	public String showFormForEdit(@RequestParam("employeeId") int id, Model model) {
		
		//get employee from our service
		Employee theEmployee = employeeService.getEmployee(id);
		
		//set employee as a model attribute to pre-populate the form
		model.addAttribute(theEmployee);
		
		//send over to the form
		return "employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int id) {
	
		//delete the employee
		employeeService.deleteEmployee(id);
		return "redirect:/employee/list";
	}
	
	@GetMapping("/orderById")
	public String orderById(Model model) {
		
		List<Employee> theEmployee = employeeService.getEmployees();
		Collections.sort(theEmployee, Employee.idComparator);
		model.addAttribute("employees", theEmployee);
		return "list-employee";
		
	}
	
	@GetMapping("/orderByFirstName")
	public String orderByFirstName(Model model) {
		
		List<Employee> theEmployee = employeeService.getEmployees();
		Collections.sort(theEmployee, Employee.firstNameComparator);
		model.addAttribute("employees", theEmployee);
		return "list-employee";
		
	}
	
	@GetMapping("/orderByLastName")
	public String orderByLastName(Model model) {
		
		List<Employee> theEmployee = employeeService.getEmployees();
		Collections.sort(theEmployee, Employee.lastNameComparator);
		model.addAttribute("employees", theEmployee);
		return "list-employee";
		
	}
	
}