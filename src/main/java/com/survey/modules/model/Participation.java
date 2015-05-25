package com.survey.modules.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="participation_table")
public class Participation {
	
	@Id
	private int participationId;
	
	private QuestionModel questionModel;
	

}
