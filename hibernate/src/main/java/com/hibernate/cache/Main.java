package com.hibernate.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("com/hibernate/cache/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		
		Student student = session.get(Student.class,1001);
		System.out.println(student);
		
		
		Student student1 = session.get(Student.class,1001);
		System.out.println(student1);
		
		System.out.println(session.contains(student1));
		
		
		
		session.close();
		sessionFactory.close();
	}
}
