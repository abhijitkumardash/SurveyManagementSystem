package com.survey.modules.manager;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.modules.dao.AnswerDAOInterface;
import com.survey.modules.model.AnswerModel;
import com.survey.modules.model.QuestionModel;

@Service
public class AnswerManager implements AnswerManagerInterface {

	private AnswerDAOInterface answerDAO;

	public void setAnswerDAO(AnswerDAOInterface answerDAO) {
		this.answerDAO = answerDAO;
	}

	@Autowired
	private QuestionManagerInterface questionManager;

	public void setQuestionManager(QuestionManagerInterface questionManager) {
		this.questionManager = questionManager;
	}

	@Transactional
	public void saveAnswer(AnswerModel answerObj, int questionID) {

		try {
			QuestionModel questionObj = new QuestionModel();
			questionObj = questionManager.findQuestionById(questionID);
			answerObj.setQuestion(questionObj);
			answerDAO.saveAnswer(answerObj);
		} catch (HibernateException e) {
			e.getStackTrace();
			System.out.println("in catch");

		}

	}

	@Transactional
	public void updateAnswer(AnswerModel answerObj) {
		try {

			answerDAO.updateAnswer(answerObj);

		} catch (HibernateException e) {
			e.getStackTrace();
		}

	}

	@Transactional
	public void deleteAnswer(AnswerModel answerObj) {
		try {

			answerDAO.deleteAnswer(answerObj);

		} catch (HibernateException e) {
			e.getStackTrace();
		}

	}

	@SuppressWarnings("finally")
	public AnswerModel findAnswerById(int answerId) {
		AnswerModel answerModel = null;
		try {

			answerModel = answerDAO.findAnswerById(answerId);
		} catch (HibernateException e) {
			e.getStackTrace();

		} finally {

			return answerModel;
		}
	}

	@SuppressWarnings({ "finally", "rawtypes" })
	public List getAnswerListByQuestionId(int questionId) {
		List<AnswerModel> answerList = null;
		try {

			answerList = answerDAO.getAnswerListByQuestionId(questionId);

		} catch (HibernateException e) {
			e.getStackTrace();

		} finally {

			return answerList;
		}
	}
}
