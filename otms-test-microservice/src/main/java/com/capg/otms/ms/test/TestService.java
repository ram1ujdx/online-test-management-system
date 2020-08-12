package com.capg.otms.ms.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.otms.ms.test.model.Question;
import com.capg.otms.ms.test.model.Test;
import com.capg.otms.ms.test.repo.TestRepo;

@Service
public class TestService {
	
	@Autowired
	RestTemplate rt;

	@Autowired
	TestRepo testRepo;
	
	public Test addTest(Test test) {
		return testRepo.save(test);
		}
	
	public Test fetchTestInfo(long testId) {
		return testRepo.getOne(testId);
	}
	
	public void addQuestion(long testId,long questionId) {
		Test test=testRepo.getOne(testId);
		test.getTestQuestions().add(questionId);
		testRepo.save(test);
		
	}
	

	
	public void checkAnswer(long testId,int choosenAnswer) {
		Test test=testRepo.getOne(testId);
		long currentQuestion=test.getCurrentQuestion();
		Question question=rt.getForObject("http://localhost:8300/questions/id/"+currentQuestion,
													Question.class);
		if(choosenAnswer==question.getQuestionAnswer()) {
			
			test.setTestMarksScored(test.getTestMarksScored()+question.getQuestionMarks());
			testRepo.save(test);
		}
	}
	
}
