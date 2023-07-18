package com.hibernate.state;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author raunak
 * Topic:- state in the hibernate
 */

public class Main {
	public static void main(String[] args) {
		//SessionFactory sessionFactory = new Configuration().configure("com/hibernate/state/hibernate.cfg.xml").buildSessionFactory();
		Configuration configuration = new Configuration();
		configuration.configure("com/hibernate/state/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//States
		Student student = new Student();
		student.setStudentId(1);
		student.setStudentName("Raunak");
		student.setStudentCity("Gaya");
		
		Certificates certificates = new Certificates(1, "Java", 2);
		student.setCertificates(certificates);
		//upto here state is in Transient State
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);		//student comes into the Persistent state, database
		
		session.save(certificates);
		transaction.commit();
		sessionFactory.close();
	}
}
