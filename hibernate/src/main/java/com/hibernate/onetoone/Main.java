package com.hibernate.onetoone;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("com/hibernate/onetoone/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		//creating 1st question
		Question question1 = new Question();
		question1.setQuestionId(1);
		question1.setQuestion("what is your name");
		
		//creating 1st answer
		Answer answer1 = new Answer();
		answer1.setAnswerId(1);
		answer1.setAnswer("Mahi Raunak");
		
		question1.setAnswer(answer1);
		
		//creating 2nd question
		Question question2 = new Question();
		question2.setQuestionId(2);
		question2.setQuestion("Which subject you learnt");
		
		Answer answer2 = new Answer();
		answer2.setAnswerId(2);
		answer2.setAnswer("Java");
		question2.setAnswer(answer2);
		
		
		//session
		Session session =sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(question1);
		session.save(question2);
		session.save(answer1);
		session.save(answer2);
		transaction.commit();
		
		/*
		// To get the Data from database in console
		Question question = (Question)session.get(Question.class, 1);
		System.out.println(question.getQuestion());
		System.out.println(question.getAnswer().getAnswer());
		*/
		session.close();
		sessionFactory.close();
	}
}
