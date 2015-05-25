package com.survey.modules.model;

import java.util.List;


public class Poll {

	private int surveyId;
	private String surveyTitle;
	
	private List<Integer> questionId;
	private List<String> questionDesc;
	
	private List<Integer> answerId;
	private List<String> answerDesc;
	
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
	public List<Integer> getQuestionId() {
		return questionId;
	}
	public void setQuestionId(List<Integer> questionId) {
		this.questionId = questionId;
	}
	public List<String> getQuestionDesc() {
		return questionDesc;
	}
	public void setQuestionDesc(List<String> questionDesc) {
		this.questionDesc = questionDesc;
	}
	public List<Integer> getAnswerId() {
		return answerId;
	}
	public void setAnswerId(List<Integer> answerId) {
		this.answerId = answerId;
	}
	public List<String> getAnswerDesc() {
		return answerDesc;
	}
	public void setAnswerDesc(List<String> answerDesc) {
		this.answerDesc = answerDesc;
	}

}
