package com.hibernate.onetoone;

//import statement
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity						//Entity is use to define the entity in the database
public class Question {
	@Id								//@Id is define the primary key in the database
	@Column(name="question_id")		//@column define the column name in the database
	private int questionId;
	private String question;
	
	@OneToOne					//One to one Mapping with Question and Answer with Id
	@JoinColumn(name = "Answer_id")
	private Answer answer;
	
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
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
	//Generating the Constructor with arguments
	public Question(int questionId, String question, Answer answer) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answer = answer;
	}
	
	//Genrating the Constructors from the super class
	public Question() {
		super();
	}
	
	
}
