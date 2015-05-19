package com.survey.modules.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.survey.modules.service.UsersService;
import com.survey.modules.manager.QuestionManager;
import com.survey.modules.model.QuestionModel;
import com.survey.modules.manager.*;
import com.survey.modules.model.*;

@Controller
public class HomeController {
	@Autowired
	private UsersService usersService;

	
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;

	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@ModelAttribute Users users,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;

	}

	@RequestMapping("/user**")
	public String getUserProfile() {
		return "user";
	}

	@RequestMapping("/403")
	public @ResponseBody ModelAndView getAccessDenied() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String username = "";
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			username = userDetail.getUsername();
		}

		return new ModelAndView("403", "username", username);
	}
	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public ModelAndView signupPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("signup");
		return model;

	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute Users user,
			@RequestParam("confirm-password") String confirmPassword) {
		ModelAndView modelView = new ModelAndView();
		Boolean flagSave = true;

		if (!(user.getPassword().equals(confirmPassword))) {
			flagSave = false;
			modelView.addObject("error", "Password Mismatch!!");
			modelView.setViewName("signup");

		}
		if (flagSave == true) {
			try{
			this.usersService.addUser(user);
			modelView.addObject("error", "Registered Successfully!!");
			modelView.setViewName("login");
			}
			catch (Exception e){
				 e.printStackTrace();
				 modelView.addObject("error", "Already Registerd in same Email!!");
				 modelView.addObject("forgot_password", "Forgot Password?");
				 modelView.setViewName("signup");
			}
		}
		return modelView;
	}
	@RequestMapping(value = {"/addQuestion" }, method = RequestMethod.GET)
	public ModelAndView homePage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("AddQuestion");
		return model;

	}
	
	@RequestMapping(value={"/saveQuestionAnswer"},method = RequestMethod.POST)
	public @ResponseBody int  saveQuestionAnswer(@RequestParam("question") String questionTitle,
										   @RequestParam("answer1") String answer1,
										   @RequestParam("answer2") String answer2,
										   @RequestParam("answer3") String answer3,
										   @RequestParam("answer4") String answer4,
										   @RequestParam("surveyId") int surveyId){
	
		ModelAndView model = new ModelAndView();
		
//		if(answer4==""||answer4=="null"){
//			System.out.println("empty answer4");
//		}
	    QuestionManager questionManager=new QuestionManager();
		QuestionModel questionModel=new QuestionModel();
        questionModel.setQuestionTitle(questionTitle);
        questionManager.saveQuestion(questionModel,surveyId);
        return surveyId;

 
	}
	@RequestMapping(value={"/addSurveyTitle"},method = RequestMethod.GET)
	public ModelAndView addSurveyTitle(){
		
		ModelAndView model = new ModelAndView();
		model.setViewName("AddSurvey");
		return model;
	}
	
	@RequestMapping(value={"/saveSurveyTitle"},method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveSurveyTitle( @RequestParam("surveyTitle") String surveyTitle){
		
	
		ModelAndView model = new ModelAndView();
		
		SurveyManager surveyManager=new SurveyManager();
		SurveyModel surveyModel=new SurveyModel();
        surveyModel.setSurveyTitle(surveyTitle);
        surveyManager.saveSurvey(surveyModel);

        model.addObject("surveyId", surveyModel.getSurveyId() );
//		model.setViewName("redirect:" + "addQuestion");
        model.setViewName("AddQuestion");
		return model;
      
	}

	@RequestMapping(value={"/{questionId}"},method = RequestMethod.GET)
	public ModelAndView surveyDisplay(@PathVariable("questionId") int questionId ){
		
		ModelAndView model = new ModelAndView();
		System.out.println("questionId b4 save "+questionId);
		QuestionManager questionManager=new QuestionManager();
		QuestionModel questionModel=questionManager.findQuestionById(questionId);
		String questionTitle=questionModel.getQuestionTitle();
		model.addObject("questionTitle",questionTitle);
		System.out.println("questionId"+questionId);
		
		model.setViewName("SurveyPoll");
		return model;
	}
	
	
		
}
