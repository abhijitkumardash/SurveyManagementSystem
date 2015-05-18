package com.survey.modules.manager;

import org.hibernate.HibernateException;

import com.survey.modules.dao.AnswerDAO;
import com.survey.modules.model.AnswerModel;
import com.survey.modules.model.SurveyModel;
import com.survey.modules.model.QuestionModel;

public class AnswerManager {

	private AnswerDAO answerDAO;

	public AnswerManager() {

		answerDAO = new AnswerDAO();
	}

	public void saveAnswer(AnswerModel answerObj, int questionID, int surveyId) {

		try {

			answerDAO.openCurrentSessionwithTransaction();
			QuestionModel questionObj = new QuestionModel();
			SurveyModel surveyObj = new SurveyModel();

//			QuestionDAOImpl questionDAO = new QuestionDAOImpl();
//			SurveyDAOImpl sDAO = new SurveyDAOImpl();

			SurveyManager smgr = new SurveyManager();
			surveyObj = smgr.findSurveyById(surveyId);
			answerObj.setSurvey(surveyObj);

			QuestionManager qmgr = new QuestionManager();
			questionObj = qmgr.findQuestionById(questionID);
			answerObj.setQuestion(questionObj);

			answerDAO.saveAnswer(answerObj);

			answerDAO.getCurrentTransaction().commit();
			
		} catch (HibernateException e) {
			e.getStackTrace();
			System.out.println("in catch");
			answerDAO.getCurrentTransaction().rollback();
		} finally {
			answerDAO.closeCurrentSessionwithTransaction();
		}
	}

	public void updateAnswer(AnswerModel answerObj) {

		try {
			answerDAO.openCurrentSessionwithTransaction();
			answerDAO.updateAnswer(answerObj);
			answerDAO.getCurrentTransaction().commit();
		} catch (HibernateException e) {
			e.getStackTrace();
			answerDAO.getCurrentTransaction().rollback();
		} finally {
			answerDAO.closeCurrentSessionwithTransaction();
		}
	}

	public void deleteAnswer(AnswerModel answerObj) {
		try {
			answerDAO.openCurrentSessionwithTransaction();
			answerDAO.deleteAnswer(answerObj);
			answerDAO.getCurrentTransaction().commit();
		} catch (HibernateException e) {
			e.getStackTrace();
			answerDAO.getCurrentTransaction().rollback();
		} finally {
			answerDAO.closeCurrentSessionwithTransaction();
		}
	}

	@SuppressWarnings("finally")
	public AnswerModel findAnswerById(int answerId) {
		AnswerModel answerModel = null;
		try {
			answerDAO.openCurrentSessionwithTransaction();
			answerModel = answerDAO.findAnswerById(answerId);
		} catch (HibernateException e) {
			e.getStackTrace();
			answerDAO.getCurrentTransaction().rollback();
		} finally {
			answerDAO.closeCurrentSession();
			return answerModel;
		}
	}

}
