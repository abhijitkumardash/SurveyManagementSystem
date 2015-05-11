package com.survey.modules.dao;

import java.util.List;

import com.survey.modules.model.QuestionModel;


public interface QuestionDAOInterface {
	
 public void saveQuestion(QuestionModel entity);
 public void updateQuestion(QuestionModel entity);
 public QuestionModel findQuestionById(String employeeId);
 public void deleteQuestion(QuestionModel entity);
 public List<QuestionModel> QuestionList();
 public void deleteAll();
}
