package com.survey.modules.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.survey.modules.model.SurveyModel;



public class SurveyDAOImpl implements SurveyDAOInterface{
	private Session currentSession;
	private Transaction currentTransaction;

	public Session openCurrentSession() {
		currentSession = HibernateUtil.getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = HibernateUtil.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {
		//currentTransaction.commit();
		currentSession.close();
	}


	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}
	
	public void saveSurvey(SurveyModel entity) {
		getCurrentSession().save(entity);
		
	}
	
	public void updateSurvey(SurveyModel entity){
		getCurrentSession().update(entity);
		
	}
	
	public SurveyModel findSurveyById(String surveyId){
		 SurveyModel surveyObj=(SurveyModel) getCurrentSession().get(SurveyModel.class, surveyId);
		 return surveyObj;
	}
	
	public void deleteSurvey(SurveyModel entity){
		getCurrentSession().delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<SurveyModel> SurveyList(){
		Criteria cr=getCurrentSession().createCriteria(SurveyModel.class);
		List<SurveyModel> surveyList=cr.list();
		return surveyList;
	}
	
	public void deleteAll(){
		List<SurveyModel> entityList = SurveyList();
		for (SurveyModel entity : entityList) {
				deleteSurvey(entity);
		}
	}
}
