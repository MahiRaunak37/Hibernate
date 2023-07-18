package com.hibernate.fetch;

import java.util.List;

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


@Entity								//Entity is use to define the entity in the database
@Table(name = "questionFetch")
public class QuestionFetch {
	@Id								//@Id is define the primary key in the database
	@Column(name="question_id")		//@column define the column name in the database
	private int questionId;
	private String question;
	
	//in one to many it have two fetching type lazy(By default) it load when it called
	// EAGER it load the total structure of tables
	@OneToMany(mappedBy = "questionFetch" ,fetch = FetchType.EAGER)
	private List<AnswerFetch> answers;
	
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
	public List<AnswerFetch> getAnswers() {
		return answers;
	}
	public void setAnswers(List<AnswerFetch> answers) {
		this.answers = answers;
	}
	
	
	public QuestionFetch(int questionId, String question, List<AnswerFetch> answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}
	
	//Genrating the Constructors from the super class
	public QuestionFetch() {
		super();
	}
	
	
}
