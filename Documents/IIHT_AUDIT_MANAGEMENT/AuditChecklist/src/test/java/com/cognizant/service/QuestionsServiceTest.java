package com.cognizant.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.model.QuestionsEntity;
import com.cognizant.repository.QuestionsRepository;

/**
 * 
 * This class contains test cases for the QuestionsService class which are
 * written using junit and mockito
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionsServiceTest {
	@Autowired
	QuestionsServiceImpl questionsService;
	@MockBean
	QuestionsRepository questionsRespository;

	/**
	 * test to check whether it returns a list
	 * 
	 * @throws IndexOutOfBoundsException
	 */
	@Test
	public void testGetQuestionsList() {
		List<QuestionsEntity> prepareGetQuestions = prepareGetQuestions();

		Mockito.when(questionsRespository.findByAuditType(Mockito.any())).thenReturn(prepareGetQuestions);
		assertEquals(prepareGetQuestions.get(0).getQuestion(),
				questionsService.getQuestions("Internal").get(0).getQuestion());
	}

	/**
	 * test questions when list throws IndexOutOfBoundsException
	 */


	private List<QuestionsEntity> prepareGetQuestions() {
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
