package com.survey.modules.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties

public class HighChartData {
	private String QuestionTitle;
	private List<String> AnswerTitles;
	private List<Double> CountPercentage;
	public String getQuestionTitle() {
		return QuestionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		QuestionTitle = questionTitle;
	}
	public List<String> getAnswerTitles() {
		return AnswerTitles;
	}
	public void setAnswerTitles(List<String> answerTitles) {
		AnswerTitles = answerTitles;
	}
	public List<Double> getCountPercentage() {
		return CountPercentage;
	}
	public void setCountPercentage(List<Double> countPercentage) {
		CountPercentage = countPercentage;
	}

}
