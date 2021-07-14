package com.codingdojo.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.services.AnswerService;
import com.codingdojo.dojooverflow.services.QuestionService;
import com.codingdojo.dojooverflow.services.TagService;

@Controller
public class HomeController {
	@Autowired
	private AnswerService aService;
	@Autowired
	private QuestionService qService;
	@Autowired
	private TagService tService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/questions";
	}
	
	@GetMapping("/questions")
	public String dashboard(Model viewModel) {
		viewModel.addAttribute("allQuestions", this.qService.AllQuestions());
		return "dashboard.jsp";
	}
	
	// New Question
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "newQuestion.jsp";
	}
	
	@PostMapping("/addQuestion")
	public String addQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result, 
			Model viewModel, @RequestParam(value="tagList") String tagList, @RequestParam(value="content") String content) {
		if (result.hasErrors()) {
			return "newQuestion.jsp";
		}
		List<String> convertedTagList = this.tService.convertTags(tagList.toLowerCase());
		List<String> convertedTagList2 = this.tService.convertTags(tagList.toLowerCase());
		this.tService.mergeTags(convertedTagList);
		question.setContent(content);
		question.setTags(this.tService.getTagList(convertedTagList2));
		
		this.qService.createQuestion(question);
		return "redirect:/questions";
	}
	
	@GetMapping("/questions/{id}")
	public String question(Model viewModel, @PathVariable("id") Long id) {
		viewModel.addAttribute("question", this.qService.getOneQuestion(id));
		viewModel.addAttribute("answer", new Answer());
		return "question.jsp";
	}
	
	@PostMapping("/addAnswer")
	public String addAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult result, Model viewModel, @RequestParam(value="question.id") Long id) {
		if (result.hasErrors()) {
			return "question.jsp";
		}
		
		answer.setQuestion(this.qService.getOneQuestion(id));
		this.aService.createAnswer(answer);
		return "redirect:/questions/" + id;
	}
}
