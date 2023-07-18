package com.hibernate.oneToMany;

import java.util.List;

//import statement
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity						//Entity is use to define the entity in the database
@Table(name = "questionOTM")
public class QuestionOTM {
	@Id								//@Id is define the primary key in the database
	@Column(name="question_id")		//@column define the column name in the database
	private int questionId;
	private String question;
	
	@OneToMany(mappedBy = "questionOTM")
	private List<AnswerOTM> answersOTM;
	
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
	public List<AnswerOTM> getAnswersOTM() {
		return answersOTM;
	}
	public void setAnswersOTM(List<AnswerOTM> answersOTM) {
		this.answersOTM = answersOTM;
	}
	
	public QuestionOTM(int questionId, String question, List<AnswerOTM> answersOTM) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answersOTM = answersOTM;
	}
	
	//Genrating the Constructors from the super class
	public QuestionOTM() {
		super();
	}
	
	
}
