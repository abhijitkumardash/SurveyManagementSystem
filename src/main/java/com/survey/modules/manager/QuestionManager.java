package com.survey.modules.manager;

import org.hibernate.HibernateException;

import com.survey.modules.dao.QuestionDAOImpl;
import com.survey.modules.model.QuestionModel;

public class QuestionManager {
	
	private QuestionDAOImpl qDAO ;


	public QuestionManager() {
		qDAO=new QuestionDAOImpl();
	}

	public void saveQuestion(QuestionModel quesObj){
		
		try{
			qDAO.openCurrentSessionwithTransaction();
			qDAO.saveQuestion(quesObj);
		  qDAO.getCurrentTransaction().commit();
		}
		catch(HibernateException e){
			e.getStackTrace();
			System.out.println("sadszfsdfsdfg");
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
