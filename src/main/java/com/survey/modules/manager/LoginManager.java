package com.survey.modules.manager;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.slf4j.LoggerFactory;

import com.survey.modules.controller.HomeController;
import com.survey.modules.dao.LoginDAO;
import com.survey.modules.model.LoginModel;

public class LoginManager {
	private LoginDAO logindao;


	public LoginManager() {
		logindao=new LoginDAO();
	}

	public void saveLogin(LoginModel loginObject){
		
		try{
			logindao.openCurrentSessionwithTransaction();
			logindao.saveLogin(loginObject);
		}
		catch(HibernateException e){
			e.getStackTrace();
			logindao.getCurrentTransaction().rollback();
		}
		finally{
			logindao.closeCurrentSessionwithTransaction();
		}
	}
	
	public void updateLogin(LoginModel loginObject){
		
		try{
			logindao.openCurrentSessionwithTransaction();
			logindao.updateLogin(loginObject);
		}
		catch(HibernateException e){
			e.getStackTrace();
			logindao.getCurrentTransaction().rollback();
		}
		finally{
			logindao.closeCurrentSessionwithTransaction();
		}
	}
}
