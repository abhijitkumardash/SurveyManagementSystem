package com.survey.modules.dao;

import java.util.List;

import com.survey.modules.model.SurveyModel;

public interface SurveyDAOInterface {

	public void saveSurvey(SurveyModel entity);
	public SurveyModel findSurveyById(int surveyId);
	public void updateSurvey(SurveyModel entity);
	public void deleteSurvey(SurveyModel entity);
	public List<SurveyModel> SurveyList();
	public List<SurveyModel> findSurveyByName(String username);
	public void deleteAll();
}
