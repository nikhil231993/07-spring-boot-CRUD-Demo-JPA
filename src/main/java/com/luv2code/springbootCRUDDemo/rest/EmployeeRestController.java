package com.luv2code.springbootCRUDDemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springbootCRUDDemo.dao.EmployeeDAO;
import com.luv2code.springbootCRUDDemo.entity.Employee;
import com.luv2code.springbootCRUDDemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService theemployeeService) {
		employeeService = theemployeeService;
	}

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{employeeid}")
	public Employee getEmployeeById(@PathVariable int employeeid) {

		Employee emp = employeeService.findById(employeeid);
		if (emp == null)
			throw new RuntimeException("Employee not found");
		return emp;
	}

	// to add employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.save(theEmployee);
		return theEmployee;
	}

	//adding mapping for employees
	@DeleteMapping("/employees/{id}")
	public Employee  deleteEmployee(@PathVariable int id)
	{
		Employee emp=employeeService.findById(id);
		if(emp == null)
			throw new RuntimeException("not found");
		
		employeeService.deleteById(id);	
		
		return emp;
	}
}
