package com.survey.modules.manager;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.slf4j.LoggerFactory;

import com.survey.modules.controller.HomeController;
import com.survey.modules.dao.QuestionDAO;
import com.survey.modules.model.QuestionModel;

public class QuestionManager {
	
	private QuestionDAO qDAO ;


	public QuestionManager() {
		qDAO=new QuestionDAO();
	}

	public void saveQuestion(QuestionModel quesObj){
		
		try{
			qDAO.openCurrentSessionwithTransaction();
			qDAO.saveQuestion(quesObj);
		}
		catch(HibernateException e){
			e.getStackTrace();
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
