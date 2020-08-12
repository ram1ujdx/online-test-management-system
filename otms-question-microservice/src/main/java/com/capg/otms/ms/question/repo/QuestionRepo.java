package com.capg.otms.ms.question.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.otms.ms.question.model.Question;

public interface QuestionRepo extends JpaRepository<Question, Long> {

}
