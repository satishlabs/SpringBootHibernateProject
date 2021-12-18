package com.satishlabs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.satishlabs.model.Employee;

@Repository
public class EmployeeDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void createEmployee(Employee employee) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Integer id = (Integer) session.save(employee);
			System.out.println("Employee is created with id : "+id);
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
