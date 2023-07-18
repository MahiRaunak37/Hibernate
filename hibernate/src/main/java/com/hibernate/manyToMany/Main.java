package com.hibernate.manyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("com/hibernate/manyToMany/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Employee employee1 = new Employee();
		employee1.setEmpId(1);
		employee1.setEmpName("raunak");
		
		Employee employee2 = new Employee();
		employee2.setEmpId(2);
		employee2.setEmpName("Mahi");
		
		Project project1 = new Project();
		project1.setProjectId(1);
		project1.setProjectName("FMS");
		
		Project project2 = new Project();
		project2.setProjectId(2);
		project2.setProjectName("UPASTHIT");
		
		List<Employee> listEmployees = new ArrayList<Employee>();
		listEmployees.add(employee1);
		listEmployees.add(employee2);
		
		List<Project> listProjects = new ArrayList<Project>();
		listProjects.add(project1);
		listProjects.add(project2);
		
		employee1.setProjects(listProjects);
		project2.setEmployees(listEmployees);
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(employee1);
		session.save(employee2);
		session.save(project1);
		session.save(project2);
		
		transaction.commit();  
		
		sessionFactory.close();
	}
}
