package com.hibernate.fetch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity							//To Create 
@Table(name = "answerFetch")
public class AnswerFetch {
	@Id
	@Column(name="answer_id")
	private int answerId;
	private String answer;
	
	@ManyToOne
	private QuestionFetch questionFetch;
	
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public AnswerFetch(int answerId, String answer) {
		super();
		this.answerId = answerId;
		this.answer = answer;
	}
	public AnswerFetch() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
