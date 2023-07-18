package com.hibernate.sqlQuery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

/**
 * 
 * @author Mahi Raunak
 * @category MySql query in hibernate
 * @
 */
public class Main {

	public static void main(String[] args) {
		//creating configuration obect
				Configuration configuration = new Configuration();
				configuration.configure("com/hibernate/sqlQuery/hibernate.cfg.xml");
				SessionFactory sessionFactory = configuration.buildSessionFactory();
				Session session = sessionFactory.openSession();
				
				//SQl Query
				String query = "select * from student_table_mysqlQuery";
				NativeQuery nativeQuery =session.createSQLQuery(query);
				
				List<Object []> studentsList = nativeQuery.list();
				
				for(Object[] student :studentsList) {
					System.out.println(Arrays.toString(student));
				}
				
				
				session.close();
				sessionFactory.close();

	}

}
