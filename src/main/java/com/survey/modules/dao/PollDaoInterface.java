package com.survey.modules.dao;

import java.util.List;

import com.survey.modules.model.PollModel;

public interface PollDaoInterface {

	public abstract void savePoll(PollModel entity);

	public abstract void updatePoll(PollModel entity);

	public abstract PollModel findPollById(int pollId);

	public abstract void deletePoll(PollModel entity);

	public abstract List<PollModel> PollList();

	public abstract void deleteAll();

}