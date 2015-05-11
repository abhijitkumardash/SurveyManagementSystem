package com.survey.modules.dao;

import java.util.List;
import com.survey.modules.model.SurveyModel;

public interface SurveyDAOInterface {

	public void saveSurvey(SurveyModel entity);
	public void updateSurvey(SurveyModel entity);
	public SurveyModel findSurveyById(String surveyId);
	public void deleteSurvey(SurveyModel entity);
	public List<SurveyModel> SurveyList();
	public void deleteAll();
}
