package com.satishlabs;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.satishlabs.dao.EmployeeDao;
import com.satishlabs.model.Employee;

@SpringBootApplication
public class SpringBootHibernateProjectApplication implements CommandLineRunner{
	@Autowired
	private EmployeeDao employeeDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateProjectApplication.class, args);
	}
	


	@Override
	public void run(String... args) throws Exception {
		Employee emp = getEmployee();
		employeeDao.createEmployee(emp);
		
	}



	private Employee getEmployee() {
		Employee emp = new Employee();
		emp.setName("Satish Prasad");
		emp.setDoj(new Date());
		emp.setSalary(150000.00);
		return emp;
	}

}
