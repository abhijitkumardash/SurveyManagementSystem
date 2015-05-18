package com.survey.modules.dao;

import java.util.List;

import com.survey.modules.model.AnswerModel;


public interface AnswerDAOInterface {
	
 public void saveAnswer(AnswerModel entity);
 public void updateAnswer(AnswerModel entity);
 public AnswerModel findAnswerById(int answerId);
 public void deleteAnswer(AnswerModel entity);
 public List<AnswerModel> AnswerList();
 public void deleteAll();
}
