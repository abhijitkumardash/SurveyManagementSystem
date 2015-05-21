package com.survey.modules.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.survey.modules.model.QuestionModel;
import com.survey.modules.model.SurveyModel;

@Entity
@JsonIgnoreProperties

public class Question implements Serializable {

	private static final long serialVersionUID = -987074521702080901L;
	
	int surveyId;
	String question;
	public List<String> answers;
	
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
