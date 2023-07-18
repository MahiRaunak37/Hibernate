package com.hibernate.pegination;

/**
 * Pegination in Hibernate 
 * by:- mahi raunak
 * Date:- 22/06/2023
  		query.setFirstResult(0);	//it takes the first result

		query.setMaxResults(5);		//this is the query of takes 5 result.

 */

import org.hibernate.query.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		//creating configuration obect
		Configuration configuration = new Configuration();
		configuration.configure("com/hibernate/pegination/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		/*
		 * Student student = new Student(); student.setStudentId(1);
		 * student.setStudentName("Raunak"); student.setStudentCity("Gaya"); Transaction
		 * transaction = session.beginTransaction(); session.save(student);
		 * transaction.commit();
		 */

		// Query
		Query<Student> query = session.createQuery("from Student", Student.class);

		query.setFirstResult(5);		//starting index

		query.setMaxResults(5);			//total element after that index/

		List<Student> studentsList = query.list();		//query return the data in list of Student form.

		for (Student student : studentsList) {
			System.out.println(
					student.getStudentId() + " : " + student.getStudentName() + " : " + student.getStudentCity());
		}

		session.close();
		sessionFactory.close();
	}

}
