package com.survey.modules.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.survey.modules.model.SurveyModel;

@Repository
public class SurveyDAOImpl implements SurveyDAOInterface{
	
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory){
	     this.sessionFactory = sessionFactory;
	}
	
	
	public void saveSurvey(SurveyModel entity) {
		 Session session = this.sessionFactory.getCurrentSession();
		 session.save(entity);
		
	}
	
	public void updateSurvey(SurveyModel entity){
		 Session session = this.sessionFactory.getCurrentSession();
		 session.update(entity);
		
	}
	
	public SurveyModel findSurveyById(int surveyId){
		 Session session = this.sessionFactory.getCurrentSession();
		 SurveyModel surveyObj=(SurveyModel)session.get(SurveyModel.class, surveyId);
		 return surveyObj;
	}
	
	public void deleteSurvey(SurveyModel entity){
		 Session session = this.sessionFactory.getCurrentSession();
		 session.delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<SurveyModel> SurveyList(){
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(SurveyModel.class);
		List<SurveyModel> surveyList=cr.list();
		return surveyList;
	}
	@SuppressWarnings("unchecked")
	public List<SurveyModel> findSurveyByName(String username){
		 Session session = this.sessionFactory.getCurrentSession();
		 Criteria cr=session.createCriteria(SurveyModel.class);
		 cr.add(Restrictions.eq( "user.username",username));
			List<SurveyModel> surveyList=cr.list();
			return surveyList;
	}
	
	public void deleteAll(){
		List<SurveyModel> entityList = SurveyList();
		for (SurveyModel entity : entityList) {
				deleteSurvey(entity);
		}
	}

	public void deleteSurveyById(int surveyId){
		 Session session = this.sessionFactory.getCurrentSession();
		 SurveyModel surveyObj=(SurveyModel)session.get(SurveyModel.class, surveyId);
System.out.println(surveyId);
		 session.delete(surveyObj);
	}
}
