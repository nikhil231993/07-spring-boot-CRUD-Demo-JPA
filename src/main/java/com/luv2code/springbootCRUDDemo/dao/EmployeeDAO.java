package com.luv2code.springbootCRUDDemo.dao;

import java.util.List;

import com.luv2code.springbootCRUDDemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(int theid);
	
	public void save(Employee theemployee);
	
	public void deleteById(int theid);
}
