package com.survey.modules.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="poll_table")
public class PollModel {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="poll_id")
	private int pollId;
	
	@Column(name="survey_id")
	private int surveyId;
	
	@Column(name="question_id")
	private int questionId;
	
	@Column(name="answer_id")
	private int answerId;
	
	public int getPollId() {
		return pollId;
	}
	public void setPollId(int pollId) {
		this.pollId = pollId;
	}
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	
	
	
}
