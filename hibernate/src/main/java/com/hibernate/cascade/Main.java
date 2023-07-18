package com.hibernate.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
 public static void main(String[] args) {
	//creating configuration obect
			Configuration configuration = new Configuration();
			configuration.configure("com/hibernate/cascade/hibernate.cfg.xml");
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			QuestionCas questionCas1 = new QuestionCas();
			questionCas1.setQuestionId(1001);
			questionCas1.setQuestion("what is your name");
			
			AnswerCas answerCas1 = new AnswerCas(101, "mahi");
			AnswerCas answerCas2 = new AnswerCas(102, "raunak");
			AnswerCas answerCas3 = new AnswerCas(103, "ashish");
			
			List<AnswerCas> answersList = new ArrayList<AnswerCas>();
			answersList.add(answerCas1);
			answersList.add(answerCas2);
			answersList.add(answerCas3);
			
			questionCas1.setAnswersOTM(answersList);
			Transaction transaction = session.beginTransaction();
			session.save(questionCas1);
			transaction.commit();
			session.close();
			sessionFactory.close();
}
}
