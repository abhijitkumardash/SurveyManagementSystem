package com.survey.modules.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="answer_table")
public class AnswerModel {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="answer_id")
	private int answerId;

	@Column(name="answer_desc")
	private String answerDesc;
	

	@ManyToOne(cascade=CascadeType.ALL)  
   	@JoinColumn(name="question_id")
	private QuestionModel question;


	public int getAnswerId() {
		return answerId;
	}


	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}


	public String getAnswerDesc() {
		return answerDesc;
	}


	public void setAnswerDesc(String answerDesc) {
		this.answerDesc = answerDesc;
	}


	public QuestionModel getQuestion() {
		return question;
	}


	public void setQuestion(QuestionModel question) {
		this.question = question;
	}
	
	
}
