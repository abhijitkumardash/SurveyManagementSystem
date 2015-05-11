package com.survey.modules.manager;

import org.hibernate.HibernateException;

import com.survey.modules.dao.SurveyDAOImpl;
import com.survey.modules.model.SurveyModel;


public class SurveyManager {
	private SurveyDAOImpl sDAO ;


	public SurveyManager() {
		sDAO=new SurveyDAOImpl();
	}

	public void saveSurvey(SurveyModel surveyObj){
		
		try{
			sDAO.openCurrentSessionwithTransaction();
			sDAO.saveSurvey(surveyObj);
			sDAO.getCurrentTransaction().commit();
		}
		catch(HibernateException e){
			e.getStackTrace();
			sDAO.getCurrentTransaction().rollback();
		}
		finally{
			sDAO.closeCurrentSessionwithTransaction();
		}
	}
	
	public void updateSurvey(SurveyModel surveyObj){
		
		try{
			sDAO.openCurrentSessionwithTransaction();
			sDAO.updateSurvey(surveyObj);
		}
		catch(HibernateException e){
			e.getStackTrace();
			sDAO.getCurrentTransaction().rollback();
		}
		finally{
			sDAO.closeCurrentSessionwithTransaction();
		}
	}
}
