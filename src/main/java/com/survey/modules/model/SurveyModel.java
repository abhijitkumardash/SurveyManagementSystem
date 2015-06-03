package com.survey.modules.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="survey_table")
public class SurveyModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="survey_id")
	private int surveyId;
	
	@Column(name="survey_title")
	private String surveyTitle;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="survey", orphanRemoval=true)
	@Fetch(FetchMode.SELECT)
	private Set<QuestionModel> questions;
	

	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.REFRESH)
	@JoinColumn(name = "username", nullable = false)
	private Users user;
	
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

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
