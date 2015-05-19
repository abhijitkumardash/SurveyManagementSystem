package com.survey.modules.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="survey_table")
public class SurveyModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="survey_id")
	private int surveyId;
	
	@Column(name="survey_title")
	private String surveyTitle;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="survey")
	private Set<QuestionModel> questions;
	
	public Set<QuestionModel> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<QuestionModel> questions) {
		this.questions = questions;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public String getSurveyTitle() {
		return surveyTitle;
	}

	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}

	
}
