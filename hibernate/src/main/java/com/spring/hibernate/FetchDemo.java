package com.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//load the Student
		Student student = (Student) session.load(Student.class, 1001);
		Student student1 = (Student) session.load(Student.class, 1001);
		System.out.println(student.getName());
		
		Address address = (Address)session.get(Address.class, 2);
		System.out.println(address.getStreet()+" "+address.getCity());
		
		Address address2 = (Address)session.get(Address.class,2);
		System.out.println(address2.getStreet()+" : "+address2.getCity());
	 	
	
		
		
	}
}
