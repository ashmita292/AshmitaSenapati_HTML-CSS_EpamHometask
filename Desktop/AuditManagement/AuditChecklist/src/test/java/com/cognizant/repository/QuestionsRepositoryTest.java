package com.cognizant.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.model.QuestionsEntity;
import com.cognizant.service.QuestionsServiceImpl;

@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest
public class QuestionsRepositoryTest {

	@Autowired
	QuestionsServiceImpl service;
	
	@MockBean
	QuestionsRepository questionsRepository;
	
//	@Test
//	public void findByAuditTypeTest() {
//		List<QuestionsEntity> questionsEntity = prepareQuestionsEntity();
//		Mockito.when(questionsRepository.findByAuditType(Mockito.any())).thenReturn(questionsEntity);
//		assertEquals("Internal", questionsEntity.get(0).getAuditType());
//	}
	
	private List<QuestionsEntity> prepareQuestionsEntity() {
		List<QuestionsEntity> questions = new ArrayList<>();
		QuestionsEntity question = new QuestionsEntity();
		question.setQuestionId(1);
		question.setAuditType("Internal");
		question.setQuestion("Have all Change requests followed SDLC before PROD move?");
		question.setResponse("Yes");
		
		questions.add(question);
		return questions;
	}
}
