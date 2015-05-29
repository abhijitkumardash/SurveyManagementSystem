package com.survey.modules.manager;

import java.util.List;

import com.survey.modules.model.PollModel;

public interface PollManagerInterface {

	public void savePoll(PollModel pollObject);

	public void updatePoll(PollModel pollObject);

	public void deletePoll(PollModel pollObject);

	public PollModel findPollById(int pollId);
	
	@SuppressWarnings("rawtypes")
	public Long getEachAnserCountById(int answerId);
	
	@SuppressWarnings("rawtypes")
	public Long getCountOfUser(int surveyId);

}