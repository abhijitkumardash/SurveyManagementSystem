package com.survey.modules.manager;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.survey.modules.dao.SurveyDAOInterface;
import com.survey.modules.model.SurveyModel;

@Service
public class SurveyManager implements SurveyManagerInterface {
	
	private SurveyDAOInterface surveyDao ;
	
	public void setSurveyDao(SurveyDAOInterface surveyDao) {
		this.surveyDao = surveyDao;
	}
    @Transactional

	public void saveSurvey(SurveyModel surveyObj){
		
		try{
			surveyDao.saveSurvey(surveyObj);
		}
		catch(HibernateException e){
			e.getStackTrace();
		}
	}
    @Transactional
	public void updateSurvey(SurveyModel surveyObj){
		
		try{
			surveyDao.updateSurvey(surveyObj);
		}
		catch(HibernateException e){
			e.getStackTrace();
		}
		
	}
   
	@SuppressWarnings("finally")
	@Transactional
	public SurveyModel findSurveyById(int surveyId){
		
		SurveyModel surveyModel=null;
		try{
			surveyModel=surveyDao.findSurveyById(surveyId);
		}
		catch(HibernateException e){
			e.getStackTrace();
			
		}
		finally{
			
			return surveyModel;
		}
	}
}
