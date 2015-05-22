package com.survey.modules.manager;

import java.util.List;

import com.survey.modules.model.QuestionModel;

public interface QuestionManagerInterface {
	
	public void saveQuestion(QuestionModel quesObj, int surveyId);
	public void updateQuestion(QuestionModel quesObj);
	public void deleteQuestion(QuestionModel quesObj);
	public QuestionModel findQuestionById(int questionId);
	public List<QuestionModel> getQuestionListBySurveyId(int surveyId);
	
}
