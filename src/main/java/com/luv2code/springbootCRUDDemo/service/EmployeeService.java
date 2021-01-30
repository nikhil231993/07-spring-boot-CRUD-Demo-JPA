package com.luv2code.springbootCRUDDemo.service;

import java.util.List;

import com.luv2code.springbootCRUDDemo.entity.Employee;

public interface EmployeeService {
	
public List<Employee> findAll();
	
	public Employee findById(int theid);
	
	public void save(Employee theemployee);
	
	public void deleteById(int theid);

}
