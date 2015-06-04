package com.survey.modules.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties

public class Question implements Serializable {

	private static final long serialVersionUID = -987074521702080901L;
	
	private int surveyId;
	private String question;
	public List<String> answers;
	private String questionType;
	
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<String> getAnswers() {
		return answers;
	}
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	@Override
	public String toString() {
		return "Question [surevyId=" + surveyId + ", question=" + question
				+ ", answers=" + answers + "]";
	}
	
	
}
