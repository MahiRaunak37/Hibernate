package com.hibernate.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("com/hibernate/hql/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		
		/*
		//To insert the Data into the student tables
		Student student1 = new Student();
		student1.setId(1001);
		student1.setAge(25);
		student1.setName("raunak");
		student1.setCity("gaya");
		
		Student student2 = new Student();
		student2.setId(1002);
		student2.setAge(26);
		student2.setName("dipu");
		student2.setCity("delhi");
		
		
		Student student3 = new Student();
		student3.setId(1003);
		student3.setAge(27);
		student3.setName("kamal");
		student3.setCity("Patna");
		
		Student student4 = new Student();
		student4.setId(1004);
		student4.setAge(28);
		student4.setName("modi");
		student4.setCity("ara");
		
		 Transaction transaction = session.beginTransaction();
	     session.save(student1);
	     session.save(student2);
	     session.save(student3);
	     session.save(student4);
	     session.getTransaction().commit();
		*/
		
		// from <class_name> where <property_name='value'" this is all for Java class
		// not database.
		/// String stringQuery = "from Student where city='delhi'";

		// to Set the value dynamic into the query
		/// String stringQuery = "from Student where city=:x";

		String stringQuery = "from Student as S where S.city=:x and S.age=:y";

		Query query = session.createQuery(stringQuery);

		query.setParameter("x", "ara");
		query.setParameter("y", 28);

		// to fetch unique result
		// query.uniqueResult();

		// to fetch multiple result
		List<Student> studentList = query.list();

		for (Student std : studentList) {
			System.out.println(std.getName());
		}
		/*
		//	To delete the data from database using Hibrnate
		Transaction transaction2 = session.beginTransaction();
		Query query2 = session.createQuery("delete from Student where city=:c");
		query2.setParameter("c", "Patna");
		int result = query2.executeUpdate();
		System.out.println(result+" rows is deleted");
		transaction2.commit();
		 */
		
		/*
		//To update the data from database using Hibernate
		Transaction transaction3 = session.beginTransaction();
		Query query3 = session.createQuery("update Student set city=:c where name=:n");
		query3.setParameter("n", "modi");
		query3.setParameter("c","mayur marg");
		int result3 = query3.executeUpdate();
		System.out.println(result3+" are updated");
		transaction3.commit();
		*/ 
		
		//To execute join the table
		Transaction transaction4 = session.beginTransaction();
		Query query4 = session.createQuery("select q.question,q.questionId,a.answer from QuestionOTM as q INNER JOIN q.answersOTM as a");
		List<Object[]> list4 = query4.getResultList();
		for(Object []arr:list4) {
			System.out.println(Arrays.toString(arr));
		}
		transaction4.commit();
		
		sessionFactory.close();
		session.close();
	}
}
