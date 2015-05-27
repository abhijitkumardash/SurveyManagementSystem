package com.survey.modules.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.survey.modules.model.AnswerModel;

@Repository
public class AnswerDAOImpl implements AnswerDAOInterface {

	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveAnswer(AnswerModel entity) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(entity);

	}

	public void updateAnswer(AnswerModel entity) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(entity);

	}

	public AnswerModel findAnswerById(int answerId) {
		Session session = this.sessionFactory.getCurrentSession();
		AnswerModel ansObj = (AnswerModel) session.get(AnswerModel.class,
				answerId);
		return ansObj;
	}

	public void deleteAnswer(AnswerModel entity) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<AnswerModel> AnswerList() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(AnswerModel.class);
		List<AnswerModel> AnswerList = cr.list();
		return AnswerList;
	}

	public void deleteAll() {
		List<AnswerModel> entityList = AnswerList();
		for (AnswerModel entity : entityList) {
			deleteAnswer(entity);
		}
	}

	@SuppressWarnings("unchecked")
	public List<AnswerModel> getAnswerListByQuestionId(int questionId) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(AnswerModel.class);
		cr.add(Restrictions.eq("question.questionId", questionId));
		List<AnswerModel> answerList = cr.list();
		return answerList;
	}

}
