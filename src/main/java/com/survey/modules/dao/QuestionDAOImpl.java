package com.survey.modules.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.survey.modules.model.QuestionModel;

public class QuestionDAOImpl implements QuestionDAOInterface {

	private Session currentSession;
	private Transaction currentTransaction;

	public Session openCurrentSession() {
		currentSession = HibernateUtil.getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession =HibernateUtil.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {
//	currentTransaction.commit();
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
	
	public void saveQuestion(QuestionModel entity) {
		getCurrentSession().save(entity);
		
	}
	
	public void updateQuestion(QuestionModel entity){
		getCurrentSession().update(entity);
	
	}
	
	public QuestionModel findQuestionById(int questionId){
		 QuestionModel quesObj=(QuestionModel) getCurrentSession().get(QuestionModel.class, questionId);
		 return quesObj;
	}
	
	public void deleteQuestion(QuestionModel entity){
		getCurrentSession().delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<QuestionModel> QuestionList(){
		Criteria cr=getCurrentSession().createCriteria(QuestionModel.class);
		List<QuestionModel> questonList=cr.list();
		return questonList;
	}
	
	public void deleteAll(){
		List<QuestionModel> entityList = QuestionList();
		for (QuestionModel entity : entityList) {
				deleteQuestion(entity);
		}
	}


}
