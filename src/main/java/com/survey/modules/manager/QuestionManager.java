package com.survey.modules.manager;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.survey.modules.dao.QuestionDAOInterface;
import com.survey.modules.model.QuestionModel;
import com.survey.modules.model.SurveyModel;
@Service
public class QuestionManager implements QuestionManagerInterface{
	
	
	private QuestionDAOInterface questionDao ;
	
	@Autowired
	private SurveyManagerInterface surveyManager;
	
	public void setSurveyManager(SurveyManagerInterface surveyManager) {
		
		this.surveyManager = surveyManager;
	}

	 public void setQuestionDao(QuestionDAOInterface questionDao) {
		
		 this.questionDao = questionDao;
	}

	@Transactional
	public void saveQuestion(QuestionModel quesObj, int surveyId){
		
		try{
			SurveyModel surveyObj=new SurveyModel();
			surveyObj=surveyManager.findSurveyById(surveyId);
			quesObj.setSurvey(surveyObj);
			questionDao.saveQuestion(quesObj);
		}
		catch(HibernateException e){
			e.getStackTrace();
			System.out.println("in catch");
		}
		
	}

	@Transactional
	public void updateQuestion(QuestionModel quesObj){
		
		try{
			questionDao.updateQuestion(quesObj);
		}
		catch(HibernateException e){
			e.getStackTrace();
		}
		
	}
	
	@Transactional
	public void deleteQuestion(QuestionModel quesObj){
		
		try{
			questionDao.deleteQuestion(quesObj);
		}
		catch(HibernateException e){
			e.getStackTrace();
		}
		
	}
	@Transactional
	@SuppressWarnings("finally")
	public QuestionModel findQuestionById(int questionId){
		
		QuestionModel questionModel=null;
		try{
			questionModel=questionDao.findQuestionById(questionId);
		}
		catch(HibernateException e){
			e.getStackTrace();
		}
		finally{
			return questionModel;
		}
	}
	
	@Transactional
	@SuppressWarnings("finally")
	public List<QuestionModel> getQuestionListBySurveyId(int surveyId){
		
		List<QuestionModel> questionList=null;
		try{
			questionList=questionDao.getQuestionListBySurveyId(surveyId);
		}
		catch(HibernateException e){
			e.getStackTrace();
		}
		finally{
			return questionList;
		}
	}
	
}
