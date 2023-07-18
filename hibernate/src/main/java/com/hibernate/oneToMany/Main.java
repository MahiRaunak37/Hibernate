package com.hibernate.oneToMany;
 
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("com/hibernate/oneToMany/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		//creating 1st question
		QuestionOTM question1 = new QuestionOTM();
		question1.setQuestionId(1);
		question1.setQuestion("what is your name");
		
		//creating 1st answer
		AnswerOTM answer1 = new AnswerOTM();
		answer1.setAnswerId(1);
		answer1.setAnswer("Mahi");
		
		AnswerOTM answer2 = new AnswerOTM();
		answer2.setAnswerId(2);
		answer2.setAnswer("Raunak");
		
		AnswerOTM answer3 = new AnswerOTM();
		answer2.setAnswerId(3);
		answer2.setAnswer("Ashish");
		
		List<AnswerOTM> answerOTMs = new ArrayList<AnswerOTM>();
		answerOTMs.add(answer1);
		answerOTMs.add(answer2);
		answerOTMs.add(answer3);
		
		question1.setAnswersOTM(answerOTMs);
		//session
		Session session =sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(question1);
		session.save(answer1);
		session.save(answer2);
		session.save(answer3);
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
