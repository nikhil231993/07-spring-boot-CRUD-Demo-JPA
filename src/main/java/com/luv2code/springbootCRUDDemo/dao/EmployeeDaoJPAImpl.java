package com.luv2code.springbootCRUDDemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springbootCRUDDemo.entity.Employee;

@Repository
public class EmployeeDaoJPAImpl implements EmployeeDAO {

	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoJPAImpl(EntityManager theentityManager) {
		entityManager=theentityManager;
	}

	@Override
	public List<Employee> findAll() {
		Query thequery=entityManager.createQuery("from Employee", Employee.class);
		List<Employee> emplist=thequery.getResultList();
		return emplist;
		
	}

	@Override
	public Employee findById(int theid) {
		Employee emp=entityManager.find(Employee.class, theid);
		return emp;
	}

	@Override
	public void save(Employee theemployee) {

		Employee dbemployee=entityManager.merge(theemployee);
		theemployee.setId(dbemployee.getId());

	}

	@Override
	public void deleteById(int theid) {
		/*Query thequery=entityManager.createQuery("delete from Employee where id=:employeeid");
		thequery.setParameter("paramterid", "theid");
		thequery.executeUpdate();
		*/
		entityManager.remove(entityManager.find(Employee.class, theid));

	}

}
