package com.luv2code.springbootCRUDDemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.luv2code.springbootCRUDDemo.dao.EmployeeDAO;
import com.luv2code.springbootCRUDDemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	
	public EmployeeServiceImpl() {
		
	}
	
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDaoJPAImpl")  EmployeeDAO theemployeeDAO)
	{
		employeeDAO=theemployeeDAO;
	}

	

	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theid) {
		
		return employeeDAO.findById(theid);
	}

	@Override
	@Transactional
	public void save(Employee theemployee) {
		employeeDAO.save(theemployee);

	}

	@Override
	@Transactional 
	public void deleteById(int theid) {
		employeeDAO.deleteById(theid);

	}

}
