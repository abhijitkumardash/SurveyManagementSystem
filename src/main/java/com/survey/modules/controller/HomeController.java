package com.survey.modules.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.survey.modules.manager.QuestionManager;
import com.survey.modules.model.QuestionModel;
import com.survey.modules.manager.*;
import com.survey.modules.model.*;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );

//		 SurveyManager surveyManager=new SurveyManager();
//	        QuestionManager questionManager=new QuestionManager();
//	       
//	         SurveyModel surveyModel=new SurveyModel();
//	         surveyModel.setSurveyTitle("Survey Name12400");
//     surveyManager.saveSurvey(surveyModel);
//QuestionModel questionModel=new QuestionModel();
//	         questionModel.setQuestionTitle("Ques Name");
//	         
//	         questionModel.setSurvey(surveyModel);
//	        questionManager.saveQuestion(questionModel);
//		
//	         System.out.println("inside controller");
//		questionManager.saveQuestion(questionModel,2);
		
	        
	        
	        //for passing the 
		/*QuestionModel questionModel=new QuestionModel();
        questionModel.setQuestionTitle("Ques Name");
        questionManager.saveQuestion(questionModel,2);*/
		
		return "home";
	}
	@RequestMapping(value = {"/addQuestion" }, method = RequestMethod.GET)
	public ModelAndView homePage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("AddQuestion");
		return model;

	}
	
	@RequestMapping(value={"/saveQuestionAnswer"},method = RequestMethod.GET)
	public ModelAndView saveQuestionAnswer(@RequestParam("question") String questionTitle,
										   @RequestParam("answer1") String answer1,
										   @RequestParam("answer2") String answer2,
										   @RequestParam("answer3") String answer3,
										   @RequestParam("answer4") String answer4,
										   @RequestParam("surveyId") int surveyId){
		
		ModelAndView model = new ModelAndView();
		System.out.println(questionTitle+"ques");
		System.out.println(answer3);
//		if(answer4==""||answer4=="null"){
//			System.out.println("empty answer4");
//		}
	    QuestionManager questionManager=new QuestionManager();
		QuestionModel questionModel=new QuestionModel();
        questionModel.setQuestionTitle("Ques Name");
        questionManager.saveQuestion(questionModel,surveyId);
		model.setViewName("AddQuestion");
		return model;
 
	}
	@RequestMapping(value={"/addSurveyTitle"},method = RequestMethod.GET)
	public ModelAndView addSurveyTitle(){
		
		ModelAndView model = new ModelAndView();
		model.setViewName("AddSurvey");
		return model;
	}
	
	@RequestMapping(value={"/saveSurveyTitle"},method = RequestMethod.POST)
	public ModelAndView saveSurveyTitle( @RequestParam("surveyTitle") String surveyTitle){
		
	
		ModelAndView model = new ModelAndView();
		
		SurveyManager surveyManager=new SurveyManager();
		SurveyModel surveyModel=new SurveyModel();
        surveyModel.setSurveyTitle(surveyTitle);
       System.out.println(surveyTitle+"&&&&&&&&&&&&&");
        surveyManager.saveSurvey(surveyModel);
      System.out.println(surveyModel.getSurveyId() );

//     int  surveyId=surveyModel.getSurveyId();
//return surveyId;
      model.addObject("surveyId", surveyModel.getSurveyId() );
		//model.setViewName("redirect:" + "addQuestion");
      model.setViewName("AddQuestion");
		return model;
      
	}
	@RequestMapping(value={"/survey"},method = RequestMethod.GET)
	public ModelAndView surveyDisplay(){
		
		ModelAndView model = new ModelAndView();
		model.setViewName("Survey");
		return model;
	}
	
}
