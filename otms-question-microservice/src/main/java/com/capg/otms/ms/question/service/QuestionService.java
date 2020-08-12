package com.capg.otms.ms.question.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.otms.ms.question.model.Question;
import com.capg.otms.ms.question.repo.QuestionRepo;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepo questionRepo;
	
	public Question addQuestion(Question question) {
		return questionRepo.save(question);
	}
	
	public Question getQuestion(long questionId) {
		return questionRepo.getOne(questionId);
	}
	
	
	
	
}
