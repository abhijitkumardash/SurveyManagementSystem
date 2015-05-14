package com.survey.modules.manager;

import org.hibernate.HibernateException;

import com.survey.modules.dao.QuestionDAOImpl;
import com.survey.modules.dao.SurveyDAOImpl;
import com.survey.modules.model.QuestionModel;
import com.survey.modules.model.SurveyModel;

public class QuestionManager {
	
	private QuestionDAOImpl qDAO ;


	public QuestionManager() {
		qDAO=new QuestionDAOImpl();
	}

	public void saveQuestion(QuestionModel quesObj, int surveyId){
		
		try{
			
			qDAO.openCurrentSessionwithTransaction();
			SurveyModel surveyObj=new SurveyModel();
			
		SurveyDAOImpl sDAO=new SurveyDAOImpl();
		
		SurveyManager smgr=new SurveyManager();
		surveyObj=smgr.findSurveyById(surveyId);
		quesObj.setSurvey(surveyObj);
		qDAO.saveQuestion(quesObj);
		qDAO.getCurrentTransaction().commit();
		}
		catch(HibernateException e){
			e.getStackTrace();
			System.out.println("in catch");
			qDAO.getCurrentTransaction().rollback();
		}
		finally{
			qDAO.closeCurrentSessionwithTransaction();
		}
	}
	
	public void updateQuestion(QuestionModel quesObj){
		
		try{
			qDAO.openCurrentSessionwithTransaction();
			qDAO.updateQuestion(quesObj);
			qDAO.getCurrentTransaction().commit();
		}
		catch(HibernateException e){
			e.getStackTrace();
			qDAO.getCurrentTransaction().rollback();
		}
		finally{
			qDAO.closeCurrentSessionwithTransaction();
		}
	}
	public void deleteQuestion(QuestionModel quesObj){
		try{
			qDAO.openCurrentSessionwithTransaction();
			qDAO.deleteQuestion(quesObj);
			qDAO.getCurrentTransaction().commit();
		}
		catch(HibernateException e){
			e.getStackTrace();
			qDAO.getCurrentTransaction().rollback();
		}
		finally{
			qDAO.closeCurrentSessionwithTransaction();
		}
	}
}
