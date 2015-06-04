package com.survey.modules.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "question_table")
public class QuestionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "question_id")
	private int questionId;

	@Column(name = "question_title")
	private String questionTitle;

	@ManyToOne
	@JoinColumn(name = "survey_id")
	private SurveyModel survey;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "question")
	@Fetch(FetchMode.SELECT)
	private Set<AnswerModel> answers;
	

	@Column(name="question_type")
	private String questionType;

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	

	public int getQuestionId() {
		return questionId;
	}

	public Set<AnswerModel> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<AnswerModel> answers) {
		this.answers = answers;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public SurveyModel getSurvey() {
		return survey;
	}

	public void setSurvey(SurveyModel survey) {
		this.survey = survey;
	}

}
