package com.survey.modules.manager;

import java.util.List;
import com.survey.modules.model.AnswerModel;
public interface AnswerManagerInterface {
	
	public void saveAnswer(AnswerModel answerObj, int questionId);
	public void updateAnswer(AnswerModel answerObj);
	public void deleteAnswer(AnswerModel answerObj);
	public AnswerModel findAnswerById(int answerId);
	public List getAnswerListByQuestionId(int answerId);
	
}
