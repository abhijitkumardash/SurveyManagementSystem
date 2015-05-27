package com.survey.modules.manager;

import com.survey.modules.model.SurveyModel;

public interface SurveyManagerInterface {


	public void saveSurvey(SurveyModel surveyObj);

	public void updateSurvey(SurveyModel surveyObj);

	public SurveyModel findSurveyById(int surveyId);

}