package com.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {
	public static void main(String[] args) {
		  System.out.println( "Session Factory");
	        Configuration configuration = new Configuration();
	        configuration.configure("hibernate.cfg.xml");
	        SessionFactory sessionFactory = configuration.buildSessionFactory();
	        
	        Student student = new Student();
	        student.setId(1238);
	        student.setName("ashish");
	        student.setCity("Goa");
	        
	        Student student2 = new Student();
	        student2.setId(1234);
	        student2.setName("mshiiii");
	        student2.setCity("Gaya");
	        
	        Certificate certificate = new Certificate();
	        certificate.setCourse("Android");
	        certificate.setDuration("1.5 month");
	        student.setCertificate(certificate);
	        
	        Certificate certificate1 = new Certificate();
	        certificate1.setCourse("python");
	        certificate1.setDuration("2 month");
	        student2.setCertificate(certificate1);
	        
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        
	        session.save(student);
	        session.save(student2);
	        
	        transaction.commit();
	        sessionFactory.close();
	}
}
