package com.luv2code.springbootCRUDDemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springbootCRUDDemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		// get the current hibernat esession

		Session currentsession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentsession.createQuery("from Employee", Employee.class);

		List<Employee> emplyoeeList = query.getResultList();
		return emplyoeeList;

	}

	@Override
	public Employee findById(int theid) {

		Session currentsession = entityManager.unwrap(Session.class);
		Employee employee = currentsession.get(Employee.class, theid);
		return employee;
	}

	@Override
	public void save(Employee theemployee) {

		Session thecur = entityManager.unwrap(Session.class);
		thecur.saveOrUpdate(theemployee);

	}

	@Override
	public void deleteById(int theid) {

		// 526 tutorial
		Session thecur = entityManager.unwrap(Session.class);
		thecur.delete(thecur.get(Employee.class, theid));

	}

}
