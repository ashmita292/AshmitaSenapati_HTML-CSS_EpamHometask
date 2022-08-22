package com.cognizant.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.Controller.AuditCheckListController;
import com.cognizant.service.QuestionsServiceImpl;
import com.cognizant.service.TokenServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuditChecklistControllerTest2 {

	@Autowired
	TokenServiceImpl tokenService;
	@Autowired
	AuditCheckListController auditChecklistController;
	@MockBean
	QuestionsServiceImpl questionsService;
	@Autowired
	private MockMvc mvc;


	private String token1= "token";
	 @Test
    public void testGetChecklist() throws Exception {
       ResultActions actions =mvc.perform(get("/getChecklist?auditType=Internal")
                .header("Authorization", token1));
       actions.andExpect(status().isOk());
    }
	 
	
}
