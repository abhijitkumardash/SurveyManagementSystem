package com.survey.modules.manager;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.survey.modules.dao.PollDaoInterface;
import com.survey.modules.model.PollModel;


@Service
public class PollManager implements PollManagerInterface {

	private PollDaoInterface pollDao;

	public void setPollDao(PollDaoInterface pollDao) {
		this.pollDao = pollDao;
	}

	
	@Transactional
	public void savePoll(PollModel pollObject){
		
		try{
			
			pollDao.savePoll(pollObject);
		}
		catch(HibernateException e){
			e.getStackTrace();
			System.out.println("in catch");
		}
		
	}

	@Transactional
	public void updatePoll(PollModel pollObject){
		
		try{
			pollDao.updatePoll(pollObject);
		}
		catch(HibernateException e){
			e.getStackTrace();
		}
		
	}
	
	@Transactional
	public void deletePoll(PollModel pollObject){
		
		try{
			pollDao.deletePoll(pollObject);
		}
		catch(HibernateException e){
			e.getStackTrace();
		}
		
	}
	@Transactional
	@SuppressWarnings("finally")
	public PollModel findPollById(int pollId){
		
		PollModel pollModel=null;
		try{
			pollModel=pollDao.findPollById(pollId);
		}
		catch(HibernateException e){
			e.getStackTrace();
		}
		finally{
			return pollModel;
		}
	}
	
	@Transactional
	public Long getEachAnserCountById(int answerId){
		Long count = null;
		try{
			count=pollDao.getEachAnserCountById(answerId);
			
		}
		catch(HibernateException e){
			e.getStackTrace();
		}
		return count;
	}
	
	@Transactional
	public Long getCountOfUser(int surveyId){
		Long count=null;
		try{
			count=pollDao.getCountOfUser(surveyId);
		}
		catch(HibernateException e){
			e.getStackTrace();
		}
		return count;
	}
	
	
	
}
