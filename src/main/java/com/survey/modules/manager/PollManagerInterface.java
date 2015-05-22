package com.survey.modules.manager;

import org.springframework.transaction.annotation.Transactional;

import com.survey.modules.model.PollModel;

public interface PollManagerInterface {

	public void savePoll(PollModel pollObject);

	public void updatePoll(PollModel pollObject);

	public void deletePoll(PollModel pollObject);

	public PollModel findPollById(int pollId);

}