package com.hibernate.secondCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("com/hibernate/secondCache/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session1 = sessionFactory.openSession();
		Student student1 = session1.get(Student.class,1002);
		System.out.println(student1);
		session1.close();
		
		Session session2 = sessionFactory.openSession();
		Student student2 = session2.get(Student.class,1002);
		System.out.println(student2);
		session2.close();
		
		sessionFactory.close();
	}
}
