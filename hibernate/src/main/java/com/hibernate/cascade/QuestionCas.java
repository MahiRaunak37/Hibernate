package com.hibernate.cascade;

import java.util.List;

import javax.persistence.CascadeType;
//import statement
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity						//Entity is use to define the entity in the database
@Table(name = "question_cascade")
public class QuestionCas {
	@Id								//@Id is define the primary key in the database
	@Column(name="question_id")		//@column define the column name in the database
	private int questionId;
	private String question;
	
	@OneToMany(mappedBy = "questionCas",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<AnswerCas> answersCas;
	
	//Generating Getter and Setter Method
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<AnswerCas> getAnswersCas() {
		return answersCas;
	}
	public void setAnswersOTM(List<AnswerCas> answersCas) {
		this.answersCas = answersCas;
	}
	
	public QuestionCas(int questionId, String question, List<AnswerCas> answersCas) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answersCas = answersCas;
	}
	
	//Genrating the Constructors from the super class
	public QuestionCas() {
		super();
	}
	
	
}
