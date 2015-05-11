package com.survey.modules.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.survey.modules.model.LoginModel;

public class LoginDAO {
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
	
	public void saveLogin(LoginModel entity) {
		getCurrentSession().save(entity);
	}
	
	public void updateLogin(LoginModel entity){
		getCurrentSession().update(entity);
	}
	
	public LoginModel findEmployeeById(String employeeId){
		 LoginModel quesObj=(LoginModel) getCurrentSession().get(LoginModel.class, employeeId);
		 return quesObj;
	}
	
	public void deleteLogin(LoginModel entity){
		getCurrentSession().delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<LoginModel> LoginList(){
		Criteria cr=getCurrentSession().createCriteria(LoginModel.class);
		List<LoginModel> loginList=cr.list();
		return loginList;
	}
	
	public void deleteAll(){
		List<LoginModel> entityList = LoginList();
		for (LoginModel entity : entityList) {
				deleteLogin(entity);
		}
	}
}
