package com.survey.modules.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.survey.modules.model.AnswerModel;

public class AnswerDAO {
	private Session currentSession;
	private Transaction currentTransaction;

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
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

	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(builder.build());
		return sessionFactory;
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
	
	public void saveAnswer(AnswerModel entity) {
		getCurrentSession().save(entity);
	}
	
	public void updateAnswer(AnswerModel entity){
		getCurrentSession().update(entity);
	}
	
	public AnswerModel findAnswerById(int answerId){
		 AnswerModel answerObj=(AnswerModel) getCurrentSession().get(AnswerModel.class, answerId);
		 return answerObj;
	}
	
	public void deleteAnswer(AnswerModel entity){
		getCurrentSession().delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<AnswerModel> AnswerList(){
		Criteria cr=getCurrentSession().createCriteria(AnswerModel.class);
		List<AnswerModel> AnswerList=cr.list();
		return AnswerList;
	}
	
	public void deleteAll(){
		List<AnswerModel> entityList = AnswerList();
		for (AnswerModel entity : entityList) {
				deleteAnswer(entity);
		}
	}
}
