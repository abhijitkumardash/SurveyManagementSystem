package com.survey.modules.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties
public class UserPoll implements Serializable {
	
	private static final long serialVersionUID = -6067328941096618567L;
	private int surveyId;
	private List<Integer> questions;
	private List<Integer> answers;
	
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public List<Integer> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Integer> questions) {
		this.questions = questions;
	}
	public List<Integer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Integer> answers) {
		this.answers = answers;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "UserPoll [surveyId=" + surveyId + ", questions=" + questions
				+ ", answers=" + answers + "]";
	}
	
	
	

}
