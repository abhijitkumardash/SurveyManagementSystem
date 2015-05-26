package com.survey.modules.controller;

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
import com.survey.modules.manager.QuestionManager;
import com.survey.modules.manager.QuestionManagerInterface;
import com.survey.modules.manager.SurveyManagerInterface;
import com.survey.modules.model.AnswerModel;
import com.survey.modules.model.Question;
import com.survey.modules.model.QuestionModel;
import com.survey.modules.model.SurveyModel;
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

	@RequestMapping(value={"/addSurveyTitle"},method = RequestMethod.GET)
	public ModelAndView addSurveyTitle(){
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
		// model.setViewName("redirect:" + "addQuestion");
		model.setViewName("AddQuestion");
		return model;

	}

	@RequestMapping(value = { "/survey={surveyId}" }, method = RequestMethod.GET)
	public ModelAndView surveyDisplay(@PathVariable("surveyId") int surveyId) {

		ModelAndView model = new ModelAndView();

		List<QuestionModel> questionList = questionManager
				.getQuestionListBySurveyId(surveyId);

		model.addObject("questionList", questionList);
		model.addObject("surveyTitle", (surveyManager.findSurveyById(surveyId)).getSurveyTitle());
		model.setViewName("SurveyPoll");
		return model;
	}

//	@RequestMapping(value = "/savePoll", method = RequestMethod.POST)
//	public ModelAndView savePoll(@RequestBody PollObject pollObject) {
//		
//		ModelAndView model = new ModelAndView();
//
//		model.setViewName("Poll Result");
//		return model;
//
//	}
}
