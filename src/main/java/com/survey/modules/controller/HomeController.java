package com.survey.modules.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.survey.modules.manager.AnswerManagerInterface;
import com.survey.modules.manager.PollManagerInterface;
import com.survey.modules.manager.QuestionManager;
import com.survey.modules.manager.QuestionManagerInterface;
import com.survey.modules.manager.SurveyManagerInterface;
import com.survey.modules.model.AnswerModel;
import com.survey.modules.model.HighChartData;
import com.survey.modules.model.PollModel;
import com.survey.modules.model.Question;
import com.survey.modules.model.QuestionModel;
import com.survey.modules.model.SurveyModel;
import com.survey.modules.model.UserPoll;
import com.survey.modules.model.Users;
import com.survey.modules.service.UsersService;

@Controller
public class HomeController {
	@Autowired
	private UsersService usersService;

	@Autowired
	private SurveyManagerInterface surveyManager;

	@Autowired
	private QuestionManagerInterface questionManager;

	@Autowired
	private AnswerManagerInterface answerManager;
	
	@Autowired
	private PollManagerInterface pollManager; 

	public void setQuestionManager(QuestionManager questionManager) {
		this.questionManager = questionManager;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public void setSurveyManager(SurveyManagerInterface surveyManager) {
		this.surveyManager = surveyManager;
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
			try {
				this.usersService.addUser(user);
				modelView.addObject("error", "Registered Successfully!!");
				modelView.setViewName("login");
			} catch (Exception e) {
				e.printStackTrace();
				modelView.addObject("error",
						"Already Registerd in same Email!!");
				modelView.addObject("forgot_password", "Forgot Password?");
				modelView.setViewName("signup");
			}
		}
		return modelView;
	}

	@RequestMapping(value = { "/addQuestion" }, method = RequestMethod.GET)
	public ModelAndView homePage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("AddQuestion");
		return model;

	}
	@RequestMapping(value = { "/saveQuestionAnswer" }, method = RequestMethod.POST)
	public @ResponseBody void saveQuestionAnswer(@RequestBody Question question) {
		
		QuestionModel questionModel = new QuestionModel();
		questionModel.setQuestionTitle(question.getQuestion());
		Integer savedQuestionModelId = questionManager.saveQuestion(
				questionModel, question.getSurveyId());
		
		List<String> answerModelList = question.getAnswers();
		AnswerModel answerModel = new AnswerModel();
		for (int i = 0; i < answerModelList.size(); i++) {
			if (answerModelList.get(i) != null && answerModelList.get(i) != "") {
				answerModel.setAnswerDesc(answerModelList.get(i));
				answerModel.setQuestion(questionModel);
				answerModel.getQuestion().setQuestionId(savedQuestionModelId);
				answerManager.saveAnswer(answerModel,
						questionModel.getQuestionId());
			}
		}
	}

	@RequestMapping(value = { "/addSurveyTitle" }, method = RequestMethod.GET)
	public ModelAndView addSurveyTitle() {
		ModelAndView model = new ModelAndView();
		model.setViewName("AddSurvey");
		return model;
	}

	@RequestMapping(value = { "/saveSurveyTitle" }, method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveSurveyTitle(
			@ModelAttribute SurveyModel surveyModel) {

		ModelAndView model = new ModelAndView();

		surveyManager.saveSurvey(surveyModel);
		model.addObject("surveyId", surveyModel.getSurveyId());
		model.setViewName("AddQuestion");
		return model;

	}

	@RequestMapping(value = { "/survey={surveyId}" }, method = RequestMethod.GET)
	public ModelAndView surveyDisplay(@PathVariable("surveyId") int surveyId) {

		ModelAndView model = new ModelAndView();

		List<QuestionModel> questionList = questionManager.getQuestionListBySurveyId(surveyId);

		model.addObject("questionList", questionList);
		model.addObject("surveyTitle",(surveyManager.findSurveyById(surveyId)).getSurveyTitle());
		model.setViewName("SurveyPoll");
		return model;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/savePoll", method = RequestMethod.POST)
	public @ResponseBody List savePoll(@RequestBody UserPoll pollObject) {

		ModelAndView model = new ModelAndView();
		PollModel pollModel = new PollModel();
		pollModel.setSurveyId(pollObject.getSurveyId());

		List<Integer> questionList = pollObject.getQuestions();
		List<Integer> answerList = pollObject.getAnswers();
		
		System.out.println("answers:" + answerList);
		System.out.println("questions:" +questionList);
		

		for (int i = 0; i < answerList.size(); i++) {

			System.out.println("Survey id" + pollObject.getSurveyId());

			pollModel.setAnswerId(answerList.get(i));
			System.out.println("answer being saved"+answerList.get(i));
			
			pollModel.setQuestionId(questionList.get(i));
			System.out.println("question being saved"+questionList.get(i));
			
			pollManager.savePoll(pollModel);
			System.out.println("Poll saved");
		
		}

		//data for highcharts
		List<QuestionModel> questionModelList = questionManager.getQuestionListBySurveyId(1);
		
		Long eachAnswerCount, userCount;
		List<AnswerModel> answerModelList;
		Double answerPollPercentage;
		String questionTitle, answerTitle = null;

	    List<HighChartData> HighChartDataList = new ArrayList<HighChartData>();
	   
		
	    
		
		for (int i = 0; i < questionModelList.size(); i++) {
			
			questionTitle=questionModelList.get(i).getQuestionTitle();
			answerModelList =  answerManager.getAnswerListByQuestionId(questionModelList.get(i).getQuestionId());
		
			List<String> categories=new ArrayList<String>();
			List<Double> series=new ArrayList<Double>();
			for (int j = 0; j < answerModelList.size(); j++) {
				
				answerTitle=answerModelList.get(j).getAnswerDesc();
				eachAnswerCount=pollManager.getEachAnserCountById(answerModelList.get(j).getAnswerId());
				userCount=pollManager.getCountOfUser(1)/(questionModelList.size());
				
				answerPollPercentage=(double)(eachAnswerCount/(double)userCount)*100;
				
				categories.add(answerTitle);
				series.add(answerPollPercentage);
				
				
			}
			HighChartData highChartData=new HighChartData();
			
			highChartData.setQuestionTitle(questionTitle);
			highChartData.setAnswerTitles(categories);
			highChartData.setCountPercentage(series);
			HighChartDataList.add(highChartData) ;
			
		}

		
		return HighChartDataList;
//		return highChartData;
	
//		model.addObject(highChartData);
//		model.setViewName("PollResult");
//		System.out.println(model);
//		return model;
	}
	
	
	
	
	
	@RequestMapping(value = "/chart", method = RequestMethod.GET)
	public ModelAndView getChartPage(){
		ModelAndView model=new ModelAndView();
		model.setViewName("chart");
		return model;
	}
	@RequestMapping(value = "/chart1", method = RequestMethod.GET)
	public @ResponseBody List analysisPage(@RequestParam("surveyId") int surveyId) {
	
		// data for highcharts
		List<QuestionModel> questionModelList = questionManager
				.getQuestionListBySurveyId(surveyId);
		Long eachAnswerCount, userCount;
		List<AnswerModel> answerModelList;
		Double answerPollPercentage;
		String questionTitle, answerTitle = null;
		List<HighChartData> HighChartDataList = new ArrayList<HighChartData>();
		for (int i = 0; i < questionModelList.size(); i++) {
			questionTitle = questionModelList.get(i).getQuestionTitle();
			answerModelList = answerManager
					.getAnswerListByQuestionId(questionModelList.get(i)
							.getQuestionId());
			List<String> categories = new ArrayList<String>();
			List<Double> series = new ArrayList<Double>();
			for (int j = 0; j < answerModelList.size(); j++) {
				answerTitle = answerModelList.get(j).getAnswerDesc();
				eachAnswerCount = pollManager
						.getEachAnserCountById(answerModelList.get(j)
								.getAnswerId());
				userCount = pollManager.getCountOfUser(surveyId)
						/ (questionModelList.size());
				answerPollPercentage = (double) (eachAnswerCount / (double) userCount) * 100;
				categories.add(answerTitle);
				series.add(answerPollPercentage);
			}
			HighChartData highChartData = new HighChartData();
			highChartData.setQuestionTitle(questionTitle);
			highChartData.setAnswerTitles(categories);
			highChartData.setCountPercentage(series);
			HighChartDataList.add(highChartData);
		}
		return HighChartDataList;
		
	}

}

