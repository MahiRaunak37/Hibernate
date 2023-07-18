package com.hibernate.fetch;
 
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("com/hibernate/fetch/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		//creating 1st question
		QuestionFetch question1 = new QuestionFetch();
		question1.setQuestionId(1);
		question1.setQuestion("what is your name");
		
		//creating 1st answer
		AnswerFetch answer1 = new AnswerFetch();
		answer1.setAnswerId(1);
		answer1.setAnswer("Mahi");
		
		AnswerFetch answer2 = new AnswerFetch();
		answer2.setAnswerId(2);
		answer2.setAnswer("Raunak");
		
		AnswerFetch answer3 = new AnswerFetch();
		answer2.setAnswerId(3);
		answer2.setAnswer("Ashish");
		
		List<AnswerFetch> answerFetchs = new ArrayList<AnswerFetch>();
		answerFetchs.add(answer1);
		answerFetchs.add(answer2);
		answerFetchs.add(answer3);
		
		question1.setAnswers(answerFetchs);
		//session
		Session session =sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		/*
		session.save(question1);
		session.save(answer1);
		session.save(answer2);
		session.save(answer3);
		transaction.commit();
		*/
		
		// To get the Data from database in console
		QuestionFetch questionFetch = (QuestionFetch)session.get(QuestionFetch.class, 1);
		System.out.println(question1.getQuestionId());
		System.out.println(question1.getQuestion());
		
		//Lazy Loading:- Automatically does not load form database. it load when it called.
		//when size called then it load the data
		System.out.println(question1.getAnswers().size());
		
		session.close();
		sessionFactory.close();
	}
}
