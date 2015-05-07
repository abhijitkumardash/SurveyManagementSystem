package com.survey.modules.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.survey.modules.model.QuestionModel;

public class QuestionDAO {
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
		currentTransaction.commit();
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
	
	public void saveQuestion(QuestionModel entity) {
		getCurrentSession().save(entity);
	}
	
	public void updateQuestion(QuestionModel entity){
		getCurrentSession().update(entity);
	}
	
	public QuestionModel findEmployeeById(String employeeId){
		 QuestionModel quesObj=(QuestionModel) getCurrentSession().get(QuestionModel.class, employeeId);
		 return quesObj;
	}
	
	public void deleteQuestion(QuestionModel entity){
		getCurrentSession().delete(entity);
	}
	
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
