package com.survey.modules.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.survey.modules.model.QuestionModel;
@Repository
public class QuestionDAOImpl implements QuestionDAOInterface {
	
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory){
	     this.sessionFactory = sessionFactory;
	}
	

	public void saveQuestion(QuestionModel entity) {
		 Session session = this.sessionFactory.getCurrentSession();
		 session.save(entity);
		
	}
	
	public void updateQuestion(QuestionModel entity){
		  Session session = this.sessionFactory.getCurrentSession();
		  session.update(entity);
	
	}
	
	public QuestionModel findQuestionById(int questionId){
		  Session session = this.sessionFactory.getCurrentSession();
		 QuestionModel quesObj=(QuestionModel)session.get(QuestionModel.class, questionId);
		 return quesObj;
	}
	
	public void deleteQuestion(QuestionModel entity){
		  Session session = this.sessionFactory.getCurrentSession();
		  session.delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<QuestionModel> QuestionList(){
		  Session session = this.sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(QuestionModel.class);
		List<QuestionModel> questionList=cr.list();
		return questionList;
	}
	
	public void deleteAll(){
		 
		List<QuestionModel> entityList = QuestionList();
		for (QuestionModel entity : entityList) {
				deleteQuestion(entity);
		}
	}
	@SuppressWarnings("unchecked")
	public List<QuestionModel> getQuestionListBySurveyId(int surveyId){
		  Session session = this.sessionFactory.getCurrentSession();
		Criteria cr= session.createCriteria(QuestionModel.class);
		cr.add(Restrictions.eq( "survey.surveyId",surveyId));
		List<QuestionModel> questionList=cr.list();
		return questionList;
	}


}
