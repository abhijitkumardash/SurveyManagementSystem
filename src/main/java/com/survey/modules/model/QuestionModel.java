package com.survey.modules.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="question_table")
public class QuestionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="question_id")
	private int questionId;
	
	@Column(name="question_title")
	private String questionTitle;
	
	@ManyToOne
   	@JoinColumn(name="survey_id")
	private SurveyModel survey;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public SurveyModel getSurvey() {
		return survey;
	}

	public void setSurvey(SurveyModel survey) {
		this.survey = survey;
	}

	
	
}
